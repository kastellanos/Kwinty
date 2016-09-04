/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.AcquiredProductDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ClientDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ProductDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import co.edu.unal.kwinty.DataAcess.Entity.AcquiredproductPK;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import co.edu.unal.kwinty.DataAcess.Entity.User;
import java.util.Date;
import java.util.List;

/**
 *
 * @author stephanie
 */
public class HandleAcquiredProduct {
    
    private Client client;
    
    public Client searchClient(String username){
        
        UserDAOImpl userDAO = new UserDAOImpl();
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        User user = userDAO.findByPK(username);
        Client client = null;
        if(user.getRole().equals("client")){
            client = clientDAO.findByPK(user.getUsername());
        }
        return client;
    }
    
    public Product searchProduct(long id){
        
        ProductDAOImpl productDAO = new ProductDAOImpl();
        Product product = null;
        product = productDAO.findByPK(id);
        return product;
    }
    
    //private Date acquisitionDate;

    public String createAcquiredProduct(int numberFees, float amount, float feeAmount, float amountPaid, String reference, float feeIncrementRate, String productType,String clientName) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        
        Product product = productDAO.findByType(productType);
        Client client = clientDAO.findByPK(clientName);
        if(client == null) System.err.print("Cliente encontrado" + client.toString());
        if(product == null) System.err.print("Producto encontrado: " + product.toString());
        
        AcquiredproductPK clientProduct = new AcquiredproductPK(clientName, product.getId());
        Date today = new Date();
        Acquiredproduct acquiredproduct = new Acquiredproduct(clientProduct,numberFees,amount, feeAmount, amountPaid, today, feeIncrementRate);
        
        AcquiredProductDAOImpl acquiredProductDAOImpl = new AcquiredProductDAOImpl();
        boolean created = acquiredProductDAOImpl.create(acquiredproduct);
        
        if ( created == true )
            return "El producto ha sido creado.";
        else
            return "El producto no pudo ser creado.";  
    }

    public List<Acquiredproduct> listAll(){
        AcquiredProductDAOImpl acquiredProductDAOImpl = new AcquiredProductDAOImpl();
        return acquiredProductDAOImpl.getAll();
    }
    
    public Acquiredproduct findById(Long id){
        AcquiredProductDAOImpl acquiredProductDAOImpl = new AcquiredProductDAOImpl();
        return acquiredProductDAOImpl.findByPK(id);
    }
            
    public void updatePayment( Acquiredproduct ap ){
        AcquiredProductDAOImpl acquiredProductDAOImpl = new AcquiredProductDAOImpl();
        acquiredProductDAOImpl.update(ap);
    }

    public List<Acquiredproduct> findByClient(String client){
        AcquiredProductDAOImpl acquiredProductDAOImpl = new AcquiredProductDAOImpl();
        return acquiredProductDAOImpl.findByClient(client);
    }

    
    
 }
    
   
    
    

