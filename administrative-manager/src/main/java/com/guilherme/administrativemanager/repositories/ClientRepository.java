package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
