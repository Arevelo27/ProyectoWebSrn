/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.control;

import com.proyectoweb.srn.modelo.SrnTblRol;
import com.proyectoweb.srn.persistencia.SrnTblRolFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author TSI
 */
@ManagedBean(name = "rolBn")
@ViewScoped
public class RolControllerMB implements GenericBean<SrnTblRol>, Serializable {

    private SrnTblRol rol;

    @EJB
    private SrnTblRolFacade rolFacade;
    private boolean edit = false;
    private boolean form = false;
    
    private List<SrnTblRol> listRol = new ArrayList<SrnTblRol>();

    @PostConstruct
    public void init() {
        listRol = rolFacade.findAll();
    }

    @Override
    public void verForm() {
        rol = new SrnTblRol();
        form = true;
        edit = false;
    }

    @Override
    public void volverForm() {
        form = false;
        edit = false;
    }

    /**
     *
     * @param r
     */
    @Override
    public void renderizarItem(SrnTblRol r) {
        rol = r;
//        selMedida = p.getMedida();
        form = true;
        edit = true;
    }

    @Override
    public void eliminarItem(SrnTblRol r) {
        try {
            rolFacade.remove(r);
            listRol = rolFacade.findAll();
        } catch (Exception e) {
        }
    }

    @Override
    public String aceptar() {
        String navegacion = "";
        try {
            if (preAction()) {
                if (!edit) {
//                    if (personaDaoImpl.findById(productos.getId()) != null) {
//                        productos.setId(personaDaoImpl.getCountOfAll());
//                        productos.setMedida(selMedida);
//                        personaDaoImpl.create(productos);
//                        navegacion = REGLA_NAVEGACION;
//                    }
//                    }
                } else {
//                    personaDaoImpl.update(productos);
//                    navegacion = REGLA_NAVEGACION;
                }
            }
        } catch (Exception e) {
        }
        return navegacion;
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

}
