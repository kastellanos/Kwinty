/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleUser;
import javax.ejb.Handle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Andres
 */
@ManagedBean
@ViewScoped
public class LoginBean {

    public LoginBean() {
    }
    
    public void login(){
        //HandleUser createUser = new HandleUser();
        //message = createUser.createAccount(this.username, this.password);
    }

    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    private String username;
    private String message;
    private String password;
        
}
