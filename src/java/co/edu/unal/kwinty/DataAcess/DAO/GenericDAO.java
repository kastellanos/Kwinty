/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Andres
 * @param <T>
 */
public interface GenericDAO<T, PK extends Serializable> {
    
    
    boolean create(T newInstance);
    T findByPK(PK id);
    boolean update(T transientObject);
    void delete(T transientObject);
    PK getId( T transientObject );
    public List<T> getAll( String namedQuery );

    /**
     *
     * @return
     */
    
}
