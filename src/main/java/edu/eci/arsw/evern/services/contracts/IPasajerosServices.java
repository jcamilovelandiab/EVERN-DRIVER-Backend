package edu.eci.arsw.evern.services.contracts;


import org.springframework.stereotype.Service;

import edu.eci.arsw.evern.model.Pasajero;


@Service
public interface IPasajerosServices {

	Pasajero createPasajero(Pasajero pasajero);
	
	void delete(Pasajero pasajero);

	void pasajeroCalificaAlConductorByViaje(long idViaje, int calificacion);

	void actualizarNombres(String correoUsuario, String nuevosNombres);

	void actualizarApellidos(String correoUsuario, String nuevosApellidos);

}
