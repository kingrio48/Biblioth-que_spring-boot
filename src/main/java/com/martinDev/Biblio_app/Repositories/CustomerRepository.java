package com.martinDev.Biblio_app.Repositories;

import com.martinDev.Biblio_app.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
