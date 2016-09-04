
package co.edu.unal.kwinty.DataAcess.DAO.Implementation;

import co.edu.unal.kwinty.DataAcess.DAO.ClientDAO;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class ClientDAOImpl extends GenericDAOImpl<Client, String> implements ClientDAO {

    public ClientDAOImpl() {
        super(Client.class);
    }

    
    public List<Client> getAll() {
        return super.getAll(ClientDAOImpl.FINDALL);
    }

    private final static String FINDALL = "Client.findAll";




}
