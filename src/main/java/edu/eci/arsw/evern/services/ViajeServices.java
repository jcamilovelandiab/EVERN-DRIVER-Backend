package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.ViajeRepository;
import edu.eci.arsw.evern.persistence.repositories.*;
import edu.eci.arsw.evern.services.contracts.IViajeServices;

@Component
public class ViajeServices implements  IViajeServices {
	
	@Autowired
	@Qualifier("ViajeRepository")
	private IViajeRepository viajeRepository;

	@Override
	public List<Viaje> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viaje create(Viaje car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Viaje get(String licencePlate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateViaje(Viaje car) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteViaje(Viaje car) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Viaje> getViajesDelUsuario(String correoUsuario) {
		// TODO Auto-generated method stub
		return null;
	}


}
