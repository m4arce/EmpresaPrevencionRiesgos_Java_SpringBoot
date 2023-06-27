package cl.prueba.spring.controllers;

import cl.prueba.spring.model.Capacitacion;
import cl.prueba.spring.services.CapacitacionService;
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

public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;

    @GetMapping("/lista-capacitaciones")
    public String capacitacion (Model model) {        
        List<Capacitacion> capacitaciones = capacitacionService.listarCapacitacion();
        model.addAttribute("capacitaciones", capacitaciones);
        return "listaCapacitacion";
    }

    @GetMapping("/crear-capacitacion")
    public String crear (Capacitacion capacitacion){
        return "crearCapacitacion";
    }

    @PostMapping("/guardar-capacitacion")
    public String guardar (@Valid @ModelAttribute Capacitacion capacitacion, Errors errores){
        if (errores.hasErrors()) {
            return "crearCapacitacion";
        }
        capacitacionService.guardar(capacitacion);
        return "redirect:/";
    }

    @GetMapping("/editar-capacitacion/{idcapacitaciones}")
    public String editar (@ModelAttribute Capacitacion capacitacion, Model model){
        capacitacion = capacitacionService.encontrarCapacitacion(capacitacion);
        model.addAttribute("capacitacion", capacitacion);
        return "crearCapacitacion";
    }
    
    @GetMapping("/eliminar-capacitacion")
    public String eliminar (Capacitacion capacitacion) {
        capacitacionService.eliminar(capacitacion);
        return "redirect:/listaCapacitacion";
    }
}
