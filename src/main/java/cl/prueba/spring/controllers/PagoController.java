package cl.prueba.spring.controllers;


import cl.prueba.spring.model.Pago;
import cl.prueba.spring.services.PagoService;

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

public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/lista-pagos")
    public String pago (Model model) {        
        List<Pago> pagos = pagoService.listarPago();
        model.addAttribute("pagos", pagos);
        return "listaPago";
    }

    @GetMapping("/crear-pago")
    public String crear (Pago pago){
        return "crearPago";
    }

    @PostMapping("/guardar-pago")
    public String guardar (@Valid @ModelAttribute Pago pago, Errors errores){
        if (errores.hasErrors()) {
            return "crearPago";
        }
        pagoService.guardar(pago);
        return "redirect:/";
    }

    @GetMapping("/editar-pago/{idpago}")
    public String editar (@ModelAttribute Pago pago, Model model){
        pago = pagoService.encontrarPago(pago);
        model.addAttribute("pago", pago);
        return "crearPago";
    }
    
    @GetMapping("/eliminar-pago")
    public String eliminar (Pago pago) {
        pagoService.eliminar(pago);
        return "redirect:/listaPago";
    }
}
