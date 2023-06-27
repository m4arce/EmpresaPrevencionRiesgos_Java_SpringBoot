package cl.prueba.spring.services;
import cl.prueba.spring.model.Visita;
import java.util.List;

public interface VisitaService {

    public List<Visita> listarVisita();

    public void guardar(Visita visita);

    public void eliminar(Visita visita);

    public Visita encontrarVisita(Visita visita);
}
