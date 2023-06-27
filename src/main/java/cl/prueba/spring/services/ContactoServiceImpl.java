package cl.prueba.spring.services;

/*import java.util.List;*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.prueba.spring.dao.IContactoDao;
import cl.prueba.spring.model.Contacto;



@Service
public class ContactoServiceImpl implements ContactoService{

    @Autowired
    private IContactoDao contactoDao;
    
    /*@Override
    @Transactional(readOnly = true)
    public List<Contacto> listarContacto() {
        return (List<Contacto>) contactoDao.findAll();
    }*/

    @Override
    @Transactional
    public void guardar(Contacto contacto) {
        contactoDao.save(contacto);
    }

    /*@Override
    @Transactional
    public void eliminar(Contacto contacto) {
        contactoDao.delete(contacto);
    }*/

    /*@Override
    @Transactional(readOnly = true)
    public Contacto encontrarContacto(Contacto contacto) {
        return contactoDao.findById(contacto.getIdcontacto()).orElse(null);
    }*/
}
