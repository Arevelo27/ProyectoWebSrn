/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.control;

import com.proyectoweb.srn.modelo.SrnTblRol;
import com.proyectoweb.srn.persistencia.SrnTblRolFacade;
import com.proyectoweb.srn.utilidades.FacesUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author TSI
 */
@ManagedBean(name = "rolBn")
@ViewScoped
public class RolControllerMB implements GenericBean<SrnTblRol>, Serializable {

    private SrnTblRol rol;
    private int id;
    private String desc;
    
    /*Debemos cambiar este ejb e investigar otro servicio*/
    @EJB
    private SrnTblRolFacade rolFacade;
    private boolean edit = false;
    private boolean form = false;

    private List<SrnTblRol> listRol = new ArrayList<SrnTblRol>();

    @PostConstruct
    public void init() {
        lista();
    }

    public void lista() {
        listRol = rolFacade.findAll();
    }

    @Override
    public void verForm() {
        rol = new SrnTblRol();
        id = 0;
        desc = "";
        form = true;
        edit = false;
    }

    @Override
    public void volverForm() {
        form = false;
        edit = false;
        lista();
    }

    /**
     *
     * @param r
     */
    @Override
    public void renderizarItem(SrnTblRol r) {
        rol = r;
        desc = r.getStrDescripcion();
        form = true;
        edit = true;
    }

    @Override
    public void eliminarItem(SrnTblRol r) {
        try {
            rolFacade.remove(r);
            lista();
        } catch (Exception e) {
        }
    }

    @Override
    public String aceptar() {
        String navegacion = "";
        try {
            if (preAction()) {
                if (!edit) {
                    id = rolFacade.findMaxId();
                    if (rolFacade.find(id) == null) {
                        rol.setNumIdRol(id);
                        rol.setStrDescripcion(desc);
                        rolFacade.create(rol);

                        vaciarVariables();

                        RequestContext.getCurrentInstance();
                        FacesUtils.addInfoMessage("Registro exitoso");
//                    }
                    }
                } else {
                    rol.setStrDescripcion(desc);
                    rolFacade.edit(rol);

                    RequestContext.getCurrentInstance();
                    FacesUtils.addInfoMessage("Actualizacón exitosa");
                }
            }
        } catch (Exception e) {
        }
        return navegacion;
    }

    public void vaciarVariables() {
        int id;
        desc = "";
        id = 0;
        rol = new SrnTblRol();
    }

    @Override
    public boolean preAction() {
        boolean accion = true;
        return accion;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public SrnTblRol getRol() {
        return rol;
    }

    public void setRol(SrnTblRol rol) {
        this.rol = rol;
    }

    public boolean isForm() {
        return form;
    }

    public void setForm(boolean form) {
        this.form = form;
    }

    public List<SrnTblRol> getListRol() {
        return listRol;
    }

    public void setListRol(List<SrnTblRol> listRol) {
        this.listRol = listRol;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
