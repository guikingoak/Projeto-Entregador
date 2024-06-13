package com.example.demo.service;

import com.example.demo.model.Entregador;

import java.util.List;

public interface EntregadorService {

    List<Entregador> getAllEntregadores();

    Entregador getEntregadorById(Long id);

    Entregador createEntregador(Entregador entregador);

    Entregador updateEntregador(Long id, Entregador entregador);

    void deleteEntregador(Long id);
}
