package edu.eci.arsw.evern.model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.springframework.transaction.annotation.Transactional;


@MappedSuperclass
public class Usuario {
	

	@Id
	@Column(name  = "correo")
	private String correo;
	

	@Column(name  = "nombres")
	private String nombres;
	

	@Column(name  = "apellidos")
	private String apellidos;
	
	//private BufferedImage foto=null;
	
	@Column(name  = "celular")
	private String celular;
	
	

	@Column(name  = "calificacion")
	private int calificacion=0;
	
	

	@Column(name  = "fechaNacimiento")
	private Date fechaNacimiento;// dd-mm-yy
	

	

	@Column(name  = "clave")
	private String clave;
	
	
	@Transient
	private List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
	
	@Transient
	private List<Viaje> viajes = new ArrayList<Viaje>();
	
	public Usuario () {}

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

	public List<CuentaBancaria> getCuentasBancarias() {
		return cuentasBancarias;
	}

	public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
		this.cuentasBancarias = cuentasBancarias;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	
	
	public void addCuentaBancaria(CuentaBancaria cuentaBancaria) {
		cuentasBancarias.add(cuentaBancaria);
	}
	
	public void removeCuentaBancaria(long idCuentaBancaria) {
		List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
		for (CuentaBancaria cuentaBancaria : cuentasBancarias) {
			if(cuentaBancaria.getNumero() != idCuentaBancaria) cuentas.add(cuentaBancaria);
		}
		this.cuentasBancarias = cuentas;
	}
	
	public void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}
	
	public String getTipoUsuario() {
		return "usuario";
	}
	
}
