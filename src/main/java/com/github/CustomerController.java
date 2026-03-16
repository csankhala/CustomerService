package com.github.csankhala;

import com.github.csankhala.model.Customer;
import com.github.csankhala.repository.CustomerRepository;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import javax.validation.Valid;
import java.util.Collection;

@Controller("/customers")
public class CustomerController {

    private final CustomerRepository repository;

    // Constructor Injection
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    // 1. Create Customer with Validation
    @Post("/")
    @Status(HttpStatus.CREATED)
    public Customer create(@Body @Valid Customer customer) {
        return repository.save(customer);
    }

    // 2. Get Customer (With proper 404 handling)
    @Get("/{id}")
    public HttpResponse<Customer> get(String id) {
        return repository.findById(id)
                .map(HttpResponse::ok) // Agar mila toh 200 OK
                .orElse(HttpResponse.notFound()); // Nahi mila toh 404 Not Found
    }

    // 3. Delete Customer
    @Delete("/{id}")
    @Status(HttpStatus.NO_CONTENT)
    public void delete(String id) {
        repository.delete(id);
    }

    // 4. List All Customers
    @Get("/")
    public Collection<Customer> listAll() {
        return repository.findAll();
    }
}