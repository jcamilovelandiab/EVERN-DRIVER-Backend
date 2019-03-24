package edu.eci.arsw.evern.persistence;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IAutomovilRepository;


@Component
@Qualifier("AutomovilRepository")
public class AutomovilRepository implements IAutomovilRepository {
	
	private String dbUrl = System.getenv().get("JDBC_DATABASE_URL");
	
	@Autowired
	@Qualifier("autoDataSource")
	private DataSource auoDataSource;

	@Override
	public List<Automovil> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Automovil find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Automovil entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Automovil entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Automovil o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	
	@Bean("autoDataSource")
	public DataSource autoDataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}
}

