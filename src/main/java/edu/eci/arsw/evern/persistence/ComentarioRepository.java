package edu.eci.arsw.evern.persistence;

import edu.eci.arsw.evern.model.*;
import edu.eci.arsw.evern.persistence.repositories.IComentarioRepository;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Component
@Qualifier("ComentarioRepository")
public class ComentarioRepository implements IComentarioRepository {

	private String dbUrl = System.getenv().get("JDBC_DATABASE_URL");
	@Autowired
	@Qualifier("comentarioDataSource")
	private DataSource comentarioDataSource;

	@Override
	public List<Comentario> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(Comentario entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Comentario entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Comentario o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub

	}

	@Bean("comentarioDataSource")
	public DataSource comentarioDataSource() throws SQLException {
		if (dbUrl == null || dbUrl.isEmpty()) {
			return new HikariDataSource();
		} else {
			HikariConfig config = new HikariConfig();
			config.setJdbcUrl(dbUrl);
			return new HikariDataSource(config);
		}
	}

}
