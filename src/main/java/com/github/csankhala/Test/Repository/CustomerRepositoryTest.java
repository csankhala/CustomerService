package com.github.csankhala.Test.Repository;

import com.github.csankhala.Main.Entity.Customer;
import com.github.csankhala.Main.Exceptions.UserNotFoundException;
import com.github.csankhala.Main.Services.CustomerService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerRepositoryTest {
    private CustomerService customerService;

    @Before
    public void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void createCustomerShouldAddCustomerToCustomers() {
        String name = "Rohit Sharma";
        String address = "Mumbai Worli";
        String expectedMessage = "Customer added with Customer ID:1";
        int id=1;
        String actualMessage = customerService.createCustomer(id,name, address);

        assertEquals(expectedMessage, actualMessage);
        assertNotNull(customerService.getCustomer(1));
    }
    @Test
    public void createCustomerShouldAddCustomerToCustomersTestTwo() {
        String name = "Virat Kohli";
        String address = "West Delhi Punjabi Bagh";
        int id=2;
        String expectedMessage = "Customer added with Customer ID:2";

        String actualMessage = customerService.createCustomer(id,name, address);

        assertEquals(expectedMessage, actualMessage);
        assertNotNull(customerService.getCustomer(2));
    }

    @Test
    public void getCustomerShouldReturnCustomerWithMatchingId() throws UserNotFoundException {
        String name = "Virat Kohli";
        String address = "West Delhi Punjabi Bagh";
        int id=2;
        Customer expectedCustomer = new Customer(id, name, address);
        customerService.createCustomer(id,name, address);

        Customer actualCustomer = customerService.getCustomer(2);

        assertEquals(expectedCustomer, actualCustomer);
    }

    @Test(expected = UserNotFoundException.class)
    public void getCustomerShouldThrowUserNotFoundExceptionIfCustomerNotFound() throws UserNotFoundException {
        customerService.getCustomer(1);
    }

    @Test
    public void deleteCustomerShouldRemoveCustomerFromCustomers() throws UserNotFoundException {
        String name = "Virat Kohli";
        String address = "West Delhi Punjabi Bagh";
        int id =2;
        customerService.createCustomer(id,name, address);

        String expectedMessage = "Customer with ID 2 is deleted from the customer database.";
        String actualMessage = customerService.deleteCustomer(2);

        assertEquals(expectedMessage, actualMessage);
//        assertNull(customerService.getCustomer(2));
    }

    @Test(expected = UserNotFoundException.class)
    public void deleteCustomerShouldThrowUserNotFoundExceptionIfCustomerNotFound() throws UserNotFoundException {
        customerService.deleteCustomer(1);
    }
}
