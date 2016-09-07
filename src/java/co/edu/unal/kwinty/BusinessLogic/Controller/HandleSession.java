/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.BusinessLogic.Controller;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franco
 */
public class HandleSession {
    
    public boolean checkSession() {
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if(session != null) {
            return true;
        }
        return false;
    }
    
    public String SessionUsername() {
        HttpSession session = (HttpSession)
             FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        return (String) session.getAttribute("active");
    }
    
    public String SessionRole() {
        UserDAOImpl ud = new UserDAOImpl();
        String name = SessionUsername();
        return ud.searchRoleByName(name);
    }
}
