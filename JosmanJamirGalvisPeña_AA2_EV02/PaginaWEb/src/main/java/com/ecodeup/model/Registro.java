package com.ecodeup.model;

public class Registro {
	private int id_registro;
	private String nombre;
	private String correo;
	private String contraseña;
	public Registro(int id, String nombre, String correo, String contraseña) {
		super();
		this.id_registro = id;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
	}
	
	public Registro() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id_registro;
	}

	public void setId(int id) {
		this.id_registro = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id_registro + ", nombre=" + nombre + ", correo=" + correo + ", contraseña=" + contraseña + "]";
	}

	




	
	
}
