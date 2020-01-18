package main.models.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import java.util.LinkedList;
import java.util.List;

import main.models.connection.ConnectionManager;

import main.models.vo.ResultadoVo;
import main.models.vo.ResultadoToPrintVo;

/**
 * Esta clase define los métodos de la BBDD del objeto "Resultado"
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class ResultadoDao {

    /**
    * Método que crea un resultado en la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param resultado Es el objeto resultado a insertar en la BBDD
    */
    public static void createResultado(ResultadoVo resultado) {
    
        ConnectionManager connectionManager = new ConnectionManager();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO resultado (idCentro, idPartido, votos) VALUES (" + resultado.getIdCentro() + ", " + resultado.getIdPartido() + ", " + resultado.getVotos() + ")");
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
    
    }
    
    /**
    * Método que lista los objetos resultado de la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return resultados Lista de resultados de la BBDD
    */
    public static List getResultados() {
    
        ConnectionManager connectionManager = new ConnectionManager();
        List resultados = new LinkedList();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from resultado");
            while(rs.next()) {

                ResultadoVo resultado = new ResultadoVo(rs.getInt("idCentro"), rs.getInt("idPartido"), rs.getInt("votos"));
                resultados.add(resultado);

            }
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return resultados;
        
    }
    
    /**
    * Método que lista los objetos resultado de la BBDD
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @return resultados Lista de resultados de la BBDD en formato para mostrar
    */
    public static List getResultadosToPrint() {
    
        ConnectionManager connectionManager = new ConnectionManager();
        List resultados = new LinkedList();
        try {

            Statement stmt = connectionManager.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select centro.nombre as centro, partido.nombre as partido, resultado.votos from resultado, centro, partido where resultado.idCentro = centro.id and resultado.idPartido = partido.id order by centro.nombre, partido.nombre");
            while(rs.next()) {

                ResultadoToPrintVo resultado = new ResultadoToPrintVo(rs.getString("centro"), rs.getString("partido"), rs.getInt("votos"));
                resultados.add(resultado);

            }
            stmt.close();

        } catch(Exception e){

            System.out.println("Exception: " + e.toString());

        }
        connectionManager.disconnect();
        
        return resultados;
        
    }

}