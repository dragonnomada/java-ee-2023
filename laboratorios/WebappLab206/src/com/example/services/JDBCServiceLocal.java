package com.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

@ManagedBean
@ApplicationScoped
public class JDBCServiceLocal {

	Logger logger = Logger.getLogger(getClass().getName());
	
	DataSource dataSource;
	
	Connection connection;
	
	public JDBCServiceLocal() {
		logger.info("Inicializando JDBC (local)");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/jee_test?autoReconnect=true&useSSL=false", "root", "password");
			logger.info(connection == null ? "Sin conexión" : "Conectado");
			logger.info(connection.toString());
		} catch (ClassNotFoundException e) {
			logger.info("ClassNotFoundException: " + e.getMessage());
		} catch (SQLException e) {
			logger.info("SQLException: " + e.getMessage());
		}
	}
	
	public String test() throws SQLException {
		logger.info("Test JDBC (local)");
		
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
