/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleClient;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */
@ManagedBean
@ViewScoped
public class clientProfileBean {
    
    @PostConstruct
    public void init(){
        client = new HandleClient().clientGetClient(loginBean.getUsername());
        System.out.println("Hello World init " +loginBean.getUsername());
        
    }

    public clientProfileBean() {
        System.out.println("Hello World main");
    }
    public void updateClient( Client client ){
        System.out.println("Se actualizara el usuario " + client);
        HandleClient handleClient = new HandleClient();
        handleClient.updateClient(client);
        FacesContext context = FacesContext.getCurrentInstance();
        context.getApplication().getNavigationHandler().handleNavigation(context, null, "clientProfile.xhtml");
    }
    
    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    @ManagedProperty("#{loginBean}")
    private LoginBean loginBean;
    private Client client;
}
