package cl.prueba.spring.dao;
import cl.prueba.spring.model.Pago;
import org.springframework.data.repository.CrudRepository;

public interface IPagoDao extends CrudRepository<Pago, Long> {
}
