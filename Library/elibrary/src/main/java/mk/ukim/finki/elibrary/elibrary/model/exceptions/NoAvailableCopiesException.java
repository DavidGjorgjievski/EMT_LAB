package mk.ukim.finki.elibrary.elibrary.model.exceptions;

public class NoAvailableCopiesException extends RuntimeException{

    public NoAvailableCopiesException() {
        super("No available copies in this book!");
    }
}