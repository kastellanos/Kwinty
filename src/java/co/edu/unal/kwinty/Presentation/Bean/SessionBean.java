/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleSession;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

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
    private boolean active;

    public void checkSession() {
        HandleSession session = new HandleSession();
        if(session.checkSession()) {
            active = true;
            username = session.SessionUsername();
            role = session.SessionRole();
        }else{
            active = true;
        }
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
    
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
        
}
