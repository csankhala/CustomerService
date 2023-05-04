package com.github.csankhala;

import io.micronaut.http.annotation.*;

@Controller("/customerService")
public class CustomerServiceController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}