/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.UserDAO;
import co.edu.unal.kwinty.DataAcess.Entity.User;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Andres
 */
public class UserDAOImpl extends GenericDAOImpl<User, String> implements UserDAO{
    
    public User findById(int id){
        EntityManager em = getEmf().createEntityManager();
        User user = null;
        Query q = em.createNamedQuery("User.findById");
        q.setParameter(1, id);

        try {
            user = (User) q.getSingleResult();
        } catch (Exception e) {

        } finally {

        em.close();
        }
        return user;
    }
}
