package com.example.hexagonal.infrastructure.repository;

import com.example.hexagonal.infrastructure.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPersonRepository extends JpaRepository<PersonEntity, Integer> {
}
