package cl.prueba.spring.services;


import cl.prueba.spring.dao.IPagoDao;
import cl.prueba.spring.model.Pago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService{

    @Autowired
    private IPagoDao pagoDao;
    @Override
    @Transactional(readOnly = true)
    public List<Pago> listarPago() {
        return (List<Pago>) pagoDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Pago pago) {
        pagoDao.save(pago);
    }

    @Override
    @Transactional
    public void eliminar(Pago pago) {
        pagoDao.delete(pago);
    }

    @Override
    @Transactional(readOnly = true)
    public Pago encontrarPago(Pago pago) {
        return pagoDao.findById(pago.getIdpago()).orElse(null);
    }
}
