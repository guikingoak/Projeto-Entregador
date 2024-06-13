package com.example.demo.controller;

import com.example.demo.model.Entregador;
import com.example.demo.service.EntregadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/entregadores")
public class EntregadorController {

    @Autowired
    private EntregadorService entregadorService;

    @GetMapping
    public String getAllEntregadores(Model model) {
        List<Entregador> entregadores = entregadorService.getAllEntregadores();
        model.addAttribute("entregadores", entregadores);
        return "entregadores"; // Nome do template Thymeleaf (entregadores.html)
    }

    @GetMapping("/{id}")
    public String getEntregadorById(@PathVariable Long id, Model model) {
        Entregador entregador = entregadorService.getEntregadorById(id);
        model.addAttribute("entregador", entregador);
        return "entregador"; // Nome do template Thymeleaf (entregador.html)
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("entregador", new Entregador());
        return "create-entregador"; // Nome do template Thymeleaf (create-entregador.html)
    }

    @PostMapping
    public String createEntregador(@ModelAttribute Entregador entregador) {
        entregadorService.createEntregador(entregador);
        return "redirect:/entregadores";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Entregador entregador = entregadorService.getEntregadorById(id);
        model.addAttribute("entregador", entregador);
        return "update-entregador"; // Nome do template Thymeleaf (update-entregador.html)
    }

    @PostMapping("/{id}")
    public String updateEntregador(@PathVariable Long id, @ModelAttribute Entregador entregador) {
        entregadorService.updateEntregador(id, entregador);
        return "redirect:/entregadores";
    }

    @PostMapping("/{id}/delete")
    public String deleteEntregador(@PathVariable Long id) {
        entregadorService.deleteEntregador(id);
        return "redirect:/entregadores";
    }
}
