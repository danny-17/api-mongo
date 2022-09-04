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

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Enfermera> actualizarMedicamento(@PathVariable Integer id, @RequestBody Enfermera m) {
        Enfermera enfermera = enfermeraS.findById(Long.valueOf(id));
        if (enfermera == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                enfermera.setNombre(m.getNombre());
                enfermera.setAñosExp(m.getAñosExp());
                enfermera.setTitulo(m.getTitulo());
                enfermera.setEdad(m.getEdad());
                return new ResponseEntity<>(enfermeraS.save(m), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

}
