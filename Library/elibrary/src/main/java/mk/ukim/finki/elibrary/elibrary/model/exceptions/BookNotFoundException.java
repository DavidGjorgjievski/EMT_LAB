package mk.ukim.finki.elibrary.elibrary.model.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(Long id) {
        super(String.format("Book with id %d was not found!",id));
    }
}
