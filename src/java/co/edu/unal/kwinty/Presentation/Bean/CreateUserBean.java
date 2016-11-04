/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleUser;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Andres
 */
@ManagedBean( eager = true)
@ViewScoped
public class CreateUserBean {

    public CreateUserBean() {
    }

    public void createUser() {
        HandleUser createUser = new HandleUser();
        message = "";
        boolean isExist = createUser.userExists(username);
        boolean docDuplicate = createUser.idDuplicate(id);
        if(isExist){
            System.err.println("El usuario existe " +  username);
           message += "El nombre de usuario ya existe.";
           return;
            /*
            FacesMessage faceMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "El usuario ya existe", null );
            FacesContext.getCurrentInstance().addMessage(null, faceMsg);
            return;*/
        }
        if(docDuplicate){
            message += "El documento ya está registrado.";
            return;
        }
        message = createUser.createUser(this.username, this.idType, this.role, this.name, this.id, this.password, this.phone_number, this.email, this.address, this.payment_capacity);
        this.username = "";
        this.idType = "";
        this.role = "";
        this.name = "";
        this.id = 0;
        this.password = "";
        this.phone_number = 0;
        this.email = "";
        this.address = "";
        this.payment_capacity = 0;
    }

    public void createUser(String current_user) {
        HandleUser createUser = new HandleUser();
        if (current_user == null) {
            message = "Pailas jodido";
        } else {
            message = createUser.createUser(current_user, this.username, this.idType, this.role, this.name, this.id, this.password, this.phone_number, this.email, this.address, this.payment_capacity);
        }

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
    private int phone_number;
    private String email;

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
    private String address;
    private float payment_capacity;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getPayment_capacity() {
        return payment_capacity;
    }

    public void setPayment_capacity(float payment_capacity) {
        this.payment_capacity = payment_capacity;
    }

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
