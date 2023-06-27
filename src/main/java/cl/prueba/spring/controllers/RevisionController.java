package cl.prueba.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import cl.prueba.spring.model.Revision;
import cl.prueba.spring.services.RevisionService;




@Controller
public class RevisionController {

    @Autowired
    private RevisionService revisionService;

    @GetMapping("/lista-revisiones")
    public String revision (Model model) {        
        List<Revision> revisiones = revisionService.listarRevision();
        model.addAttribute("revisiones", revisiones);
        return "listaRevision";
    }

    @GetMapping("/crear-revision")
    public String crear (Revision revision){
        return "crearRevision";
    }

    @PostMapping("/guardar-revision")
    public String guardar (@Valid @ModelAttribute Revision revision, Errors errores){
        if (errores.hasErrors()) {
            return "crearRevision";
        }
        revisionService.guardar(revision);
        return "redirect:/lista-revisiones";
    }

    @GetMapping("/editar-revision/{idrevision}")
    public String editar (@ModelAttribute Revision revision, Model model){
        revision = revisionService.encontrarRevision(revision);
        model.addAttribute("revision", revision);
        return "crearRevision";
    }
    
    @GetMapping("/eliminar-revision")
    public String eliminar (Revision revision) {
        revisionService.eliminar(revision);
        return "redirect:/lista-revisiones";
    }
}