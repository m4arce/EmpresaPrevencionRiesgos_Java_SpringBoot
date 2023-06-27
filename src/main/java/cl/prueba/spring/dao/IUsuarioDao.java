package cl.prueba.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import cl.prueba.spring.model.Usuario;


public interface IUsuarioDao extends JpaRepository<Usuario, Long> {
	Usuario findByNombreusuario (String nombreusuario);	

}
