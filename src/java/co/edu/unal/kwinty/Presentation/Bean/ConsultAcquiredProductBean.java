/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleAcquiredProduct;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandlePayment;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author stephanie
 */
@ManagedBean
@ViewScoped

public class ConsultAcquiredProductBean {

    private List<Acquiredproduct> acquiredProduct;
    private String clientUsername;

    public void consultByClient(){
        
        HandleAcquiredProduct consultAcquiredProd = new HandleAcquiredProduct();
        System.err.println("Usuario: " + clientUsername);
        acquiredProduct = consultAcquiredProd.findByClient(clientUsername); 
        if(acquiredProduct == null){
            acquiredProduct = new ArrayList<>();
        }
        
    }
    
    
    /**
     * @return the acquiredProduct
     */
    public List<Acquiredproduct> getAcquiredProduct() {
        return acquiredProduct;
    }

    /**
     * @param acquiredProduct the acquiredProduct to set
     */
    public void setAcquiredProduct(List<Acquiredproduct> acquiredProduct) {
        this.acquiredProduct = acquiredProduct;
    }

    /**
     * @return the clientUsername
     */
    public String getClientUsername() {
        return clientUsername;
    }

    /**
     * @param clientUsername the clientUsername to set
     */
    public void setClientUsername(String clientUsername) {
        this.clientUsername = clientUsername;
    }
    
}
