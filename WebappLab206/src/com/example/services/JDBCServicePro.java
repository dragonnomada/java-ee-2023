package com.example.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

@ManagedBean
@ApplicationScoped
public class JDBCServicePro {

Logger logger = Logger.getLogger(getClass().getName());
	
	@Resource(lookup="jdbc/test")
	DataSource dataSource;
	
	public String test() throws SQLException {
		Connection connection = dataSource.getConnection();
		
		logger.info("Test JDBC (PRO)");
		
//		connection.setAutoCommit(false);
		
		PreparedStatement statement = connection.prepareStatement("select * from test");
		
		ResultSet resultSet = statement.executeQuery();
		
		String result = "(PRO)\n";
		
		while(resultSet.next()) {
			String title = resultSet.getString("title");
			result += title + "\n";
		}
		
		return result;
	}
	
}
