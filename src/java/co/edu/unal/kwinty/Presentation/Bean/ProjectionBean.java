/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleAcquiredProduct;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author franco
 */
@ManagedBean
@ApplicationScoped
public class ProjectionBean {
    private List<Float> projection;
    private String clientName;
    private int numberFees;
    private float amount;
    private long productID;
    private String message;

    public ProjectionBean() {
        
    }

    public void viewProyection() {
        HandleAcquiredProduct viewProyection = new HandleAcquiredProduct();
        projection = viewProyection.calculateFees(numberFees, amount, productID);
    }

    
    public List<Float> getProjection() {
        return projection;
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
    
    public void setProyection(List<Float> proyection) {
        this.projection = proyection;
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
        HandleAcquiredProduct viewProjection = new HandleAcquiredProduct();
        Acquiredproduct acquierdProduct = viewProjection.findById(productID);
        projection = viewProjection.calculateFees(acquierdProduct.getNumberFees(), acquierdProduct.getAmount(), acquierdProduct.getProductid().getId());
        //projection = viewProjection.calculateFees(productID);
        
    }
}
