package cl.prueba.spring.dao;

import cl.prueba.spring.model.Capacitacion;
import org.springframework.data.repository.CrudRepository;

public interface ICapacitacionDao extends CrudRepository<Capacitacion, Long> {
}
