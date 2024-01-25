package com.gestaoCash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaoCash.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
