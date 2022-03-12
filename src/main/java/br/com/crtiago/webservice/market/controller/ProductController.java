package br.com.crtiago.webservice.market.controller;


import br.com.crtiago.webservice.market.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ProductController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/product")
    public Product getProduct(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Product(counter.incrementAndGet(), String.format(template, name));
    }
}