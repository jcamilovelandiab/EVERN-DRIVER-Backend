package edu.eci.arsw.evern.persistence;

import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IConductorRepository;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

@Component
@Qualifier("ConductorRepository")
public class  ConductorRepository implements IConductorRepository {
	
	@Override
	public List<Conductor> findAll() {
		String query = "SELECT * FROM conductor;";
		List<Conductor> conductors = new ArrayList<>();
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Conductor conductor = new Conductor();
				conductor.setApellidos(rs.getString("apellidos"));
				conductor.setNombres(rs.getString("nombres"));
				conductor.setCelular(rs.getString("celular"));
				conductor.setCorreo(rs.getString("correo"));
				conductor.setClave(rs.getString("clave"));
				conductors.add(conductor);
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return conductors;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public Conductor find(String correo) {
		String query = "SELECT * FROM conductor c, automovil a where c.correo = '"+correo+"';";
		try {
			Conductor conductor = new Conductor();
			//Automovil automovil = new Automovil();
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				conductor.setApellidos(rs.getString("apellidos"));
				conductor.setNombres(rs.getString("nombres"));
				conductor.setCelular(rs.getString("celular"));
				conductor.setCorreo(rs.getString("correo"));		
				conductor.setClave(rs.getString("clave"));
				/*automovil.setModelo(rs.getString("modelo"));
				automovil.setPlaca(rs.getString("placa"));
				automovil.setTipo(rs.getString("tipo"));
				conductor.setAutomovil(automovil);*/
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return conductor;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}

	@Override
	public String save(Conductor entity) {
		 	String FK_CONDUCTOR_AUTO  = (entity.getAutomovil()!= null) ? "'"+entity.getAutomovil().getPlaca()+"'" : "null" ; 
			String query = "INSERT INTO conductor(nombres, apellidos , calificacion , celular , clave  , correo , fecha_nacimiento , automovil_id)"
			 +"values ('"+entity.getNombres()+"','"+entity.getApellidos()+"',0,'"+entity.getCelular()+"','"+entity.getClave()+"','"
					+entity.getCorreo()+"',null,"+FK_CONDUCTOR_AUTO+");";
			try {
				Connection connection = RepositoryDataBases.dataSource().getConnection();
				Statement stmt = connection.createStatement();
				stmt.execute(query);
				RepositoryDataBases.dataSource().close();
				connection.close();
				return entity.getCorreo();
			} catch (Exception e) {	
				throw new RuntimeException(e);
			}
	}
	
	
	@Override
	public void aceptarViajeConductor(Conductor conductor , int idViaje) {
			String query = String.format("UPDATE viaje SET correo_conductor = '%s' , aceptado = true WHERE id = %d;",conductor.getCorreo() , idViaje); 
			try {
				Connection connection = RepositoryDataBases.dataSource().getConnection();
				Statement stmt = connection.createStatement();
				stmt.execute(query);
				RepositoryDataBases.dataSource().close();
				connection.close();
			} catch (Exception e) {	
				throw new RuntimeException(e);
			}
	
	}

	@Override
	public void update(Conductor entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Conductor o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void conductorCalificaAlPasajeroByViaje(Long idViaje, int calificacion) {
		String sql = "UPDATE viaje"+
				"SET calificacion_al_pasajero="+String.valueOf(calificacion)+
				"WHERE id="+idViaje.toString()+";";
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
			RepositoryDataBases.dataSource().close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public void updateNombres(String correoUsuario, String nuevosNombres) {
		String sql = "UPDATE conductor"+
				"SET nombres='"+nuevosNombres+"'"+
				"WHERE correo='"+correoUsuario+"';";
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
			RepositoryDataBases.dataSource().close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateApellidos(String correoUsuario, String nuevosApellidos) {
		String sql = "UPDATE conductor"+
				"SET apellidos='"+nuevosApellidos+"'"+
				"WHERE correo='"+correoUsuario+"';";
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
			RepositoryDataBases.dataSource().close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCelular(String correoUsuario, String nuevoCelular) {
		String sql = "UPDATE conductor"+
				"SET celular='"+nuevoCelular+"'"+
				"WHERE correo='"+correoUsuario+"';";
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
			RepositoryDataBases.dataSource().close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateClave(String correoUsuario, String nuevaClave) {
		String sql = "UPDATE conductor"+
				"SET clave='"+nuevaClave+"'"+
				"WHERE correo='"+correoUsuario+"';";
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
			RepositoryDataBases.dataSource().close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void updateCalificacion(String correoUsuario, int nuevaCalificacion) {
		String sql = "UPDATE conductor"+
				"SET calificacion='"+String.valueOf(nuevaCalificacion)+"'"+
				"WHERE correo='"+correoUsuario+"';";
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
			RepositoryDataBases.dataSource().close();
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Conductor getConductorByCorreoYClave(String correoConductor, String clave) {
		String query = "SELECT * FROM conductor c WHERE c.correo = '"+correoConductor+"' AND c.clave='"+clave+"';";
		try {
			Conductor conductor = new Conductor();
			Connection connection = RepositoryDataBases.dataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				conductor.setApellidos(rs.getString("apellidos"));
				conductor.setNombres(rs.getString("nombres"));
				conductor.setCelular(rs.getString("celular"));
				conductor.setCorreo(rs.getString("correo"));		
				conductor.setClave(rs.getString("clave"));
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return conductor;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}

	@Override
	public void remove(String pkEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Viaje> getViajesConductorByCorreo(String correo) {
		String query = "SELECT * FROM viaje v WHERE v.correo_conductor = '"+correo+"';";
		try {
			Connection connection = RepositoryDataBases.dataSource().getConnection();
		
			Statement stmt = connection.createStatement();
			List<Viaje> viajes = new ArrayList<Viaje>();
			System.out.println("En viajes");
		
			ResultSet rs = stmt.executeQuery(query);
		
			while (rs.next()) {
				Viaje viaje = new Viaje();
				viaje.setId(rs.getLong("id"));
				viaje.setAceptado(rs.getBoolean("aceptado"));
				//viaje.setAutomovil();
				viaje.setCalificacionAlConductor(rs.getInt("calificacion_al_conductor"));
				viaje.setCalificacionAlPasajero(rs.getInt("calificacion_al_pasajero"));
				viaje.setCorreoConductor(rs.getString("correo_conductor"));
				viaje.setCorreoPasajero(rs.getString("correo_pasajero"));
				viaje.setCosto(rs.getInt("costo"));
				viaje.setFecha(rs.getString("fecha"));
				viaje.setLugarDestino(rs.getString("lugar_destino"));
				viaje.setLugarOrigen(rs.getString("lugar_origen"));
				viajes.add(viaje);
			}
			RepositoryDataBases.dataSource().close();
			connection.close();
			return viajes;
		} catch (Exception e) {	
			throw new RuntimeException(e);
		}
	}
	
}
