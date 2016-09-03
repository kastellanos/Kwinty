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
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author sebchaparr
 */
@ManagedBean
@ViewScoped

public class ConsultClientBean implements Serializable {

    private long id;
    private List<Client> clients;
    private String message1;

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

    public void getClient(long id) {
        HandleClient clientHandler = new HandleClient();
        clients = clientHandler.getClient(clients, id);
    }

    public ConsultClientBean() {
        HandleClient clientHandler = new HandleClient();
        clients = clientHandler.listAll();
    }

}
