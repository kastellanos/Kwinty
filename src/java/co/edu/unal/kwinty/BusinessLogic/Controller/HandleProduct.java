/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ProductDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import java.util.List;

/**
 *
 * @author stephanie
 */
public class HandleProduct {
    
    public String createProduct(String type, String feeType, String interestType, int maxNumberFees, float interestRate){
        Product product = new Product(type,feeType, interestType, maxNumberFees, interestRate);
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        boolean created = productDAOImpl.create(product);
        if ( created == true )
            return "El producto ha sido creado.";
        else
            return "El producto no pudo ser creado.";  
    }
    
    public List<Product> listAll(){
        ProductDAOImpl productoDAO = new ProductDAOImpl();
        return productoDAO.getAll();
    }
}
