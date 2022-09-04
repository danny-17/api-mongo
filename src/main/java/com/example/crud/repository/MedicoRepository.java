package com.example.crud.repository;

import com.example.crud.entity.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicoRepository extends MongoRepository<Medico, Long> {
}
