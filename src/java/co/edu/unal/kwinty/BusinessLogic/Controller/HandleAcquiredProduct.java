/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;


import BusinessLogic.Service.Bus.ResponseMessage;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.AcquiredProductDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ClientDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ProductDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Product;
import co.edu.unal.kwinty.DataAcess.Entity.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.ws.Holder;

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

    public String createAcquiredProduct(int numberFees, float amount, float amountPaid, String reference, float feeIncrementRate, String productType,String clientName,Boolean externalClient) {
        ProductDAOImpl productDAO = new ProductDAOImpl();
        ClientDAOImpl clientDAO = new ClientDAOImpl();
        
        Product product = productDAO.findByType(productType);
        Client client = clientDAO.findByPK(clientName);
        
        if (client == null) {
            System.out.println("Lala--------------");
        }else{
            System.out.println(client.toString());
        }
                
        if(numberFees <= 0) return "El producto no fue creado. El numero de cuotas debe ser mayor a 0";
        if(amount <= 0) return "El producto no fue creado. El valor del producto debe ser mayor a 0";
        
        // Product -> AcquiredProduct verifications
        int max_fees = product.getMaxNumberFees();
        if (numberFees > max_fees) {
            return "El producto no fue creado. Excede numero de cuotas maximo";
        }
        
        
        // Calculate feeAmount
        List<Float> fees = calculateFees(numberFees, amount, product.getId());
        float feeAmount = fees.get(1);
        //Service eated
        
        Date today = new Date();
        Acquiredproduct acquiredproduct = new Acquiredproduct(numberFees,amount, feeAmount, amountPaid, today, feeIncrementRate);
         acquiredproduct.setUsernameId(client);
         acquiredproduct.setProductid(product);
         acquiredproduct.setReference(reference);
         boolean created = false;
        AcquiredProductDAOImpl acquiredProductDAOImpl = new AcquiredProductDAOImpl();
        if( externalClient == true){
        javax.xml.ws.Holder<BusinessLogic.Service.Bus.ResponseMessage> createClient = new Holder<>();
        bus1Operation(clientName, clientName, client.getEmail(), Integer.toString(client.getPhonenumber()), client.getAddress(), feeAmount, true, createClient);
        //bus1Operation(clientName, clientName, clientName, clientName, reference, amount, reference, clientName, reference, clientName, createClient);
        
        System.out.println(createClient.value.isSuccees() +" "+createClient.value.getDescription());
        //System.out.println(createClient.toString());
        if( createClient.value.isSuccees()){
            
            created = acquiredProductDAOImpl.create(acquiredproduct);
        }
        }else{
            created = acquiredProductDAOImpl.create(acquiredproduct);
        }
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

    
    public List<Float> calculateFees(int numberFees, float amount, long productID ){
        
        Product currentProduct = searchProduct(productID);
        
        String fee_type = currentProduct.getFeeType();
        String interest_type = currentProduct.getInterestType();
        float interest = currentProduct.getInterestRate();
        float paid = 0;
        List<Float> fees = new ArrayList<Float>(numberFees);
        for (int i = 0; i < numberFees; i++) {
            fees.add((float)0);
        }
        
        /* Interest type */
        if (interest_type.equals("simple")) {
            paid = amount + (amount * interest);                                
        }else if (interest_type.equals("compuesto")) {
            paid = (float) (amount * Math.pow(1 + interest, numberFees));    
        }
        
        /* Fee type */
        switch (fee_type) {
            case "inicial":
                {
                    fees.set(0, (float) (paid * 0.2)) ;
                    paid -= paid * 0.2;
                    float feed = paid / (numberFees - 1);
                    for (int i = 1; i < numberFees; i++) {
                        fees.set(i, feed);
                    }       break;
                }
            case "sin":
                {
                    fees.set(0, (float)0);
                    float feed = paid / (numberFees - 1);
                    for (int i = 1; i < numberFees; i++) {
                        fees.set(i, feed);
                    }       break;
                }            
            case "fija":
                {
                    float feed = paid / numberFees;
                    for (int i = 1; i < numberFees; i++) {
                        fees.set(i, feed);
                    }       
                    break;
                }
            default:
                break;
        }
        
        return fees;
    }

   /* private static ResponseMessage createClient(java.lang.String theName, java.lang.String theLastName, java.lang.String theEmail, java.lang.String thePhone, java.lang.String theAddress, float availableMoney) {
        BusinessLogic.Service.Consume.SalewCreditWS_Service service = new BusinessLogic.Service.Consume.SalewCreditWS_Service();
        BusinessLogic.Service.Consume.SalewCreditWS port = service.getSalewCreditWSPort();
        return port.createClient(theName, theLastName, theEmail, thePhone, theAddress, availableMoney);
    }*/

    private static void bus1Operation(java.lang.String nombre, java.lang.String apellido, java.lang.String correo, java.lang.String telefono, java.lang.String direccion, float monto, boolean hola, javax.xml.ws.Holder<BusinessLogic.Service.Bus.ResponseMessage> responseMessage) {
        BusinessLogic.Service.Bus.Bus1Service service = new BusinessLogic.Service.Bus.Bus1Service();
        BusinessLogic.Service.Bus.Bus1PortType port = service.getBus1Port();
        javax.xml.ws.Holder<BusinessLogic.Service.Bus.AutoMResponseMessage> maResponseMessage = new Holder<>();
        port.bus1Operation(nombre, apellido, correo, telefono, direccion, monto, "vacio", "vacio", "vacio", "vacio", hola, responseMessage, maResponseMessage);
    }


   

    
    
 }
    
   
    
    

