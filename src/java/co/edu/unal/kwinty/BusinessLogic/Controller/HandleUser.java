/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.AdminDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ClientDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Admin;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;
import co.edu.unal.kwinty.DataAcess.Entity.User;

/**
 *
 * @author Andres
 */
public class HandleUser {
    
    
    public String createUser(String current_user, String username, String idType, String role, String name, int id, String password,int phone_number,String email,String address,float payment_capacity){
        /*First check if has permissions*/
        /*Prior to any action, is desirable to verify the permission of the current user*/
        HandlePermissions handlePermissions = new HandlePermissions();
        if(!handlePermissions.checkIfHasPermissions(current_user, "Registrar un cliente")){
            return "El usuario no tiene permisos para realizar la acción solicitada";
        }        
        
        User user = new User(username,idType, role, name, id);
        Credentials credentials = new Credentials(username,password);
        user.setCredentials( credentials );
        
        boolean created = false;
        if(role.equals("client")){
            Client client = new Client(username, phone_number, email, address, payment_capacity);
            client.setUser(user);
            ClientDAOImpl clientDAO = new ClientDAOImpl();
            created = clientDAO.create(client);
        }else{
            Admin admin = new Admin(username);
            admin.setUser(user);
            AdminDAOImpl adminDAO = new AdminDAOImpl();
            created = adminDAO.create(admin);
        }
        if ( created == true )
            return "El usuario ha sido creado.";
        else
            return "El usuario no pudo ser creado.";  
    }
    
    public String createUser(String username, String idType, String role, String name, int id, String password,int phone_number,String email,String address,float payment_capacity){
        
        User user = new User(username,idType, role, name, id);
        Credentials credentials = new Credentials(username,password);
        user.setCredentials( credentials );
        
        boolean created = false;
        if(role.equals("client")){
            Client client = new Client(username, phone_number, email, address, payment_capacity);
            client.setUser(user);
            ClientDAOImpl clientDAO = new ClientDAOImpl();
            created = clientDAO.create(client);
        }else{
            Admin admin = new Admin(username);
            admin.setUser(user);
            AdminDAOImpl adminDAO = new AdminDAOImpl();
            created = adminDAO.create(admin);
        }
        if ( created == true )
            return "El usuario ha sido creado.";
        else
            return "El usuario no pudo ser creado.";  
    }

    public String getRole(String username){
        UserDAOImpl userDAO = new UserDAOImpl();
        User userPersisted = userDAO.findByPK(username);
        if(userPersisted == null){ 
            return null;
        }
        return userPersisted.getRole();
    }
}
