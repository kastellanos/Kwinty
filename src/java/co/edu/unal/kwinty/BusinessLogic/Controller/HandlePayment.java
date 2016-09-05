/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ClientDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.PaymentDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Payment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sebchaparr
 */
public class HandlePayment {
    
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

    /*public List<Payment> findByClient(String client){
        PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
        return paymentDAOImpl.findByClient(client);
    }*/
    public List<Payment> findByClient(String client){
        PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
        ClientDAOImpl clientDAOImpl = new ClientDAOImpl();
        
        return clientDAOImpl.findPaymentByClient(client);
    }
    public List<Payment> listByProduct(List<Payment> allPayments, long product){
        List<Payment> payments = new ArrayList<Payment>();
        for(Payment p : allPayments){
            if(p.getAcquiredproductid().getProductid().getId() == product){ 
                payments.add(p);
            }
        }
        return payments;
    }
    
}
