package cl.prueba.spring.dao;
import cl.prueba.spring.model.Visita;
import org.springframework.data.repository.CrudRepository;

public interface IVisitaDao extends CrudRepository<Visita, Long> {
}
