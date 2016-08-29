/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.User;

/**
 *
 * @author sebchaparr
 */
public class HandlePermissions {
    
    public boolean isClient(User user){
        return user.getRole().equalsIgnoreCase("Cliente");
    }

    public boolean isAdmin(User user){
        return user.getRole().equalsIgnoreCase("Administrador");
    }
    
    public String[] stablishPermissions(String role){
        if(role.equalsIgnoreCase("Client"))
            return new String[]{
                "Ver mi informacion",
                "Ver mis creditos",
                "Ver mis cuotas",            
                "Ver proyecciones",                        
            };
        return new String[]{
            "Registrar un producto",
            "Actualizar un producto",
            "Registrar un cliente",
            "Actualizar un producto",
            "Ver informacion de clientes",
            "Ver creditos de un cliente",
            "Ver proyecciones",
            "Realizar pagos"
        };
    }
    
    /*Call it prior to perform any action to corroborate that the user has in fact permissions*/
    public boolean checkIfHasPermissions(User user, String actionToPerform){
        UserDAOImpl userDAO = new UserDAOImpl();
        User userPersisted = userDAO.read(user.getUsername());
        if(userPersisted == null){ 
            return false;
        }
        String [] validPermissions = stablishPermissions(userPersisted.getRole());
        for(int i = 0; i < validPermissions.length; i++){
            if(actionToPerform.equalsIgnoreCase(validPermissions[i])){
                /*Check if the user exists in the db and then proceed to perform the action*/
                if(actionToPerform.equalsIgnoreCase(validPermissions[i])){
                    return true;
                }
            }
        }
        return false;
    }
}
