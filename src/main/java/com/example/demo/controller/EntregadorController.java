package com.example.demo.controller;

import com.example.demo.model.Entregador;
import com.example.demo.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public List<Entregador> getAllEntregadores() {
        return entregadorService.getAllEntregadores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entregador> getEntregadorById(@PathVariable Long id) {
        Entregador entregador = entregadorService.getEntregadorById(id);
        return ResponseEntity.ok(entregador);
    }

    @PostMapping
    public ResponseEntity<Entregador> createEntregador(@RequestBody Entregador entregador) {
        Entregador createdEntregador = entregadorService.createEntregador(entregador);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEntregador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entregador> updateEntregador(@PathVariable Long id, @RequestBody Entregador entregador) {
        Entregador updatedEntregador = entregadorService.updateEntregador(id, entregador);
        return ResponseEntity.ok(updatedEntregador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntregador(@PathVariable Long id) {
        entregadorService.deleteEntregador(id);
        return ResponseEntity.noContent().build();
    }
}
