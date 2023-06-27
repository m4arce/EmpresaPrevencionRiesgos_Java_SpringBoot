package cl.prueba.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "pagos")
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idpago;

    @NotEmpty (message = "**Debes ingresar un curso**")
    @Column(name = "curso")
    public String curso;

    @NotEmpty
    @Column(name = "docente")
    public String docente;

    @NotEmpty 
    @Column(name = "fecha")
    public String fecha;
    
    @NotEmpty
    @Column(name = "tipopago")
    public String tipopago;

    @NotEmpty
    @Column(name = "monto")
    public String monto;

	public Long getIdpago() {
		return idpago;
	}

	public void setIdpago(Long idpago) {
		this.idpago = idpago;
	}

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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getTipopago() {
		return tipopago;
	}

	public void setTipopago(String tipopago) {
		this.tipopago = tipopago;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}    
}
