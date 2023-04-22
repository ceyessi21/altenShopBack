package com.example.altenshop;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/list")
    public List<Product> getAll() {
        return service.getAll();
    }

    @PostMapping
    public void deleteByIds(@RequestBody List<Long> ids){ service.deleteById(ids);}

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") Long id){return service.getProduct(id);}

    @PostMapping("/create")
    public Product create(@RequestBody Product p) { return service.create(p); }

    @PutMapping("/update")
    public Product update(@RequestBody Product p){ return service.update(p);}

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) { service.delete(id); }







}
