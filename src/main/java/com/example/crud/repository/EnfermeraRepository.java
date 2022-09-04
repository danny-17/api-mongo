package com.example.crud.repository;

import com.example.crud.entity.Enfermera;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnfermeraRepository extends MongoRepository<Enfermera, Long> {
}
