/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.CredentialsDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franco
 */
public class LoginUser {

    public String start(String username, String password) {
        
        CredentialsDAOImpl cdi = new CredentialsDAOImpl();
        Credentials check = cdi.searchByUsername(username);
        
        if (check != null) {
            if(check.getPassword().equals(password)){
                // DO LOGIN
                // Cookie session = new Cookie("user", username);
                return " Bienvenido " + username;
            }else{
                return " Contraseña incorrecta";
            }           
        }else{
            return " Usuario incorrecto";
        }
            
    }
    
}
