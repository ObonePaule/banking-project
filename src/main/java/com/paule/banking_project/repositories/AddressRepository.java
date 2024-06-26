package com.paule.banking_project.repositories;

import com.paule.banking_project.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
