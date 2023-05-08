package com.github.csankhala.Main.Exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }

    public UserNotFoundException(int customerId) {
        super("Customer with ID " + customerId + " not found.");
    }
}
