/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.AcquiredProductDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.AdminDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.PaymentDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import co.edu.unal.kwinty.DataAcess.Entity.Admin;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Payment;
import co.edu.unal.kwinty.DataAcess.Entity.PaymentPK;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author sebchaparr
 */
public class HandlePayment {
    
    public String registerPayment(Long apID, String admin){
        AcquiredProductDAOImpl apDAO = new AcquiredProductDAOImpl();
        Acquiredproduct ap = apDAO.findByPK(apID);
        AdminDAOImpl adi = new AdminDAOImpl();
        PaymentDAOImpl pay = new PaymentDAOImpl();
        Admin ad = adi.findByPK(admin);
        Client client = ap.getClient();
        float amount = ap.getFeeAmount();
        String user = client.getClientusername();
        long id = pay.getAll().size();
        
        if(ap == null) System.err.print("Product doesnt exist" + ap.toString());
        if(ad == null) System.err.print("Admin doesnt exist: " + ad.toString());
        
        PaymentPK payPK = new PaymentPK(id, user, apID, admin);
        Date today = new Date();
        Payment payment = new Payment(payPK, today, amount);
        
        PaymentDAOImpl paymentDAO = new PaymentDAOImpl();
        float currentPaid = ap.getAmountPaid();
        currentPaid += amount;
        
        if (currentPaid <= ap.getAmount()) {
            boolean created = paymentDAO.create(payment);
            ap.setAmountPaid(currentPaid);
            if ( created == true ){          
                return "El producto ha sido creado.";
            }          
            else
                return "El producto no pudo ser creado.";  
        }else
            return "La deuda ya ha sido saldada";      
    } 
    
    public List<Payment> listAll(){
        PaymentDAOImpl paymentoDAO = new PaymentDAOImpl();
        return paymentoDAO.getAll();
    }
    
    public Payment findById(Long id){
        PaymentDAOImpl paymentoDAO = new PaymentDAOImpl();
        return paymentoDAO.findByPK(id);
    }
            
    public void updatePayment( Payment payment ){
        PaymentDAOImpl paymentDAO = new PaymentDAOImpl();
        paymentDAO.update(payment);
    }

    public List<Payment> findByClient(String client){
        PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
        return paymentDAOImpl.findByClient(client);
    }

    public List<Payment> listByProduct(List<Payment> allPayments, long product){
        List<Payment> payments = new ArrayList<Payment>();
        for(Payment p : allPayments){
            if(p.getAcquiredproduct().getAcquiredproductPK().getProductid() == product) 
                payments.add(p);
        }
        return payments;
    }
    
}
