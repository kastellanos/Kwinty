/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleAcquiredProduct;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandleClient;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandleProduct;
import java.util.Date;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author franco
 */
@ManagedBean
@ApplicationScoped
public class ProjectionBean {
    private float[] proyection;
    private String clientName;
    private int numberFees;
    private float amount;
    private long productID;
    private String message;

    public ProjectionBean() {
        
    }

    public void viewProyection() {
        HandleAcquiredProduct viewProyection = new HandleAcquiredProduct();
        proyection = viewProyection.calculateFees(numberFees, amount, productID);
    }

    
    public float[] getProyection() {
        return proyection;
    }

    public String getClientName() {
        return clientName;
    }

    public int getNumberFees() {
        return numberFees;
    }

    public float getAmount() {
        return amount;
    }

    public long getProductID() {
        return productID;
    }
    
    public void setProyection(float[] proyection) {
        this.proyection = proyection;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setNumberFees(int numberFees) {
        this.numberFees = numberFees;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public void createProjection(){
        HandleAcquiredProduct viewProyection = new HandleAcquiredProduct();
        //proyection = viewProyection.calculateFees(productID);
        
    }
}
