/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.LoginUser;
import javax.ejb.Handle;
import javax.ejb.Stateful;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Andres
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class LoginBean {

    public LoginBean() {
    }
    
    public String login(){
        LoginUser log = new LoginUser();
        message = log.start(this.username, this.password);
        //return "welcome";
        System.err.println("Este es el mensaje"+message);
        if(message != null){
            return message;
        }else{
            return "welcome";
        }
        
    }
    
    public String logout(){
        LoginUser log = new LoginUser();
        message = log.logout();
        return message;
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
