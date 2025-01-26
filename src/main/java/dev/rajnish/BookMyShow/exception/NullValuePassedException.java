package dev.rajnish.BookMyShow.exception;

public class NullValuePassedException extends RuntimeException {

    public NullValuePassedException()
    {

    }

    public NullValuePassedException(String message)
    {
        super(message);
    }    
}
