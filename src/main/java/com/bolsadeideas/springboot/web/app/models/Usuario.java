package com.bolsadeideas.springboot.web.app.models;

public class Usuario {

	private String nombre;
	private String apellido;
	private String email;

	/*
	 * Source generate constructor from superclass y from fields, si quiero que
	 * herede ademas el constructor pongo super()
	 */

	public Usuario() {

		// TODO Auto-generated constructor stub
	}

	public Usuario(String nombre, String apellido, String email) {

		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
