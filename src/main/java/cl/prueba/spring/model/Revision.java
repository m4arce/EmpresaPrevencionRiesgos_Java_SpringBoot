package cl.prueba.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "revisiones")
public class Revision implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idrevision;
	
	@NotEmpty (message = "**Debes ingresar un nombre para la revision**")
    @Column(name = "nombrerevision")
    public String nombrerevision;
	
	@NotEmpty
    @Column(name = "detalle")
    public String detalle;
	
	@NotEmpty
    @Column(name = "estado")
    public String estado;

	public Long getIdrevision() {
		return idrevision;
	}

	public void setIdrevision(Long idrevision) {
		this.idrevision = idrevision;
	}

	public String getNombrerevision() {
		return nombrerevision;
	}

	public void setNombrerevision(String nombrerevision) {
		this.nombrerevision = nombrerevision;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	

}
