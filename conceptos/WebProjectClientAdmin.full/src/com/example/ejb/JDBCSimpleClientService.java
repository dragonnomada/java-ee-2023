package com.example.ejb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;

import com.example.model.Client;
import com.example.service.ClientService;
import com.example.service.JDBCSimpleClient;

@JDBCSimpleClient
@Stateless
public class JDBCSimpleClientService implements ClientService {

	Logger logger = Logger.getLogger("JDBCSimpleClientService");
	
	Connection connection;
	
	public JDBCSimpleClientService() {
		logger.info("Inicializando el servicio...");
		try {
			logger.info("Adquiriendo driver de MySQL...");
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.info("Obteniendo la conexión a MySQL...");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_demo?useSSL=false", "root", "password");
			logger.info("Conectado a la base de datos");
		} catch (Exception e) {
			logger.warning("Error al inicializar el servicio: " + e.getMessage());
		}
	}

	@Override
	public Client addClient(Client client) {
		try {
			String sql = "insert into clients (first_name, last_name, address_1, address_2, phone, email) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, client.getFirstName());
			statement.setString(2, client.getLastName());
			statement.setString(3, client.getAddress1());
			statement.setString(4, client.getAddress2());
			statement.setString(5, client.getPhone());
			statement.setString(6, client.getEmail());
			
			if (!statement.execute()) {
				logger.info("Cliente insertado");
				ResultSet generatedKeys = statement.getGeneratedKeys();
				generatedKeys.next();
				long id = generatedKeys.getLong(1);
				logger.info("ID: " + id);
				return getClient(id);
			} else {
				throw new Exception("Error al ejecutar el statement");
			}
		} catch (Exception e) {
			logger.warning("Error on addClient(client): " + e.getMessage());
		}
		return null;
	}

	@Override
	public Client getClient(long id) {
		try {
			String sql = "select * from clients where id=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setLong(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				Long cid = resultSet.getLong("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String address1 = resultSet.getString("address_1");
				String address2 = resultSet.getString("address_2");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				
				Client client = new Client();
				
				client.setId(cid);
				client.setFirstName(firstName);
				client.setLastName(lastName);
				client.setAddress1(address1);
				client.setAddress2(address2);
				client.setPhone(phone);
				client.setEmail(email);
				
				return client;
			} else {
				throw new Exception("No existe el cliente");
			}
		} catch (Exception e) {
			logger.warning("Error on getClient(id): " + e.getMessage());
		}
		return null;
	}

	@Override
	public List<Client> getClients() {
		try {
			String sql = "select * from clients";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			List<Client> clients = new ArrayList<Client>();
			
			while (resultSet.next()) {
				Long cid = resultSet.getLong("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String address1 = resultSet.getString("address_1");
				String address2 = resultSet.getString("address_2");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				
				Client client = new Client();
				
				client.setId(cid);
				client.setFirstName(firstName);
				client.setLastName(lastName);
				client.setAddress1(address1);
				client.setAddress2(address2);
				client.setPhone(phone);
				client.setEmail(email);
				
				clients.add(client);
			}

			return clients;
		} catch (Exception e) {
			logger.warning("Error on getClient(id): " + e.getMessage());
		}
		return null;
	}

	@Override
	public Client updateClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client deleteClient(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
