package dev.rajnish.BookMyShow.exception;

public class InvalidDetailsException extends RuntimeException {

    public InvalidDetailsException()
    {

    }

    public InvalidDetailsException(String message)
    {
        super(message);
    }     
}
