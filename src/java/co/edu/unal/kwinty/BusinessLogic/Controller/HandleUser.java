/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;
import co.edu.unal.kwinty.DataAcess.Entity.User;

/**
 *
 * @author Andres
 */
public class HandleUser {
    public String createAccount(String username, String idType, String role, String name, int id, String password){
        User user = new User(username,idType, role, name, id);
        Credentials credentials = new Credentials(username,password);
        user.setCredentials( credentials );
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        boolean created = userDAOImpl.create(user);
        if ( created == true )
            return "El usuario ha sido creado.";
        else
            return "El usuario no pudo ser creado.";  
    }
}
