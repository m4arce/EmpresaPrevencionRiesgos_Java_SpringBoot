package cl.prueba.spring.dao;

import org.springframework.data.repository.CrudRepository;

import cl.prueba.spring.model.Contacto;


public interface IContactoDao extends CrudRepository<Contacto, Long> {

}
