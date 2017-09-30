/**
 *
 * TrekBusi
 *
 * Autor : Diego Ruiz
 *
 *
 */
//Nombre del paquete
package tkbi.DAO;

//Librerias importadas
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

//Inicio clase conexion
public class conexion {

    private Connection con;

    // Constructor conexión
    public conexion() {
        try {
            InitialContext contexto = new InitialContext();
            DataSource dataSource = (DataSource) contexto.lookup("jdbc/ingearDatabase");
            con = dataSource.getConnection();
        } catch (NamingException ex) {
            System.out.println("Error de conexión Naming: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error de conexión SQL: " + ex);
        }
    }// Fin constructor 

    public Connection getCon() {
        return con;
    }

       
        
}//Fin clase conexion
