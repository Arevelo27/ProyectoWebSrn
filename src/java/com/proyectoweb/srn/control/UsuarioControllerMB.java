/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.control;

import com.proyectoweb.srn.modelo.SrnTblUsuario;
import com.proyectoweb.srn.persistencia.SrnTblUsuarioFacade;
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
@ManagedBean(name = "usuarioBn")
@ViewScoped
public class UsuarioControllerMB implements GenericBean<SrnTblUsuario>, Serializable {

    private SrnTblUsuario user;

    @EJB
    private SrnTblUsuarioFacade userFacade;
    private boolean edit = false;
    private boolean form = false;

    private List<SrnTblUsuario> listUser = new ArrayList<SrnTblUsuario>();

    @PostConstruct
    public void init() {
        listUser = userFacade.findAll();
    }

    @Override
    public void verForm() {
        user = new SrnTblUsuario();
        form = true;
        edit = false;
    }

    @Override
    public void volverForm() {
        form = false;
        edit = false;
    }

    @Override
    public void renderizarItem(SrnTblUsuario u) {
        user = u;
//        selMedida = p.getMedida();
        form = true;
        edit = true;
    }

    @Override
    public void eliminarItem(SrnTblUsuario u) {
        try {
            userFacade.remove(u);
            listUser = userFacade.findAll();
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
//        RequestContext.getCurrentInstance().update("growl");
        return accion;
    }

    public SrnTblUsuario getUser() {
        return user;
    }

    public void setUser(SrnTblUsuario user) {
        this.user = user;
    }

    public boolean isEdit() {
        return edit;
    }

    public void setEdit(boolean edit) {
        this.edit = edit;
    }

    public boolean isForm() {
        return form;
    }

    public void setForm(boolean form) {
        this.form = form;
    }

    public List<SrnTblUsuario> getListUser() {
        return listUser;
    }

    public void setListUser(List<SrnTblUsuario> listUser) {
        this.listUser = listUser;
    }

}
