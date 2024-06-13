import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// esto no tiene sentido
import conexion.ConexionBD;

// no puedes crear un package aquí
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// proyecto creado correctamente

/**
 * Clase que permite la conexion con la base de datos 
 * registrando un driver de tipo MariaDB
 */
public class ConexionBD {

	/**Propiedades de la conexión*/
	//cambiar el dato para conectar a otra base de datos
	private static String database="empresa"; // no está en biblioteca
	private static String usuario="root";
	private static String contrasena="";
	private static String url="jdbc:mariadb://localhost/"+database;
	
	//Objeto Connection que debemos usar en JDBC
	private Connection conexion=null;
	
	/**
	 * Método de la clase que devuelve el objeto Connection 
	 * necesario para operar con la base de datos
	 * @return el objeto Connection
	 */
	public Connection getConexion() {
		if (this.conexion!=null) {
			//Ya está la conexión creada, la devuelvo
			return this.conexion;
		}
		
		try {
			//Inicializamos la conexión a la base de datos
			//Registrar el driver. Previamente habrá que haber añadido el driver al proyecto (Build Path)
			// driver no incoriparado, no añadido al boot path
			Class.forName("org.mariadb.jdbc.Driver");
			//Obtenemos el objeto Connection de la clase 
			//DriverManager. Lanzará una excepción
			//SQLException si no se puede conectar 
			this.conexion = DriverManager.getConnection(url,usuario,contrasena);
			System.out.println("Conexion correcta");
		
	} catch (ClassNotFoundException e) {
		System.out.println("error al registrar el driver");
		
	} catch (SQLException e) {
		System.out.println("No se puede conectar con la base de datos."+e.getLocalizedMessage());
		
	}
		return this.conexion;
}
	
	/**
	 * Método de la clase que libera los recursos asociados a la conexion
	 */
	public void desconectar() {
		if(this.conexion!=null) {
			try {
				this.conexion.close();
			} catch (SQLException e) {
				System.out.println("Error, no se puede liberar la conexión");
			}
		}
	}
}
