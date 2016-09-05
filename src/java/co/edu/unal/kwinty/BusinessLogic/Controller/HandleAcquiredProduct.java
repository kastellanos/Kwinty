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

    public String createAcquiredProduct(int numberFees, float amount, float amountPaid, String reference, float feeIncrementRate, String productType,String clientName) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        
        Product product = productDAO.findByType(productType);
        Client client = clientDAO.findByPK(clientName);
        if(client == null) System.err.print("Cliente encontrado" + client.toString());
        if(product == null) System.err.print("Producto encontrado: " + product.toString());
        
        // Product -> AcquiredProduct verifications
        int max_fees = product.getMaxNumberFees();
        if (numberFees > max_fees) {
            return "El producto no fue creado. Excede numero de cuotas maximo";
        }
        
        // Calculate feeAmount
        float[] fees = calculateFees(numberFees, amount, max_fees);
        float feeAmount = fees[1];
        
        
        Date today = new Date();
        Acquiredproduct acquiredproduct = new Acquiredproduct(numberFees,amount, feeAmount, amountPaid, today, feeIncrementRate);
         acquiredproduct.setUsernameId(client);
         acquiredproduct.setProductid(product);
         
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
        ClientDAOImpl clientDAOImpl = new ClientDAOImpl();
        return clientDAOImpl.getClientAdquiredProducts(client);
    }

    
    public float[] calculateFees(int numberFees, float amount, long productID ){
        
        Product currentProduct = searchProduct(productID);
        String fee_type = currentProduct.getFeeType();
        String interest_type = currentProduct.getInterestType();
        float interest = currentProduct.getInterestRate();
        float paid = 0;
        float[] fees = new float[numberFees];
        
        /* Interest type */
        if (interest_type.equals("Simple")) {
            paid = amount + (amount * interest);                                
        }else if (interest_type.equals("Compuesto")) {
            paid = (float) (amount * Math.pow(1 + interest, numberFees));    
        }
        
        /* Fee type */
        switch (fee_type) {
            case "Cuota inicial":
                {
                    fees[0] = (float) (paid * 0.2);
                    paid -= paid * 0.2;
                    float feed = paid / (numberFees - 1);
                    for (int i = 1; i < numberFees; i++) {
                        fees[i] = feed;
                    }       break;
                }
            case "Sin cuota inicial":
                {
                    fees[0] = 0;
                    float feed = paid / (numberFees - 1);
                    for (int i = 1; i < numberFees; i++) {
                        fees[i] = feed;
                    }       break;
                }            
            case "Fija":
                {
                    float feed = paid / numberFees;
                    for (int i = 1; i < numberFees; i++) {
                        fees[i] = feed;
                    }       break;
                }
            default:
                break;
        }
        
        return fees;
    }
    
    
 }
    
   
    
    

