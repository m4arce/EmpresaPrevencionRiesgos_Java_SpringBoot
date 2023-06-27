package cl.prueba.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.prueba.spring.model.Revision;


public interface IRevisionDao extends JpaRepository<Revision, Long> {	

}
