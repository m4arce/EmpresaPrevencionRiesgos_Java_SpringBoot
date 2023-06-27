package cl.prueba.spring.services;

import cl.prueba.spring.dao.IVisitaDao;
import cl.prueba.spring.model.Visita;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitaServiceImpl implements VisitaService{

    @Autowired
    private IVisitaDao visitaDao;
    @Override
    @Transactional(readOnly = true)
    public List<Visita> listarVisita() {
        return (List<Visita>) visitaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Visita visita) {
        visitaDao.save(visita);
    }

    @Override
    @Transactional
    public void eliminar(Visita visita) {
        visitaDao.delete(visita);
    }

    @Override
    @Transactional(readOnly = true)
    public Visita encontrarVisita(Visita visita) {
        return visitaDao.findById(visita.getIdvisita()).orElse(null);
    }
}
