package mk.ukim.finki.elibrary.elibrary.service.Impl;

import mk.ukim.finki.elibrary.elibrary.model.Author;
import mk.ukim.finki.elibrary.elibrary.model.Book;
import mk.ukim.finki.elibrary.elibrary.model.dto.BookDto;
import mk.ukim.finki.elibrary.elibrary.model.exceptions.AuthorNotFoundException;
import mk.ukim.finki.elibrary.elibrary.model.exceptions.BookNotFoundException;
import mk.ukim.finki.elibrary.elibrary.repository.AuthorRepository;
import mk.ukim.finki.elibrary.elibrary.repository.BookRepository;
import mk.ukim.finki.elibrary.elibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()-> new AuthorNotFoundException(bookDto.getAuthorId()));
        Book book = new Book(bookDto.getName(),bookDto.getCategory(),author,bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public Optional<Book> edit(Long id, BookDto bookDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
        Author author = this.authorRepository.findById(bookDto.getAuthorId())
                .orElseThrow(()-> new AuthorNotFoundException(bookDto.getAuthorId()));
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());
        return Optional.of(this.bookRepository.save(book));
    }

    @Override
    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }


    @Override
    public Optional<Book> markAsTaken(Long id) {
//        Book book = this.bookRepository.findById(id).orElseThrow(()->new BookNotFoundException(id));
//        Author author = this.authorRepository.findById(book.getAuthor().getId())
//                .orElseThrow(()-> new AuthorNotFoundException(book.getAuthor().getId()));
//        book.setName(book.getName());
//        book.setCategory(book.getCategory());
//        book.setAuthor(author);
//        if(book.getAvailableCopies()-1 > 0){
//            book.setAvailableCopies(book.getAvailableCopies()-1);
//            return Optional.of(this.bookRepository.save(book));
//        } else {
//            throw new RuntimeException();
//        }

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));

        book.setAvailableCopies(book.getAvailableCopies()-1);
        this.bookRepository.save(book);
        return Optional.of(book);
    }
}
