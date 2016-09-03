/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.LoginUser;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Andres
 */
@ManagedBean
@ApplicationScoped
public class LoginBean {

    public LoginBean() {
    }
    
    public void login(){
        LoginUser log = new LoginUser();
        message = log.start(this.username, this.password);
        //return "welcome";
        System.err.println("Este es el mensaje"+ message);
        if(message != null){
            ;
        }else{
            FacesContext context = FacesContext.getCurrentInstance();
            context.getApplication().getNavigationHandler().handleNavigation(context, null, "admin_home.xhtml");
            /*try {
                FacesContext.getCurrentInstance().getExternalContext().dispatch("admin_home.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }*/
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
