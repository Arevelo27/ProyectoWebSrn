/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.control;

import com.proyectoweb.srn.to.UsuarioTO;
import com.proyectoweb.srn.utilidades.FacesUtils;
import com.proyectoweb.srn.utilidades.UtilidadesSeguridad;
import java.io.Serializable;
import javax.faces.application.ViewExpiredException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
//hola
/**
 *
 * @author TSI
 */
@ManagedBean(name = "login")
@SessionScoped
public class LoginControllerMB implements Serializable {

    private String username;
    private String password;
    private UsuarioTO usuarioTo;
    private final HttpServletRequest httpServletRequest;
//    private FsuperTblUsuarios usuario;

//    @EJB
//    private FsuperTblUsuariosFacade usuariosFacade;
    /**
     *
     */
    public LoginControllerMB() {
        httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usuario");
//        usuario = new FsuperTblUsuarios();
    }

    /**
     *
     * @return
     */
    public String loginControl() {
        boolean esNull;
        try {
            usuarioTo = new UsuarioTO();
            String password_md5 = UtilidadesSeguridad.getMD5(this.password);
            System.out.println(password_md5);

//            if (usuariosFacade.LoginControl(username, password_md5)) {
//                usuario = usuariosFacade.LoginSession(username, password_md5);
//                return "inicio.xhtml?faces-redirect=true";
//            }
            esNull = FacesUtils.isNotNull(username) && FacesUtils.isNotNull(password);
            if (esNull) {
//          if (usuariosFacade.LoginControl(username, password_md5)) {
                if (username.equals("a") && password.equals("a")) {
                    esNull = false;
//                  usuario = usuariosFacade.LoginSession(username, password_md5);

                    usuarioTo.setApellidos("xxx");
                    usuarioTo.setCodigo("xxx");
                    usuarioTo.setContrasena(password);
                    usuarioTo.setEstado("A");
                    usuarioTo.setNombre(username);
                    usuarioTo.setRolCodigo("User");
                    usuarioTo.setLogin(username);

                    FacesUtils.getSession().setAttribute("usuario", usuarioTo);
                    return "frmInicio";
                }
            } else {
                RequestContext.getCurrentInstance().update("growl");
                FacesUtils.addErrorMessage("Varificar Datos");
                return "";
            }
            RequestContext.getCurrentInstance().update("growl");
            FacesUtils.addErrorMessage("Usuario o Clave incorrecta!!!");

        } catch (ViewExpiredException e) {
            FacesUtils.controlLog("INFO", e);
            UtilidadesSeguridad.getControlSession();
        } catch (Exception ex) { 
            FacesUtils.controlLog("SEVERE", "Error en la clase LoginControllerMB del metodo: " + ex.getMessage());
        }
        return "";
    }

    /**
     *
     */
    public void controlSession() {
        UtilidadesSeguridad.getControlSession();
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
//    public FsuperTblUsuarios getUsuario() {
//        return usuario;
//    }
    /**
     *
     * @param usuario
     */
//    public void setUsuario(FsuperTblUsuarios usuario) {
//        this.usuario = usuario;
//    }
}
