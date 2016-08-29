/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.GenericDAO;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author Andres
 */
public class GenericDAOImpl <T, PK extends Serializable> implements GenericDAO<T,PK>{
    
    private EntityManagerFactory emf;
    
    public GenericDAOImpl() {
        emf = Persistence.createEntityManagerFactory("KwintyPU");
    }
    /*
    
    
    @Override
    public boolean create(T newInstance) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
    Set<ConstraintViolation<T>> constraintViolations = validator.validate(newInstance);
    if(constraintViolations.size() > 0){
        Iterator<ConstraintViolation<T>> iterator = constraintViolations.iterator();
        while(iterator.hasNext()){
            ConstraintViolation<T> cv = iterator.next();
            System.err.println(cv.getRootBeanClass().getName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            System.out.println(cv.getRootBeanClass().getSimpleName()+"."+cv.getPropertyPath() + " " +cv.getMessage());
            
        }
        return false;
    }else{
        EntityManager em = emf.createEntityManager();
        em.persist(newInstance);
    }
        return true;
    }
    
    */
    @Override
    public boolean create(T newInstance) {
        EntityManager em = getEmf().createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(newInstance);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            return false;
        } finally {
            em.close();
        }
        return true;
    }
    
    
    @Override
    public T read(PK id) {
        EntityManager em = getEmf().createEntityManager();
        T responseInstance = null;
        Query q = em.createNamedQuery("User.findByUsername");
        q.setParameter("username", id);
        try {
            responseInstance = (T) q.getSingleResult();
        } catch (Exception e) {
        } finally {
            em.close();
        }
        return responseInstance;
    }

    @Override
    public void update(T transientObject) {
        T newInstance;
        EntityManager em = getEmf().createEntityManager();  
        em.getTransaction().begin();
        try {
            newInstance = em.merge(transientObject); 
            //newInstance = em.merge(em.find(T.class, this.getId(transientObject)));
            //newInstance.setSomeVariable(transientObject.setSomeVariable);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(T transientObject) {
        T newInstance;
        EntityManager em = getEmf().createEntityManager();  
        em.getTransaction().begin();
        try {
            em.remove(transientObject); 
            //newInstance = em.merge(em.find(T.class, this.getId(transientObject)));
            //newInstance.setSomeVariable(transientObject.setSomeVariable);
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    @Override
    public List<T> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
/*
  private Class<T> getEntityClass(){
      return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }
    */

    @Override
    public PK getId(T transientObject) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the emf
     */
    public EntityManagerFactory getEmf() {
        return emf;
    }

    /**
     * @param emf the emf to set
     */
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    
    
}
