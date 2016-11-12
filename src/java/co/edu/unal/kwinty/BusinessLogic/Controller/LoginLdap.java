/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPException;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author sebchaparr
 */
public class LoginLdap {
    private LDAPConnection lc = new LDAPConnection();

    public String login(String user, String password){

        if (connect()) {
            if (validatePassword(user, password)) {
                return "Inicio de sesión satisfactorio.";
            } else {
                return "Usuario y/o contraseña incorrectos.";
            }
        } else {
            return "Conexión al servidor LDAP fallida.";
        }
    }

    public Boolean connect(){

        String ldapHost = "192.168.2.170";
        String dn = "cn=admin,dc=kwinty, dc=com";
        String password = "admin";

        int ldapPort =  LDAPConnection.DEFAULT_PORT;
        int ldapVersion = LDAPConnection.LDAP_V3;

        try {
            lc.connect(ldapHost, ldapPort);
            System.out.println("==== Conectado al servidor LDAP ====");
            lc.bind(ldapVersion, dn, password.getBytes("UTF8"));
            System.out.println("==== Autenticado en el servidor ====");
            return true;
        } catch (LDAPException | UnsupportedEncodingException ex) {
            System.out.println("==== ERROR al conectarse al servidor LDAP ====");
            return false;
        }

    }

    public Boolean validatePassword(String user, String password){
        
        
        System.err.println("---> usuario " + user + " pass : " + password);
        String dn = "cn=" + user + ",ou=Kwinty,dc=kwinty,dc=com";

        try {
            lc.bind(dn, password);
            System.out.println("==== Contraseña validada ====");
            return true;
        } catch (LDAPException ex) {
            System.out.println("==== ERROR al validar la contraseña ====");
            return false;
        }
    }
    
}



