package com.github.csankhala.model;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Serdeable // JSON serialization/deserialization ke liye mandatory hai
@Introspected // Bean metadata generate karne ke liye (Performance boost)
public class Customer {

    @Nullable // ID starting mein null ho sakti hai (jab hum generate karenge)
    private String id;

    @NotBlank(message = "Name cannot be empty")
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank(message = "Address is required")
    private String address;

    // 1. Default Constructor (Micronaut Serde ko iski zarurat hoti hai)
    public Customer() {
    }

    // 2. Full Constructor
    public Customer(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    // 3. Getters aur Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}