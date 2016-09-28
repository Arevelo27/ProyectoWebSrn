/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.componentes.selectores;

import com.proyectoweb.srn.modelo.SrnTblEstado;
import com.proyectoweb.srn.persistencia.SrnTblEstadoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Andres-Desarrollo2
 */
@ManagedBean
@RequestScoped
public class SelectorEstado extends SelectorBase<SrnTblEstado, Integer> {

    @EJB
    private final SrnTblEstadoFacade estadoFacade = new SrnTblEstadoFacade();

    @PostConstruct
    public void init() {
        cargarLista();
    }

    @Override
    public void cargarLista() {
        List<SrnTblEstado> listado = estadoFacade.findAll();
        setLista(new ArrayList<SelectItem>());
        for (SrnTblEstado estado : listado) {
            getLista().add(new SelectItem(estado.getStrCodEstado(), estado.getStrDescripcion()));
        }
    }

}
