/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleProduct;

/**
 *
 * @author stephanie
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class CreateProductBean {
    
    private String type;
    private String feeType;
    private String interestType;
    private int maxNumberFees;
    private float interestRate;
    private String message;
    
    //public Product(String type, String feeType, String interestType, int maxNumberFees, float interestRate) {
    
    //}

    public void createProduct(){
        HandleProduct createProduct = new HandleProduct();
        setMessage(createProduct.createProduct(type, feeType,interestType, maxNumberFees, interestRate));
    }
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the feeType
     */
    public String getFeeType() {
        return feeType;
    }

    /**
     * @param feeType the feeType to set
     */
    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    /**
     * @return the interestType
     */
    public String getInterestType() {
        return interestType;
    }

    /**
     * @param interestType the interestType to set
     */
    public void setInterestType(String interestType) {
        this.interestType = interestType;
    }

    /**
     * @return the maxNumberFees
     */
    public int getMaxNumberFees() {
        return maxNumberFees;
    }

    /**
     * @param maxNumberFees the maxNumberFees to set
     */
    public void setMaxNumberFees(int maxNumberFees) {
        this.maxNumberFees = maxNumberFees;
    }

    /**
     * @return the interestRate
     */
    public float getInterestRate() {
        return interestRate;
    }

    /**
     * @param interestRate the interestRate to set
     */
    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
