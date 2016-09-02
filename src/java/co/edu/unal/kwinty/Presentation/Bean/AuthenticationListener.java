/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unal.kwinty.Presentation.Bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author franco
 */
public class AuthenticationListener implements PhaseListener {

    private static final String USER_LOGIN_OUTCOME = "index.xhtml";

    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();

        if (userExists(context)) {
            System.out.println("USER IS REAL!!!11!!");
            /*
            context.responseComplete();              
            context.getApplication().
                    getNavigationHandler().handleNavigation(context, 
                                                                null, 
                                                                USER_LOGIN_OUTCOME);
         */   
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

    private boolean requestingSecureView(FacesContext context) {
        ExternalContext extContext = context.getExternalContext();
        String path = extContext.getRequestPathInfo();
        System.out.println(path);
        return (!"/login.xhtml".equals(path) && !"/createUser.xhtml".equals(path));
    }
}
