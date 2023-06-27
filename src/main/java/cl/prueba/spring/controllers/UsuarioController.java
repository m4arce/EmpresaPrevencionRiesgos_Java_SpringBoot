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

import cl.prueba.spring.model.Usuario;
import cl.prueba.spring.services.UsuarioService;



@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/lista-usuarios")
    public String usuario (Model model) {        
        List<Usuario> usuarios = usuarioService.listarUsuario();
        model.addAttribute("usuarios", usuarios);
        return "listaUsuario";
    }

    @GetMapping("/crear-usuario")
    public String crear (Usuario usuario){
        return "crearUsuario";
    }

    @PostMapping("/guardar-usuario")
    public String guardar (@Valid @ModelAttribute Usuario usuario, Errors errores){
        if (errores.hasErrors()) {
            return "crearUsuario";
        }
        usuarioService.guardar(usuario);
        return "redirect:/lista-usuarios";
    }

    @GetMapping("/editar-usuario/{idusuario}")
    public String editar (@ModelAttribute Usuario usuario, Model model){
        usuario = usuarioService.encontrarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "crearUsuario";
    }
    
    @GetMapping("/eliminar-usuario")
    public String eliminar (Usuario usuario) {
        usuarioService.eliminar(usuario);
        return "redirect:/lista-usuarios";
    }
}