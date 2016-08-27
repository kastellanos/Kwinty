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
public class CreateUserBean {

    public CreateUserBean() {
    }
    
    public void createUser(){
        HandleUser createUser = new HandleUser();
        message = createUser.createAccount(this.username, this.idType, this.role, this.name, this.id,this.password);
    }

    public String getUsername() {
        return username;
    }

    public String getIdType() {
        return idType;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
    private String username;
    private String idType;
    private String role;
    private String name;
    private int id;
    private String message;
    private String password;
    public void setUsername(String username) {
        this.username = username;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    
}
