package main.models.connection;

import java.sql.*;


/**
 * Esta clase contiene los metodos para conectar con la BBDD
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class ConnectionManager {

    static String db = "innodb";
    static String login = "admin";
    static String password = "proyectos2019";
    static String url = "jdbc:mysql://politics.cgj0za0cinrh.us-east-1.rds.amazonaws.com:3306/" + db;

    Connection conn = null;

    /**
    * Método que crea la conexión
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public ConnectionManager() {

        try {
            
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //obtenemos la conexi�n
            conn = DriverManager.getConnection(url, login, password);

        } catch(SQLException e) {

            System.out.println(e);

        } catch(ClassNotFoundException e) {

            System.out.println(e);

        } catch(Exception e) {

            System.out.println(e);

        }

    }

    /**
    * Método que devuelve la conexión
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return Connection la conexión creada en el constructor
    */
    public Connection getConnection() {

        return conn;

    }

    /**
    * Método desconecta la bbdd
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public void disconnect() {

        try {

            conn.close();

        } catch(SQLException e) {

            System.out.println(e);

        } catch(Exception e) {

            System.out.println(e);

        }
        conn = null;

    }

}