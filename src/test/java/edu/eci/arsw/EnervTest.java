package edu.eci.arsw;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;

import edu.eci.arsw.evern.model.Automovil;
import edu.eci.arsw.evern.model.Conductor;
import edu.eci.arsw.evern.model.Pasajero;
import edu.eci.arsw.evern.model.Viaje;
import edu.eci.arsw.evern.persistence.ConductorRepository;
import edu.eci.arsw.evern.persistence.PasajeroRepository;
import edu.eci.arsw.evern.persistence.ViajeRepository;

public class EnervTest {
	
	@Test
	public void savePasajeroConViajes() {
		PasajeroRepository pr= new PasajeroRepository();
		Pasajero p= new Pasajero("prueba5@correo", "prueba1", "prueba", "1283", "26-05-1998", "123");
		Pasajero p1= new Pasajero("prueba4@correo", "prueba1", "prueba", "22333", "26-05-1998", "123");
		Pasajero p2= new Pasajero("prueba3@correo", "prueba1", "prueba", "222222", "26-05-1998", "123");
		pr.save(p);
		pr.save(p1);
		pr.save(p2);
		assertNotNull(pr.getPasajero(p.getCorreo()));
		Viaje v= new Viaje("santa fe", "escuela colombiana", 2000,"coductor@correo", "prueba5@correo");
		p.agregarViaje(v);
		assertNotNull(pr.getViajesPasajeroByCorreo(p.getCorreo()));
		assertNotNull(pr.findAll());
		
	}
	
	@Test
	public void saveConductorConViajes() {
		ConductorRepository cr= new ConductorRepository();
		Automovil auto= new Automovil("cwe341", "2018", "camioneta", "blanco");
		Conductor c=new Conductor("coductorPrueba3@correo", "conductor3", "prueba", "88818", "25-05-2014", "123",null);
		cr.save(c);
		assertNotNull(cr.getCondutor("coductorPrueba1@correo"));
		assertNotNull(cr.findAll());
		ViajeRepository vr= new ViajeRepository();
		assertNotNull(vr.findAll());
	}
	

}
