/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ClientDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Client;

/**
 *
 * @author stephanie
 */
public class HandleClient {
    
    public boolean clientExists(String clientName){
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        Client client = null;
        client = clientDAO.findByUsername(clientName);
        
        if(client != null){
            return true;
        }
        return false;
    }
}
