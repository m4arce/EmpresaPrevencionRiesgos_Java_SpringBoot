package cl.prueba.spring.services;

import java.util.List;

import cl.prueba.spring.model.Usuario;



public interface UsuarioService {
	
	public List<Usuario> listarUsuario();

    public void guardar(Usuario usuario);

    public void eliminar(Usuario usuario);

    public Usuario encontrarUsuario(Usuario usuario);

	

}
