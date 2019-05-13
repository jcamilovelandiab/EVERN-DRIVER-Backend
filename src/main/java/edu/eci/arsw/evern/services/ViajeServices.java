package edu.eci.arsw.evern.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.Comentario;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.repositories.*;
import edu.eci.arsw.evern.services.contracts.IViajeServices;

@Component
public class ViajeServices implements  IViajeServices {
	
	@Autowired
	@Qualifier("ViajeRepository")
	private IViajeRepository viajeRepository;

	@Override
	public Long createViaje(Viaje viaje) {
		return viajeRepository.save(viaje);
	}

	@Override
	public void updateViaje(Viaje viaje) {
		viajeRepository.update(viaje);
	}

	@Override
	public void deleteViaje(Viaje viaje) {
		viajeRepository.delete(viaje);
	}

	@Override
	public List<Viaje> getViajes() {
		return viajeRepository.findAll();
	}

	@Override
	public Viaje getViajeById(Long idViaje) {
		System.out.println("SERVICES VIAJE BY ID "+idViaje.toString());
		return viajeRepository.find(idViaje);
	}

	@Override
	public List<Comentario> getComentariosByViaje(Long idViaje) {
		return viajeRepository.getComentariosByViaje(idViaje);
	}	
	
}
