package cl.prueba.spring.controllers;

/*import java.util.List;*/

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*import org.springframework.ui.Model;*/
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.prueba.spring.model.Contacto;
import cl.prueba.spring.services.ContactoService;


@Controller
public class ContactoController {

    @Autowired
    private ContactoService contactoService;

    /*@GetMapping("/lista-contactos")
    public String contacto (Model model) {        
        List<Contacto> contactos = contactoService.listarContacto();
        model.addAttribute("contactos", contactos);
        return "listaContacto";
    }*/

    @GetMapping("/contacto")
    public String crear (Contacto contacto){
        return "crearContacto";
    }

    @PostMapping("/guardar-contacto")
    public String guardar (@Valid @ModelAttribute Contacto contacto, Errors errores){
        if (errores.hasErrors()) {
            return "crearUsuario";
        }
        contactoService.guardar(contacto);
        return "redirect:/";
    }

    /*@GetMapping("/editar-contacto/{idcontacto}")
    public String editar (@ModelAttribute Contacto contacto, Model model){
        contacto = contactoService.encontrarContacto(contacto);
        model.addAttribute("contacto", contacto);
        return "crearContacto";
    }*/
    
    /*@GetMapping("/eliminar-contacto")
    public String eliminar (Contacto contacto) {
        contactoService.eliminar(contacto);
        return "redirect:/listaContacto";
    }*/

}
