package com.github.csankhala.Main.Services;

import com.github.csankhala.Main.Entity.Customer;
import com.github.csankhala.Main.Exceptions.UserNotFoundException;

public interface ICustomerService {
    Customer createCustomer(int id, String name, String address);

    // get a customer by id
    Customer getCustomer(int id) throws UserNotFoundException;

    // delete a customer by id
    String deleteCustomer(int id) throws UserNotFoundException;
}
