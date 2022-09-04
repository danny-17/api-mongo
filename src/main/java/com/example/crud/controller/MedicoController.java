package com.example.crud.controller;

import com.example.crud.entity.Medico;
import com.example.crud.service.MedicoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico")

public class MedicoController {

    @Autowired
    MedicoServiceImp medicoS;

    @GetMapping("/listar")
    public ResponseEntity<List<Medico>> listar() {
        return new ResponseEntity<>(medicoS.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Medico> crear(@RequestBody Medico p) {
        return new ResponseEntity<>(medicoS.save(p), HttpStatus.CREATED);
    }

    @DeleteMapping("/elimar/{id}")
    public ResponseEntity<Medico> eliminar(@PathVariable Long id) {
        medicoS.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Medico> actualizarMedicamento(@PathVariable Integer id, @RequestBody Medico m) {
        Medico medico = medicoS.findById(Long.valueOf(id));
        if (medico == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                medico.setNombre(m.getNombre());
                medico.setApellido(m.getApellido());
                medico.setEspecialidad(m.getEspecialidad());
                medico.setEdad(m.getEdad());
                medico.setLocalidad(m.getLocalidad());
                return new ResponseEntity<>(medicoS.save(m), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

}
