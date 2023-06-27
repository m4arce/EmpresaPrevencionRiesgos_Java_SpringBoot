package cl.prueba.spring.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name = "contacto")
public class Contacto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idcontacto;
	
	@NotEmpty (message = "**Debes ingresar un usuario**")
    @Column(name = "nombre")
    public String nombre;
	
	@NotEmpty
	@Email
    @Column(name = "email")
    public String email;
	
	@NotEmpty
    @Column(name = "mensaje")
    public String mensaje;

	public Long getIdcontacto() {
		return idcontacto;
	}

	public void setIdcontacto(Long idcontacto) {
		this.idcontacto = idcontacto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}	
	
}
