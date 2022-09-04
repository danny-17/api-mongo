package com.example.crud.service;

import com.example.crud.entity.Medico;
import com.example.crud.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicoServiceImp extends ServicioGenericImp<Medico, Long> implements MedicoService{

    @Autowired
    MedicoRepository medicoR;

    @Override
    public CrudRepository<Medico, Long>getDao(){
        return medicoR;
    }

}
