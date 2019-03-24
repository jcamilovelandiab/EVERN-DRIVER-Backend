package edu.eci.arsw.evern.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.*;


public class Usuario {

	private Long id;

	private String correo;

	private String nombres;

	private String apellidos;

	// private BufferedImage foto=null;

	private String celular;

	private int calificacion = 0;

	private Date fechaNacimiento;// dd-mm-yy

	private String clave;

	public Usuario() {
	}

	public Usuario(String correo, String nombres, String apellidos, Date fechaNacimiento, String clave) {
		this.correo = correo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

//	public BufferedImage getFoto() {
//		return foto;
//	}
//
//	public void setFoto(BufferedImage foto) {
//		this.foto = foto;
//	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipoUsuario() {
		return "usuario";
	}

}
