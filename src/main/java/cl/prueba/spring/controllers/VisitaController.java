package cl.prueba.spring.controllers;


import cl.prueba.spring.model.Visita;
import cl.prueba.spring.services.VisitaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import javax.validation.Valid;

@Controller

public class VisitaController {

    @Autowired
    private VisitaService visitaService;

    @GetMapping("/lista-visitas")
    public String visita (Model model) {        
        List<Visita> visitas = visitaService.listarVisita();
        model.addAttribute("visitas", visitas);
        return "listaVisita";
    }

    @GetMapping("/crear-visita")
    public String crear (Visita visita){
        return "crearVisita";
    }

    @PostMapping("/guardar-visita")
    public String guardar (@Valid @ModelAttribute Visita visita, Errors errores){
        if (errores.hasErrors()) {
            return "crearVisita";
        }
        visitaService.guardar(visita);
        return "redirect:/";
    }

    @GetMapping("/editar-visita/{idvisita}")
    public String editar (@ModelAttribute Visita visita, Model model){
        visita = visitaService.encontrarVisita(visita);
        model.addAttribute("visita", visita);
        return "crearVisita";
    }
    
    @GetMapping("/eliminar-visita")
    public String eliminar (Visita visita) {
        visitaService.eliminar(visita);
        return "redirect:/listaVisita";
    }
}
