package com.gestaoCash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoCash.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
