/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleClient;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandleUser;
import co.edu.unal.kwinty.BusinessLogic.Controller.LoginUser;
import javax.faces.application.FacesMessage;
import co.edu.unal.kwinty.BusinessLogic.Controller.LoginLdap;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import org.primefaces.context.*;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andres
 */
@ManagedBean(name="loginBean",eager = true)
@ApplicationScoped
public class LoginBean {

    public LoginBean() {
    }
    
    
    
    public void loginLdap(ActionEvent event){
        FacesMessage messageF = null;

        LoginLdap login = new LoginLdap();
        message = login.login(username, password);
        System.err.println("++++++++" + message);
        if(message.equalsIgnoreCase("Inicio de sesión satisfactorio.")){
            HandleUser handleUser = new HandleUser();
            String role = handleUser.getRole(username);
            
            System.out.println("role*** " + role);
            messageF = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido!", this.username);
            FacesContext context = FacesContext.getCurrentInstance();

            if(role.equalsIgnoreCase("Client")){
                try {
                    context.getExternalContext().redirect("client_home.xhtml");
                    //context.getApplication().getNavigationHandler().handleNavigation(context, null, "client_home.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                try {
                    context.getExternalContext().redirect("admin_home.xhtml");
                    //context.getApplication().getNavigationHandler().handleNavigation(context, null, "admin_home.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }else{
            messageF = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Usuario y/o contraseña invalidos");
            
            //login(event);
        }
        FacesContext.getCurrentInstance().addMessage(null, messageF);
    }
    
    public void login(ActionEvent event){
        LoginUser log = new LoginUser();
        message = log.start(this.username, this.password);
        //return "welcome";
        System.err.println("Este es el mensaje"+ message);
        if(message != null){
            ;
        }else{
            HandleUser handleUser = new HandleUser();
            String role = handleUser.getRole(username);
            
            System.out.println("role*** " + role);

            if(role.equalsIgnoreCase("Client")){
                FacesContext context = FacesContext.getCurrentInstance();
                try {
                    context.getExternalContext().redirect("client_home.xhtml");
                    //context.getApplication().getNavigationHandler().handleNavigation(context, null, "client_home.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                FacesContext context = FacesContext.getCurrentInstance();
                try {
                    context.getExternalContext().redirect("admin_home.xhtml");
                    //context.getApplication().getNavigationHandler().handleNavigation(context, null, "admin_home.xhtml");
                } catch (IOException ex) {
                    Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
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
