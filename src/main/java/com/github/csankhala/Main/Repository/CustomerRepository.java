package com.github.csankhala.Main.Repository;

import com.github.csankhala.Main.Entity.Customer;
import com.github.csankhala.Main.Exceptions.UserNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepository implements ICustomerRepository {
    private final Map<Integer, Customer> customers = new HashMap<>();

    @Override
    public Customer addCustomer(int id, String name, String address) {
        Customer customer = new Customer(id, name, address);
        customers.put(id, customer);
        return customer;
    }

    @Override
    public Customer getCustomer(int id) throws UserNotFoundException {
        Customer customer = customers.get(id);
        if (customer != null)
            return customer;
        else {
            throw new UserNotFoundException(id);
        }
    }

    @Override
    public String deleteCustomer(int id) throws UserNotFoundException {
        Customer customer = customers.get(id);
        if (customer == null) {
            throw new UserNotFoundException(id);
        }
        customers.remove(id);
        return "Customer with ID " + id + " is deleted from the customer database.";
    }
}
