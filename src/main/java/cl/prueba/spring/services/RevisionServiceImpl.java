package cl.prueba.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.prueba.spring.dao.IRevisionDao;
import cl.prueba.spring.model.Revision;


@Service
public class RevisionServiceImpl implements RevisionService{
	
	@Autowired
    private IRevisionDao revisionDao;	
	
    
    @Override
    @Transactional(readOnly = true)
    public List<Revision> listarRevision() {
        return (List<Revision>) revisionDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Revision revision) {
        revisionDao.save(revision);
    }

    @Override
    @Transactional
    public void eliminar(Revision revision) {
        revisionDao.delete(revision);
    }

    @Override
    @Transactional(readOnly = true)
    public Revision encontrarRevision(Revision revision) {
        return revisionDao.findById(revision.getIdrevision()).orElse(null);
    }
}
