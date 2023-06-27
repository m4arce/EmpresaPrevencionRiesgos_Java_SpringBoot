package cl.prueba.spring.services;

import cl.prueba.spring.model.Capacitacion;
import java.util.List;

public interface CapacitacionService {

    public List<Capacitacion> listarCapacitacion();

    public void guardar(Capacitacion capacitacion);

    public void eliminar(Capacitacion capacitacion);

    public Capacitacion encontrarCapacitacion(Capacitacion capacitacion);
}
