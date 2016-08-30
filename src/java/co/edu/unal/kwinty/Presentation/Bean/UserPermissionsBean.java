/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandlePermissions;
import co.edu.unal.kwinty.DataAcess.Entity.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author sebchaparr
 */
@ManagedBean
@ViewScoped
public class UserPermissionsBean {
    
    /*current logged user this info should be implemented in a session bean*/
    private String username;
    private boolean isClient = true;
    private String[] permissions;
    private String current_view;
    /*-----------------------*/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurrent_view() {
        return current_view;
    }

    public void setCurrent_view(String current_view) {
        this.current_view = current_view;
    }

    public boolean isIsClient() {
        System.out.println(isClient);
        return isClient;
    }

    public void setIsClient(boolean isClient) {
        this.isClient = isClient;
    }
}



