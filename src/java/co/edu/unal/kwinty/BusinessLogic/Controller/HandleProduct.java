/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ProductDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stephanie
 */
public class HandleProduct {


    public List<Product> getProductById(List<Product> allProducts, Long id){
        ArrayList<Product> products = new ArrayList<>();
        for(Product c : allProducts){
            if(c.getId().equals(id) ) products.add(c);
        }
        return products;
    }
    

    public String updateProduct(String current_user, String type, String feeType, String interestType, int maxNumberFees, float interestRate, String description){
        /*First check if has permissions*/
        /*Prior to any action, is desirable to verify the permission of the current user*/
        HandlePermissions handlePermissions = new HandlePermissions();
        if(!handlePermissions.checkIfHasPermissions(current_user, "Registrar un cliente")){
            return "El usuario no tiene permisos para realizar la acción solicitada";
        }        
        return updateProduct(type, feeType, interestType, maxNumberFees, interestRate, description);
    }    
    
    public String updateProduct(String type, String feeType, String interestType, int maxNumberFees, float interestRate, String description){
        Product product = new Product(type,feeType, interestType, maxNumberFees, interestRate, description);
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        boolean update = productDAOImpl.update(product);
        if ( update == true )
            return "El producto ha sido actualizado.";
        else
            return "El producto no pudo ser actualizado.";  
    }
    
    public String createProduct(String current_user, String type, String feeType, String interestType, int maxNumberFees, float interestRate, String description){
        /*First check if has permissions*/
        /*Prior to any action, is desirable to verify the permission of the current user*/
        HandlePermissions handlePermissions = new HandlePermissions();
        if(!handlePermissions.checkIfHasPermissions(current_user, "Registrar un cliente")){
            return "El usuario no tiene permisos para realizar la acción solicitada";
        }        
        return createProduct(type, feeType, interestType, maxNumberFees, interestRate, description);
    }
    
    public String createProduct(String type, String feeType, String interestType, int maxNumberFees, float interestRate, String description){
        Product product = new Product(type,feeType, interestType, maxNumberFees, interestRate, description);
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
    
    public Product findById(Long id){
        ProductDAOImpl productoDAO = new ProductDAOImpl();
        return productoDAO.findByPK(id);
    }
    
    public String deleteProduct(String current_user, Long id){
        /*First check if has permissions*/
        /*Prior to any action, is desirable to verify the permission of the current user*/
        HandlePermissions handlePermissions = new HandlePermissions();
        if(!handlePermissions.checkIfHasPermissions(current_user, "Registrar un cliente")){
            return "El usuario no tiene permisos para realizar la acción solicitada";
        }        
        
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = productDAO.findByPK(id);
        if(product == null){
            //productDAO.deleteProduct(product);
            return "El producto no existe.";
        }else{
            productDAO.delete(product);
            return "El producto ha sido borrado.";
        }}


    public String deleteProduct(Long id){
        
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = productDAO.findByPK(id);
        if(product == null){
            //productDAO.deleteProduct(product);
            return "El producto no existe.";
        }else{
            productDAO.delete(product);
            return "El producto ha sido borrado.";
        }}
        
    public List<Product> getProduct(List<Product> allProducts, long id){
        ArrayList<Product> products = new ArrayList<>();
        for(Product c : allProducts){
            if(c.getId() == id) products.add(c);
        }
        return products;
    }

    public void updateProduct( Product product ){
        ProductDAOImpl productDAO = new ProductDAOImpl();
        productDAO.update(product);
    }

    public Product findByType(String type){
        ProductDAOImpl productoDAO = new ProductDAOImpl();
        return productoDAO.findByType(type);
    }
    
}
