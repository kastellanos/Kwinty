/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.AdminDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.ClientDAOImpl;
import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import co.edu.unal.kwinty.DataAcess.Entity.Admin;
import co.edu.unal.kwinty.DataAcess.Entity.Client;
import co.edu.unal.kwinty.DataAcess.Entity.Credentials;
import co.edu.unal.kwinty.DataAcess.Entity.User;
import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;
import com.novell.ldap.LDAPModification;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Andres
 */
public class HandleUser {
    private LDAPConnection lc = new LDAPConnection();
    
    public Boolean createUserLdap(String username, String passwordUser, String role){

        String ldapHost = "192.168.2.218";
        String dn = "cn=admin,dc=arqsoft, dc=unal, dc=edu, dc=co";
        String password = "arqsoft20162";

        //String ldapHost = "192.168.2.170";
        //String dn = "cn=admin,dc=kwinty, dc=com";
        //String password = "admin";
        String group = !role.equals("Client") ? "500" : "501";

        int ldapPort =  LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;

        boolean status = false;
        boolean correct = false;
        
        LDAPAttribute attribute = null;
        LDAPAttributeSet attributeSet = new LDAPAttributeSet();
        attributeSet.add(new LDAPAttribute("objectclass", "inetOrgPerson"));
        attributeSet.add(new LDAPAttribute("cn", username + " " + username));
        attributeSet.add(new LDAPAttribute("uid", username));
        attributeSet.add(new LDAPAttribute("sn", username));
        attributeSet.add(new LDAPAttribute("givenname", username));
        attributeSet.add(new LDAPAttribute("userpassword", passwordUser));
        //attributeSet.add(new LDAPAttribute("gidNumber", group));

        String dnUser = "cn=" + username + ",ou=Kwinty,dc=arqsoft, dc=unal, dc=edu, dc=co";
        LDAPEntry newEntry = new LDAPEntry(dnUser, attributeSet);
        
        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("==== Conectado al servidor LDAP ====");
            lc.bind(ldapVersion, dn, password.getBytes("UTF8"));
            System.out.println("==== Autenticado en el servidor ====");
            lc.add(newEntry);
            lc.disconnect();
        } catch(LDAPException ex){
            ex.printStackTrace();
        } 
        catch (UnsupportedEncodingException ex) {
            System.out.println("==== ERROR al conectarse al servidor LDAP ====");
            ex.printStackTrace();
            return false;
        } 

        return correct;
    }
    
    
    
    public String createUser(String current_user, String username, String idType, String role, String name, int id, String password,int phone_number,String email,String address,float payment_capacity){
        /*First check if has permissions*/
        /*Prior to any action, is desirable to verify the permission of the current user*/
        HandlePermissions handlePermissions = new HandlePermissions();
        if(!handlePermissions.checkIfHasPermissions(current_user, "Registrar un cliente")){
            return "El usuario no tiene permisos para realizar la acción solicitada";
        }        
        
        User user = new User(username,idType, role, name, id);
        Credentials credentials = new Credentials(username,password);
        user.setCredentials( credentials );
        
        boolean created = false;
        if(role.equals("client")){
            Client client = new Client(username, phone_number, email, address, payment_capacity);
            client.setUser(user);
            ClientDAOImpl clientDAO = new ClientDAOImpl();
            created = clientDAO.create(client);
        }else{
            Admin admin = new Admin(username);
            admin.setUser(user);
            AdminDAOImpl adminDAO = new AdminDAOImpl();
            created = adminDAO.create(admin);
        }
        if ( created == true ){
            //createUserLdap(username, password);
            return "El usuario ha sido creado.";
        }
        else{
            return "El usuario no pudo ser creado.";  
        }
    }
    
    public String createUser(String username, String idType, String role, String name, int id, String password,int phone_number,String email,String address,float payment_capacity){
        
        User user = new User(username,idType, role, name, id);
        Credentials credentials = new Credentials(username,password);
        user.setCredentials( credentials );
        
        boolean created = false;
        if(role.equals("client")){
            Client client = new Client(username, phone_number, email, address, payment_capacity);
            client.setUser(user);
            ClientDAOImpl clientDAO = new ClientDAOImpl();
            created = clientDAO.create(client);
        }else{
            Admin admin = new Admin(username);
            admin.setUser(user);
            AdminDAOImpl adminDAO = new AdminDAOImpl();
            created = adminDAO.create(admin);
        }
        if ( created == true ){
            createUserLdap(username, password, role);            
            return "El usuario ha sido creado.";
        }
        else
            return "El usuario no pudo ser creado.";  
    }

    public String getRole(String username){
        UserDAOImpl userDAO = new UserDAOImpl();
        User userPersisted = userDAO.findByPK(username);
        if(userPersisted == null){ 
            return null;
        }
        return userPersisted.getRole();
    }
    
    public boolean userExists(String username){
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = null;
        user = userDAO.findByUsername(username);
        if(user != null){
            return true;
        }
        return false;
    }

    public boolean idDuplicate(int id) {
        UserDAOImpl userDAO = new UserDAOImpl();
        User user = null;
        user = userDAO.findById(id);
        if(user != null){
            return true;
        }
        return false;
    }

}
