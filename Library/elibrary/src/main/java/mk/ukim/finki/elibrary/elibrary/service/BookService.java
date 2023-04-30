package mk.ukim.finki.elibrary.elibrary.service;

import mk.ukim.finki.elibrary.elibrary.model.Book;
import mk.ukim.finki.elibrary.elibrary.model.dto.BookDto;
import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> listAll();

    Optional<Book> findById(Long id);

    Optional<Book> markAsTaken(Long id);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id,BookDto bookDto);

    void deleteById(Long id);

}
