/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;
import DAO.UsuarioDAO;
import entidades.*;
import loginapplication.FramePrincipal;
/**
 *
 * @author USUARIO
 */
public class ValidarLogin {

    //private Sistema sistema = FramePrincipal.sistema;
    private UsuarioDAO dao = new UsuarioDAO();
            
    public ValidarLogin() {
    }
        
    public String verificarLogin(Usuario usuario){
        if(!verificarLongitudNombre(usuario.getNombre())){
            return("Longitud de nombre incorrecta");
        }
        if(!verificarLongitudContrasena(usuario.getContrasena())){
            return("Longitud de contraseña incorrecta");
        }
        
    /*    for(Usuario u: sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre()) &&
               u.getContrasena().equals(usuario.getContrasena())){
            return "Bienvenido";
            }  
        }*/
        if(dao.leer(usuario) != null){
            return("Bienvenido");
        }
        return "Datos incorrectos";    
    }
    
    public boolean verificarLongitudNombre(String nombre){       
        return (nombre.length() > 1 && nombre.length() <= 6);

    }
    
    public boolean verificarLongitudContrasena(String contrasena){
        return (contrasena.length() >= 3 && contrasena.length() < 6);
    }
 
}
