/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.utilidades;

import com.proyectoweb.srn.to.UsuarioTO;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author TSI
 */
@ManagedBean
@SessionScoped
public class ReglasDeNavegacion implements Serializable {

    private final UsuarioTO usuarioTo;
    private String nombre;

    public ReglasDeNavegacion() {
        usuarioTo = (UsuarioTO) FacesUtils.getSession().getAttribute("usuario");
        try {
            if (usuarioTo == null) {
                System.out.println("No hay registro de usuario");
                UtilidadesSeguridad.getControlSession();
            } else {
                nombre = usuarioTo.getNombre() + " " + usuarioTo.getApellidos();
            }
        } catch (Exception e) {
            System.out.println("Por favor verifique su session");
        }
    }
//    public static String usuario = "inicio.xhtml?faces-redirect=true";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlInicio() {
        return "frmInicio";
    }

    public String getUrlUsuario() {
        return "frmUsuario";
    }

    public String getUrlNotasActuales() {
        return "frmNotasActuales";
    }

    public String getUrlNotasRegistrosExtendido() {
        return "frmNotasRegisExt";
    }

    public String getUrlPensum() {
        return "frmPensum";
    }

    public String getUrlRol() {
        return "hello";
    }

    public String getUrlPermisos() {
        return "index";
    }

}
