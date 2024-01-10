package com.gestaocash.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestaocash.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
