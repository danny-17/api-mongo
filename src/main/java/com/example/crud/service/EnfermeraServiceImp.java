package com.example.crud.service;

import com.example.crud.entity.Enfermera;
import com.example.crud.entity.Medico;
import com.example.crud.repository.EnfermeraRepository;
import com.example.crud.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class EnfermeraServiceImp extends ServicioGenericImp<Enfermera, Long> implements EnfermeraService{
    @Autowired
    EnfermeraRepository enfermeraR;

    @Override
    public CrudRepository<Enfermera, Long> getDao(){
        return enfermeraR;
    }
}
