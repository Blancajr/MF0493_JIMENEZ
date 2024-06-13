package Ppal;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class MostrarEditoriales {
	public class ConexionBD {

		public static void main(String[] args) {
			public class Departamentos {
				public static void main(String[] args) {
					ConexionBD conexion= new ConexionBD();
					
					System.out.println("Conectando a la base de datos...");
					// Paso 1. Obtener la conexión
					Connection con = conexion.getConexion(); // correcto
					
					//Objetos necesarios para hacer una consulta
							Statement sentencia= null;
							ResultSet resultado=null;
							
					//Algún procesamiento con la base de datos..
					// Paso 2. Obtener el Statement
					try {
						sentencia =con.createStatement();
					
					//Paso 3. Ejecutar la sentencia
						// consulta incorrecta
						resultado=sentencia.executeQuery("select * from departamentos"); 
						System.out.println("Cod.Editorial\tNombre\tAnio");
						
						// Paso 4. Recorrer el resultado
						while(resultado.next()) {
							// datos incorrectos
							int codEditorial = resultado.getInt("codEditorial");
							String nombre = resultado.getString("nombre");
							int nombre = resultado.getInt("nombre");
							
							// incorrecto
							System.out.println(codDepartamento+"\t"+codCentro+"\t"+codDirector+"\t"+tipo_dir+"\t"+presupuesto+"\t"+cod_dpto_jefe+"\t"+nombre);
						}
						
					} catch (SQLException e) {
						System.out.println("Error al liberar los recursos. "+e.getMessage());
					}finally {			
						
					}
					//Liberamos la conexión
					System.out.println("Desconectando de la base de datos...");
					conexion.desconectar();
				}

			}	
			// Github creado correctamente
			// commit realizado

		}

	}
}
