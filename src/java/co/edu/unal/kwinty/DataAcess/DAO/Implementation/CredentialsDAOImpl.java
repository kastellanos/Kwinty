/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.CredentialsDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;

/**
 *
 * @author franco
 */
public class CredentialsDAOImpl extends GenericDAOImpl<Credentials, String> implements CredentialsDAO {
    
    

    public CredentialsDAOImpl() {
        super(Credentials.class);
    }
    

}
