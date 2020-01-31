package main.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import main.models.connection.ConnectionManager;
import main.models.vo.UserVo;

/**
 * Esta clase define los métodos de la BBDD del objeto "User"
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class UserDao {
    
    /**
    * Método que crea un usuario en la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param usuario Es el objeto usuario a insertar en la BBDD
    */
    public static void createUser(UserVo usuario) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO usuario (nombre, password, role) VALUES ('" + usuario.getNombre() + "', '" + usuario.getPassword() + "', " + usuario.getRole() + ")");
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
    
    }
    
    /**
    * Método que lista los objetos usuario de la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return usuarios Lista de usuarios de la BBDD
    */
    public static List getUsers() {
    
        ConnectionManager connectionManager = new ConnectionManager();
        List usuarios = new LinkedList();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from usuario order by nombre");
            while(rs.next()) {

                UserVo usuario = new UserVo(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"), rs.getInt("role"));
                usuarios.add(usuario);

            }
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return usuarios;
        
    }
    
    /**
    * Método que muestra el usuario de la BBDD que tenga el id suministrado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param idUser El id del usuario a extraer
    * @return usuario User de la BBDD con el id suministrado
    */
    public static UserVo getUserById(int idUser) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        UserVo usuario = new UserVo(0, "", "", 0);
        try {

            //Statement stmt = connectionManager.getConnection().createStatement();
            //ResultSet rs = stmt.executeQuery("select * from usuario where id = ?");
            PreparedStatement stmt = connectionManager.getConnection().prepareStatement("select * from usuario where id = ?");   
            stmt.setInt(1, idUser);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            usuario = new UserVo(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"), rs.getInt("role"));
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return usuario;
        
    }
    
    /**
    * Método que actualiza un usuario en la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param usuario Es el objeto usuario a actualizar en la BBDD
    */
    public static void updateUser(UserVo usuario) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            stmt.executeUpdate("UPDATE usuario set nombre = '" + usuario.getNombre() + "', password = '" + usuario.getPassword() + "', role = " + usuario.getRole() + " where id = " + usuario.getId());
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
    
    }
    
    /**
    * Método que chequea el login del User en la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre Es el nombre del usuario a chequear en la BBDD
    * @param password Es el password del usuario a chequear en la BBDD
    * @return usuario Retorna un usuario si lo encuentra y sino un usuario vacío
    */
    public static UserVo checkLogin(String nombre, String password) {

        ConnectionManager connectionManager = new ConnectionManager();
        UserVo usuario = new UserVo(0, "", "", 0);
        try {

            PreparedStatement stmt = connectionManager.getConnection().prepareStatement("select * from usuario where nombre = ? and password = ?");   
            stmt.setString(1, nombre);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                
                usuario = new UserVo(rs.getInt("id"), rs.getString("nombre"), rs.getString("password"), rs.getInt("role"));
                
            }
            
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return usuario;
    
    }
    
}