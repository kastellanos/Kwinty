/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import static co.edu.unal.kwinty.DataAcess.DAO.Implementation.GenericDAOImpl.getEntityManager;
import co.edu.unal.kwinty.DataAcess.DAO.PaymentDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Payment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author sebchaparr
 */
public class PaymentDAOImpl extends GenericDAOImpl<Payment, Long> implements PaymentDAO{
    public PaymentDAOImpl() {
        super(Payment.class);
    }

    public List<Payment> findByClient(String username) {
        EntityManager em = getEntityManager();
        List<Payment> responseInstance = null;
        Query q = em.createNamedQuery(FINDBYCLIENT);
        q.setParameter("clientusername", username);
        try {
            responseInstance =  q.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return responseInstance;
    }
    
    
    public List<Payment> getAll(){
        return super.getAll(FINDALL);
    }
    
    private final static String FINDALL= "Payment.findAll";
    private final static String FINDBYCLIENT= "Payment.findByClientusername";

    
    
}
