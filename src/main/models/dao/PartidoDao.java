package main.models.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import main.models.connection.ConnectionManager;
import main.models.vo.PartidoVo;

/**
 * Esta clase define los métodos de la BBDD del objeto "Partido"
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class PartidoDao {

    /**
    * Método que crea un partido en la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param partido Es el objeto partido a insertar en la BBDD
    */
    public static void createPartido(PartidoVo partido) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO partido (nombre, siglas) VALUES ('" + partido.getNombre() + "', '" + partido.getSiglas() + "')");
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
    
    }
    
    /**
    * Método que lista los objetos partido de la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return partidos Lista de partidos de la BBDD
    */
    public static List getPartidos() {
    
        ConnectionManager connectionManager = new ConnectionManager();
        List partidos = new LinkedList();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from partido order by nombre");
            while(rs.next()) {

                PartidoVo partido = new PartidoVo(rs.getInt("id"), rs.getString("nombre"), rs.getString("siglas"));
                partidos.add(partido);

            }
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return partidos;
        
    }
    
}