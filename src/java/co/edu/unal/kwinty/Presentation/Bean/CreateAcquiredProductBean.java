/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleAcquiredProduct;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandleClient;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandleProduct;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author stephanie
 */
import javax.inject.Named;
import javax.faces.bean.ViewScoped;

//(name = "CreateAcquiredProductBean")
@ManagedBean
@ViewScoped
public class CreateAcquiredProductBean implements Serializable {

    private int numberFees;
    private float amount;
    private float feeAmount;
    private float amountPaid;
    private String reference;
    private Date acquisitionDate;
    private float feeIncrementRate;
    private String clientName;
    private String productName;
    private String message;
    private int clientDoc;
    private List<Product> products;

    public CreateAcquiredProductBean() {
        HandleProduct handleProduct = new HandleProduct();
        products = handleProduct.listAll();
        if (products != null) {
            System.out.print("Es nulo");

        }
    }

    public boolean validateClientName() {
        HandleClient handleClient = new HandleClient();

        if (!handleClient.clientExists(clientName)) {
            message = "El cliente no está registrado.";
            return false;
        }
        return true;
    }

    public void createAcquiredProduc() {

        HandleAcquiredProduct createAcquiredProduct = new HandleAcquiredProduct();
        amountPaid = 0;
        feeIncrementRate = 0;

        if (validateClientName()) {
            message = createAcquiredProduct.createAcquiredProduct(numberFees, amount, amountPaid, reference, feeIncrementRate, productName, clientName);
        } else {
            message += " Debe registrar el cliente ";
        }
    }

    /**
     * @return the numberFees
     */
    public int getNumberFees() {
        return numberFees;
    }

    /**
     * @param numberFees the numberFees to set
     */
    public void setNumberFees(int numberFees) {
        this.numberFees = numberFees;
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * @return the feeAmount
     */
    public float getFeeAmount() {
        return feeAmount;
    }

    /**
     * @param feeAmount the feeAmount to set
     */
    public void setFeeAmount(float feeAmount) {
        this.feeAmount = feeAmount;
    }

    /**
     * @return the amountPaid
     */
    public float getAmountPaid() {
        return amountPaid;
    }

    /**
     * @param amountPaid the amountPaid to set
     */
    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return the acquisitionDate
     */
    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    /**
     * @param acquisitionDate the acquisitionDate to set
     */
    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    /**
     * @return the feeIncrementRate
     */
    public float getFeeIncrementRate() {
        return feeIncrementRate;
    }

    /**
     * @param feeIncrementRate the feeIncrementRate to set
     */
    public void setFeeIncrementRate(float feeIncrementRate) {
        this.feeIncrementRate = feeIncrementRate;
    }

    /**
     * @return the client
     */
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * @return the product
     */
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    /**
     * @return the clientDoc
     */
    public int getClientDoc() {
        return clientDoc;
    }

    /**
     * @param clientDoc the clientDoc to set
     */
    public void setClientDoc(int clientDoc) {
        this.clientDoc = clientDoc;
    }

    public void setProduct(List<Product> products) {
        this.products = products;
    }

    /**
     * @return the products
     */
    public List<Product> getProducts() {
        return products;
    }

}
