/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.CredentialsDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franco
 */
public class LoginUser {

    public String start(String username, String password) {
        FacesContext context = FacesContext.getCurrentInstance();
        CredentialsDAOImpl cdi = new CredentialsDAOImpl();
        
        Credentials check = cdi.findByPK(username);
                             
        if (check != null ) {
            if(check.getPassword().equals(password)){
                
                context.getExternalContext().getSessionMap().put("active", username);
                return null;  
            }else{
                return "Inicio de sesion fallido. La contraseña no es la correcta.";
            }           
        }else{
            return "Inicio de sesion fallido. Usuario '"+username+"' no existe.";
        }
            
    }
    
    public String logout() {
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "index";
    }
    
    
}
