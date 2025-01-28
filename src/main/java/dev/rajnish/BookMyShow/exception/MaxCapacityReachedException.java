package dev.rajnish.BookMyShow.exception;

public class MaxCapacityReachedException extends RuntimeException {

    public MaxCapacityReachedException()
    {

    }

    public MaxCapacityReachedException(String message)
    {
        super(message);
    }    
}
