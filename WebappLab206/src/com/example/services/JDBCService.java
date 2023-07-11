package com.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

@ManagedBean
@ApplicationScoped
public class JDBCService {

	Logger logger = Logger.getLogger(getClass().getName());
	
	DataSource dataSource;
	
	Connection connection;
	
	public JDBCService() {
		logger.info("Inicializando JDBC");
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("jdbc/test");
			logger.info(dataSource.toString());
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = dataSource.getConnection();
			logger.info(connection == null ? "Sin conexión" : "Conectado");
			logger.info(connection.toString());
		} catch (NamingException e) {
			logger.info("NamingException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			logger.info("ClassNotFoundException: " + e.getMessage());
		} catch (SQLException e) {
			logger.info("SQLException: " + e.getMessage());
		}
	}
	
	public String test() throws SQLException {
		logger.info("Test JDBC");
		
//		connection.setAutoCommit(false);
		
		PreparedStatement statement = connection.prepareStatement("select * from test");
		
		ResultSet resultSet = statement.executeQuery();
		
		String result = "";
		
		while(resultSet.next()) {
			String title = resultSet.getString("title");
			result += title + "\n";
		}
		
		return result;
	}
	
}
