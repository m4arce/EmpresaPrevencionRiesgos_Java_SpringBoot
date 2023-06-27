package cl.prueba.spring.services;

import cl.prueba.spring.dao.ICapacitacionDao;
import cl.prueba.spring.model.Capacitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CapacitacionServiceImpl implements CapacitacionService{

    @Autowired
    private ICapacitacionDao capacitacionDao;
    @Override
    @Transactional(readOnly = true)
    public List<Capacitacion> listarCapacitacion() {
        return (List<Capacitacion>) capacitacionDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Capacitacion capacitacion) {
        capacitacionDao.save(capacitacion);
    }

    @Override
    @Transactional
    public void eliminar(Capacitacion capacitacion) {
        capacitacionDao.delete(capacitacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Capacitacion encontrarCapacitacion(Capacitacion capacitacion) {
        return capacitacionDao.findById(capacitacion.getIdcapacitaciones()).orElse(null);
    }
}
