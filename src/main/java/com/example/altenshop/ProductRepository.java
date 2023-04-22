package com.example.altenshop;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Product WHERE id IN ?1")
    void deleteById(List<Long> ids);
}
