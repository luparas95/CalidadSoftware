package main.models.vo;

/**
 * Esta clase es un singleton para almacenar la sesión y poder acceder a ella desde cualquier parte de la aplicación
 * @author: Jose Luis Panadero, Gustavo Adolfo Hernández Quesada, Alvaro Francisco Hernáez Colque
 */
public class SessionVo {
    
    private static final SessionVo SINGLETON = new SessionVo();
    
    //Campos de la clase
    private UserVo session;
    
    private SessionVo() {}
    
    public static SessionVo getInstance() {
    
        return SINGLETON;
    
    }
    
    public void setUser(UserVo session) {
    
        this.session = session;
    
    }
    
    public UserVo getUser() {
    
        return this.session;
    
    }

}
