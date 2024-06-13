package com.example.demo.service;

import com.example.demo.model.Entregador;
import com.example.demo.repository.EntregadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregadorServiceImpl implements EntregadorService {

    @Autowired
    private EntregadorRepository entregadorRepository;

    @Override
    public List<Entregador> getAllEntregadores() {
        return entregadorRepository.findAll();
    }

    @Override
    public Entregador getEntregadorById(Long id) {
        return entregadorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Entregador not found"));
    }

    @Override
    public Entregador createEntregador(Entregador entregador) {
        return entregadorRepository.save(entregador);
    }

    @Override
    public Entregador updateEntregador(Long id, Entregador entregador) {
        Entregador existingEntregador = getEntregadorById(id);
        existingEntregador.setNome(entregador.getNome());
        existingEntregador.setTelefone(entregador.getTelefone());
        return entregadorRepository.save(existingEntregador);
    }

    @Override
    public void deleteEntregador(Long id) {
        Entregador entregador = getEntregadorById(id);
        entregadorRepository.delete(entregador);
    }
}
