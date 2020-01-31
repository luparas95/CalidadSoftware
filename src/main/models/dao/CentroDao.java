package main.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import main.models.connection.ConnectionManager;
import main.models.vo.CentroVo;

/**
 * Esta clase define los métodos de la BBDD del objeto "Centro"
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class CentroDao {
    
    /**
    * Método que crea un centro en la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centro Es el objeto centro a insertar en la BBDD
    */
    public static void createCentro(CentroVo centro) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO centro (nombre, electores) VALUES ('" + centro.getNombre() + "', " + centro.getElectores() + ")");
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
    
    }
    
    /**
    * Método que lista los objetos centro de la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return centros Lista de centros de la BBDD
    */
    public static List getCentros() {
    
        ConnectionManager connectionManager = new ConnectionManager();
        List centros = new LinkedList();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from centro order by nombre");
            while(rs.next()) {

                CentroVo centro = new CentroVo(rs.getInt("id"), rs.getString("nombre"), rs.getInt("electores"));
                centros.add(centro);

            }
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return centros;
        
    }
    
    /**
    * Método que muestra el centro de la BBDD que tenga el id suministrado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param idCentro El id del centro a extraer
    * @return centro Centro de la BBDD con el id suministrado
    */
    public static CentroVo getCentroById(int idCentro) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        CentroVo centro = new CentroVo(0, "", 0);
        try {

            PreparedStatement stmt = connectionManager.getConnection().prepareStatement("select * from centro where id = ?");   
            stmt.setInt(1, idCentro);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            centro = new CentroVo(rs.getInt("id"), rs.getString("nombre"), rs.getInt("electores"));
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return centro;
        
    }
    
    /**
    * Método que actualiza un centro en la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param centro Es el objeto centro a actualizar en la BBDD
    */
    public static void updateCentro(CentroVo centro) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            stmt.executeUpdate("UPDATE centro set nombre = '" + centro.getNombre() + "', electores = " + centro.getElectores() + " where id = " + centro.getId());
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
    
    }
    
}