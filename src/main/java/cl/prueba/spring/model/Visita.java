package cl.prueba.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "visitas")
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idvisita;

    @NotEmpty (message = "**Debes ingresar un cliente**")
    @Column(name = "cliente")
    public String cliente;

    @NotEmpty
    @Column(name = "lugar")
    public String lugar;

    @NotEmpty 
    @Column(name = "fecha")
    public String fecha;

    @NotEmpty
    @Column(name = "comentarios")
    public String comentarios;

	public Long getIdvisita() {
		return idvisita;
	}

	public void setIdvisita(Long idvisita) {
		this.idvisita = idvisita;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}    
}
