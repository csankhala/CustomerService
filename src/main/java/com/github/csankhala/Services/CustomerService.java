package com.github.csankhala.Main.Services;

import com.github.csankhala.Main.Entity.Customer;
import com.github.csankhala.Main.Exceptions.UserNotFoundException;
import com.github.csankhala.Main.Repository.ICustomerRepository;

public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository;

    @Override
    public Customer createCustomer(int id, String name, String address) {
        return customerRepository.addCustomer(id, name, address);
    }

    @Override
    public Customer getCustomer(int id) throws UserNotFoundException {
        return customerRepository.getCustomer(id);
    }


    @Override
    public String deleteCustomer(int id) throws UserNotFoundException {
        return customerRepository.deleteCustomer(id);
    }
}
