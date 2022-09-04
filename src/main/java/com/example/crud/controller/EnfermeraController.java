package com.example.crud.controller;

import com.example.crud.entity.Enfermera;
import com.example.crud.entity.Medico;
import com.example.crud.service.EnfermeraServiceImp;
import com.example.crud.service.MedicoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enfermera")

public class EnfermeraController {

    @Autowired
    EnfermeraServiceImp enfermeraS;

    @GetMapping("/listar")
    public ResponseEntity<List<Enfermera>> listar() {
        return new ResponseEntity<>(enfermeraS.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Enfermera> crear(@RequestBody Enfermera m) {
        return new ResponseEntity<>(enfermeraS.save(m), HttpStatus.CREATED);
    }

    @DeleteMapping("/elimar/{id}")
    public ResponseEntity<Enfermera> eliminar(@PathVariable Long id) {
        enfermeraS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
