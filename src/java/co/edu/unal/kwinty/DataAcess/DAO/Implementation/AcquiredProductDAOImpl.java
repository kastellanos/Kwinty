/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.AcquiredProductDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Acquiredproduct;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author stephanie
 */
public class AcquiredProductDAOImpl extends GenericDAOImpl<Acquiredproduct, Long> implements AcquiredProductDAO{
    
    public AcquiredProductDAOImpl() {
        super(Acquiredproduct.class);
    }

    public List<Acquiredproduct> findByClient(String username) {
        EntityManager em = getEmf().createEntityManager();
        List<Acquiredproduct> responseInstance = null;
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
    
    
    public List<Acquiredproduct> getAll(){
        return super.getAll(FINDALL);
    }
    
    private final static String FINDALL= "Acquiredproduct.findAll";
    private final static String FINDBYCLIENT= "Acquiredproduct.findByClientusername";
    
    
}
