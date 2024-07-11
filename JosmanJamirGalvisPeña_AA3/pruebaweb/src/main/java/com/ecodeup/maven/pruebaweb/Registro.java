package com.ecodeup.maven.pruebaweb;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Registro
 *
 */
@Entity
public class Registro implements Serializable {

	@GeneratedValue (strategy= GenerationType.IDENTITY)
	@Id
	private Integer Id;
	private String Nombre;
	private String Correo;
	private String Contraseña;
	private static final long serialVersionUID = 1L;

	
	
	public Registro(String nombre, String correo, String contraseña) {
		super();
		Nombre = nombre;
		Correo = correo;
		Contraseña = contraseña;
	}
	public Registro() {
		super();
	}   
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}   
	public String getCorreo() {
		return this.Correo;
	}

	public void setCorreo(String Correo) {
		this.Correo = Correo;
	}   
	public String getContraseña() {
		return this.Contraseña;
	}

	public void setContraseña(String Contraseña) {
		this.Contraseña = Contraseña;
	}
   
}
