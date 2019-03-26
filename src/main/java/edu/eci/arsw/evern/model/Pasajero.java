package edu.eci.arsw.evern.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

public class Pasajero extends Usuario implements Serializable{

	private List<Cupon> cupones = new ArrayList<Cupon>();
	private List<CuentaBancaria> cuentasBancarias = new ArrayList<CuentaBancaria>();
	private List<Viaje> viajes = new ArrayList<Viaje>();


	public Pasajero(){

	}

	public Pasajero(String correo, String nombres, String apellidos, String celular, String fechaNacimiento, String clave){
		super(correo, nombres, apellidos, celular, fechaNacimiento, clave);
	}

	public List<Cupon> getCupones(){
		return cupones;
	}

	public void setCupones(List<Cupon> cupones) {
		this.cupones = cupones;
	}
	
	@Override
	public String getTipoUsuario() {
		return "pasajero";
	}


	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}

	public void agregarViaje(Viaje viaje) {
		this.viajes.add(viaje);
	}


	public List<Viaje> getViajes() {
		return viajes;
	}

	@Override
	public String toString() {
		return "Pasajero [cupones=" + cupones + ", cuentasBancarias=" + cuentasBancarias + ", viajes=" + viajes
				+ ", getCorreo()=" + getCorreo() + ", getNombres()=" + getNombres() + ", getApellidos()="
				+ getApellidos() + ", getCalificacion()=" + getCalificacion() + ", getFechaNacimiento()="
				+ getFechaNacimiento() + ", getCelular()=" + getCelular() + ", getClave()=" + getClave()
				+ ", getTipoUsuario()=" + getTipoUsuario() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
}
