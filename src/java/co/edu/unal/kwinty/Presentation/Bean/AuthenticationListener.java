/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import co.edu.unal.kwinty.DataAcess.DAO.Implementation.UserDAOImpl;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author franco
 */
public class AuthenticationListener implements PhaseListener {

    private String USER_LOGIN_OUTCOME = "index.xhtml";
    private String name;
    private String role;
    
    public void afterPhase(PhaseEvent event) {
        
        FacesContext context = event.getFacesContext();
        UserDAOImpl ud = new UserDAOImpl();
                
        if (userExists(context)) {
            name = getSessionName(context);
            role = ud.searchRoleByName(name);
            System.out.println("USER IS REAL: " + name);
            System.out.println("HIS ROLE IS: " + role);
            if (role.equals("admin")) {
                USER_LOGIN_OUTCOME = "admin_home.xhtml";                
            }else{
                USER_LOGIN_OUTCOME = "client_home.xhtml";
            }
            if (requestingSecureView(context)) {
                context.getApplication().
                    getNavigationHandler().handleNavigation(context, 
                                                                null, 
                                                                USER_LOGIN_OUTCOME);
            }
                      
        }
    }

    public void beforePhase(PhaseEvent event) {
                
    }

    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    private boolean userExists(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();
        return (extContext.getSessionMap().containsKey("active"));
    }
    
    private String getSessionName(FacesContext context){
        ExternalContext extContext = context.getExternalContext();
        HttpSession session = (HttpSession) extContext.getSession(false);
        return (String)session.getAttribute("active");
    }
    
    private boolean requestingSecureView(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();
        String path = extContext.getRequestPathInfo();
        System.out.println(path);
        return ("/index.xhtml".equals(path));
    }
}
