package main.controllers;

import java.util.List;
import java.util.Vector;

import main.models.vo.UserVo;
import main.models.vo.SessionVo;
import main.models.dao.UserDao;

/**
 * Esta clase contiene el menu de la clase User y la implementacion de sus metodos
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class LoginController {
    
    /**
    * Método que imprime por pantalla los atributos de todos los objetos User guardados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    */
    public static Vector<Vector> getUsers() {
        
        List usuarios = UserDao.getUsers();
        Vector<Vector> vUsers = new Vector<Vector>();

        for (Object usuario:usuarios) {
            
            Vector<String> data = new Vector<String>();
            data.add("" + ((UserVo) usuario).getId());
            data.add(((UserVo) usuario).getNombre());
            data.add("" + ((UserVo) usuario).getPassword());
            data.add("" + ((UserVo) usuario).getRole());
            vUsers.add(data);

        }
        
        return vUsers;
    
    }
    
    /**
    * Método que imprime por pantalla los atributos de el objeto User guardado
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param idUser El id del usuario a extraer
    */
    public static UserVo getUserById(int idUser) {
        
        return UserDao.getUserById(idUser);
    
    }
    
    /**
    * Método que crea un nuevo objeto User y lo agrega al arreglo donde son almacenados
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre El nombre del usuario a crear
    * @param password El password del usuario a crear
    * @param role El role del usuario a crear
    */
    public static void creaUser(String nombre, String password, int role) {
    
        UserVo usuario = new UserVo(0, nombre, password, role);
        UserDao.createUser(usuario);
    
    }

    /**
    * Método que crea un actualiza un objeto User
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param usuario El objeto usuario a actualizar
    */
    public static void updateUser(UserVo usuario) {
    
        UserDao.updateUser(usuario);
    
    }

    /**
    * Método que chequea el login del User
    * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
    * @param nombre El nombre del usuario a chequear
    * @param password El password del usuario a chequear
    * @return Boolean Comprueba si el usuario existe o no
    */
    public static Boolean checkLogin(String nombre, String password) {

        UserVo session = UserDao.checkLogin(nombre, password);
        if (session.getId() != 0) {
        
            SessionVo.getInstance().setUser(session);
            return true;
        
        }
        return false;
    
    }

}