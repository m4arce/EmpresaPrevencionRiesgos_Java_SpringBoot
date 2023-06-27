package cl.prueba.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "capacitaciones")
public class Capacitacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idcapacitaciones;

    @NotEmpty (message = "**Debes ingresar un curso**")
    @Column(name = "curso")
    public String curso;

    @NotEmpty
    @Column(name = "docente")
    public String docente;

    @NotEmpty 
    @Column(name = "inicio")
    public String inicio;

    @NotEmpty
    @Column(name = "termino")
    public String termino;

    @NotEmpty
    @Column(name = "precio")
    public String precio;

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDocente() {
		return docente;
	}

	public void setDocente(String docente) {
		this.docente = docente;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getTermino() {
		return termino;
	}

	public void setTermino(String termino) {
		this.termino = termino;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public Long getIdcapacitaciones() {
		return idcapacitaciones;
	}

	public void setIdcapacitaciones(Long idcapacitaciones) {
		this.idcapacitaciones = idcapacitaciones;
	}
    
    
}
