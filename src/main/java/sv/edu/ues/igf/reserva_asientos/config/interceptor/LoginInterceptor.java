/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sv.edu.ues.igf.reserva_asientos.config.interceptor;

import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jpurquilla
 */
public class LoginInterceptor implements PhaseListener{
    @Override
    public void beforePhase(PhaseEvent event) {
        FacesContext facesContext = event.getFacesContext();
        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        System.out.println("URI ------------------> " + request.getRequestURI());
        // Si la página no está en la lista de páginas protegidas, no hacemos nada
        if (!isProtectedPage(request.getRequestURI())) {
            return;
        }

        // Si el usuario no está logueado, redirigimos a la página de login
        if (facesContext.getExternalContext().getSessionMap().get("usuario") == null) {
            try {
                facesContext.getExternalContext().redirect(facesContext.getExternalContext().getRequestContextPath() + "/seguridad/login.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginInterceptor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void afterPhase(PhaseEvent event) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }

    private boolean isProtectedPage(String requestURI) {
        // Lista de páginas protegidas
        System.out.println("requesURI " + requestURI);
        List<String> protectedPages = Arrays.asList("/portal/reserva.xhtml", "/admin/registro.xhtml", "/portal/historial.xhtml", "/portal/pagosentradas.xhtml");

        return protectedPages.contains(requestURI);
    }
    
   

}
