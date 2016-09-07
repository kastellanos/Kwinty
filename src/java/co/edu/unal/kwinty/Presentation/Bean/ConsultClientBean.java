/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleClient;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author sebchaparr
 */
@ManagedBean
@ViewScoped

public class ConsultClientBean implements Serializable {
    private Client editClient;
    private long id;
    private List<Client> clients;
    private String message1;
    private HandleClient clientHandler;
    
    public String getMessage1() {
        return message1;
    }

    public void setMessage1(String message1) {
        this.message1 = message1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Client getEditClient() {
        return editClient;
    }

    public void setEditClient(Client editClient) {
        this.editClient = editClient;
    }

    
    public void getClient(long id) {
        //clientHandler = new HandleClient();
        clients = clientHandler.getClient(clients, id);
    }
public void getClientByUsername(String id) {
        //clientHandler = new HandleClient();
        editClient = clientHandler.getClientByUsername(clients, id).get(0);
        System.out.println(editClient.getUsername());
    }
    public ConsultClientBean() {
        clientHandler = new HandleClient();
        clients = clientHandler.listAll();
    }
   /* public List<Client> listAllClients(){
        
    }*/
    
    public void deleteClient( Client client ){
        System.out.println("Se eliminara el usuario " + client);
        clientHandler.deleteClient(client);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "clientes.xhtml");
        
    }
    public void updateClient( Client client ){
        System.out.println("Se actualizara el usuario " + client);
        clientHandler.updateClient(client);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "clientes.xhtml");
    }
}
