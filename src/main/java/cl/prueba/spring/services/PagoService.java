package cl.prueba.spring.services;

import cl.prueba.spring.model.Pago;

import java.util.List;

public interface PagoService {

    public List<Pago> listarPago();

    public void guardar(Pago pago);

    public void eliminar(Pago pago);

    public Pago encontrarPago(Pago pago);
}
