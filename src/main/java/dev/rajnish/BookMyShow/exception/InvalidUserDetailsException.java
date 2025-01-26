package dev.rajnish.BookMyShow.exception;

public class InvalidUserDetailsException extends RuntimeException {

    public InvalidUserDetailsException()
    {

    }

    public InvalidUserDetailsException(String message)
    {
        super(message);
    }     
}
