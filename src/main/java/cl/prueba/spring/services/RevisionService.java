package cl.prueba.spring.services;

import java.util.List;

import cl.prueba.spring.model.Revision;



public interface RevisionService {
	
	public List<Revision> listarRevision();

    public void guardar(Revision revision);

    public void eliminar(Revision revision);

    public Revision encontrarRevision(Revision revision);

	

}
