package com.github.csankhala.Main.Repository;

import com.github.csankhala.Main.Entity.Customer;
import com.github.csankhala.Main.Exceptions.UserNotFoundException;

public interface ICustomerRepository {

    public Customer addCustomer(int id, String name, String address);

    public Customer getCustomer(int id) throws UserNotFoundException;

    public String deleteCustomer(int id) throws UserNotFoundException;

}
