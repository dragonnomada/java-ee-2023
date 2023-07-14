package com.example.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;

import com.example.model.Fruta;
import com.example.model.FrutaFactory;

// EJB -> Bean

//@Named // Permite que esta clase sea auto-instanciada e inyectable por otros beans
//@Stateless // Define el ciclo vida a nivel aplicación
@ManagedBean
@ApplicationScoped
public class FrutaService {

	Logger logger = Logger.getLogger("FrutaService");
	
	private Connection connection;
	
	public FrutaService() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3308/jee_sesion?autoReconnect=true&useSSL=false", "root", "password");
			
			logger.info("Conectado a la base de datos");
		} catch (ClassNotFoundException e) {
			logger.warning("No se econtró el Driver de MySQL: " + e.getMessage());
		} catch (SQLException e) {
			logger.warning("Error de conexión a la base de datos: " + e.getMessage());
		}
	}
	
	public List<Fruta> getFrutas() {
		List<Fruta> frutas = new ArrayList<Fruta>();
		
		String sql = "select * from frutas";
		
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				double precio = resultSet.getDouble("precio");
				double pesoUnitario = resultSet.getDouble("peso_unitario");
				int existencias = resultSet.getInt("existencias");
				
				Fruta fruta = FrutaFactory
						.build(id, nombre, precio, pesoUnitario, existencias);
				
				frutas.add(fruta);
			}
			
			logger.info(String.format("Frutas consultadas: %d", frutas.size()));
		} catch (SQLException e) {
			logger.warning("Error al consultar las frutas: " + e.getMessage());
		}
		
		return frutas;
	}
	
}

/*
 * El JavaBean o EnterpriseBean es una clase POJO que ha sido anotada
 * para que todo el resto del sistema la identifique.
 * 
 * Generalmente bastaría con usar la anotación @Named o @ManegedBean
 * Para identificar este Bean en el resto de las clases y que a través
 * de la Inyección de Dependencias (Dependency Injection), que es parte
 * del CDI (Context and Dependency Injection) podamos establecer que
 * otra clase requiere una referencia a esta clase.
 * 
 * La referencia es una referencia "común", es decir, compartida, a todos
 * los que la requieran.
 * 
 * Es decir, un Bean Empresarial es una instancia compartida de una clase
 * que brinda servicios lógicos sobre reglas de negocio, utilerias y
 * adquisición de recursos hacia otros servicios externos (EIS) como,
 * bases de datos, mensajería, correo, etc.
 * 
 * Y para establecer correctamente el Bean deberemos adicionar información
 * sobre su ciclo de vida.
 * 
 * Por ejemplo:
 * 
 * - Si el Bean estará "vivo", es decir, mantendrá sus datos, durante toda la aplicación (@ApplicationScoped tipo Web o tipo EJB)
 * - Si se mantendrá "vivo", sólo mientras dure una sesión web (tipo Web @SessionScoped)
 * - Si se mantendrá mientras dure una petición web (tipo Web @RequestScoped)
 * - Si se mantendrá mientras otro objeto no libere (@Stateless)
 * - Si se mantendrá mientras alguien lo requiera (@Singleton)
 * - Si se mantendrá mientras es consumido (@Stateful)
 * 
 * Los beans son administrados y mantenidos "vivos" por los contenedores:
 * 
 * - Web Container - Generalmente cuándo usamos JAX-RS o JAX-WS -> JSP o JSF
 * - EJB Container - Generalmente son independientes a los proyectos WEB
 * 
 */
