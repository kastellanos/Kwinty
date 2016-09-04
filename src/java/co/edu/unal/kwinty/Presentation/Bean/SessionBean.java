/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandlePermissions;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.CredentialsDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franco
 */
@ManagedBean
@ApplicationScoped
public class SessionBean {
    
    private String username;
    private String message;
    private String role;

    public void checkSession() {
        HandlePermissions permission = new HandlePermissions();
        
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
    
    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
        
}
