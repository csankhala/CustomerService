package com.github.csankhala.repository;

import com.github.csankhala.model.Customer;
import jakarta.inject.Singleton;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Singleton // Isse poore app mein sirf ek hi "Memory" rahegi
public class CustomerRepository {

    // Humara in-memory database
    private final Map<String, Customer> customers = new ConcurrentHashMap<>();

    // 1. Create Customer
    public Customer save(Customer customer) {
        if (customer.getId() == null || customer.getId().isBlank()) {
            customer.setId(UUID.randomUUID().toString()); // Unique ID generate karna
        }
        customers.put(customer.getId(), customer);
        return customer;
    }

    // 2. Get Customer by ID
    public Optional<Customer> findById(String id) {
        return Optional.ofNullable(customers.get(id));
    }

    // 3. Delete Customer
    public void delete(String id) {
        customers.remove(id);
    }

    // 4. List all (Optional but helpful)
    public Collection<Customer> findAll() {
        return customers.values();
    }
}