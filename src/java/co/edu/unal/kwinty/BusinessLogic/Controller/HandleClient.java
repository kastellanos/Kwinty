/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ClientDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import java.util.ArrayList;
import java.util.List;

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
    
    public List<Client> getClient(List<Client> allClients, long id){
        ArrayList<Client> clients = new ArrayList<>();
        for(Client c : allClients){
            if(c.getUser().getId() == id) clients.add(c);
        }
        return clients;
    }
    
    public List<Client> listAll(){
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        return clientDAO.getAll();
    }
}
