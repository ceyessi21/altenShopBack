package com.example.altenshop;

import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.ResourceBundle;

@Service
@AllArgsConstructor
public class ProductService {
    @Autowired
    private final ProductRepository repository;

    @Autowired
    private ResourceLoader resourceLoader;

    @PostConstruct
    public void init(){
         try {
            Resource resource = resourceLoader.getResource("classpath:products.json");
            InputStream inputStream = resource.getInputStream();
            ObjectMapper objectMapper = new ObjectMapper();
            List<Product> products = objectMapper.readValue(inputStream, new TypeReference<List<Product>>() {});
            repository.saveAll(products);
        } catch (IOException e) {
            throw new RuntimeException("Error reading products.json", e);
        }

    }

    void deleteById(List<Long> ids) {
        repository.deleteById(ids);
    }

    List<Product> getAll(){
        return repository.findAll();
    }

    Product getProduct(Long id){
        return repository.findById(id).orElse(null);
    }

    Product create(Product p) {
        return repository.save(p);
    }

    Product update(Product p) {
        return repository.save(p);
    }

    void delete(Long id) {
        repository.deleteById(id);
    }


}
