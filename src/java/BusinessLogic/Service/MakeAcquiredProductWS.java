/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.Service;

import co.edu.unal.kwinty.BusinessLogic.Controller.HandleAcquiredProduct;
import co.edu.unal.kwinty.BusinessLogic.Controller.HandleProduct;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author franco
 */
@WebService(serviceName = "MakeAcquiredProductWS")
public class MakeAcquiredProductWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "makeAcquiredProduct")
    public String makeAcquiredProduct(String productName, float amount, int numberFees) {
        
        HandleAcquiredProduct createAcquiredProduct = new HandleAcquiredProduct();
        HandleProduct searchProduct = new HandleProduct();
        float amountPaid = 0;
        float feeIncrementRate = 0;
        String clientName = "CarAccesoriesInc";
        Product product = searchProduct.findByType(productName);
        String message;
        if(product == null){
            message = "No se encontró el producto";
            System.out.println("No se encontró el producto");
        } else{
            message = createAcquiredProduct.createAcquiredProduct(numberFees, amount, amountPaid, "", product.getInterestRate(), productName, clientName,false);
        }
        return message;

    }
}
