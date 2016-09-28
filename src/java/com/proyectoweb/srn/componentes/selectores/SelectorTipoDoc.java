/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.componentes.selectores;

import com.proyectoweb.srn.modelo.SrnTblTipoDocumento;
import com.proyectoweb.srn.persistencia.SrnTblTipoDocumentoFacade;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author TSI
 */
@ManagedBean
@RequestScoped
public class SelectorTipoDoc extends SelectorBase<SrnTblTipoDocumento, Integer> {

    @EJB
    private final SrnTblTipoDocumentoFacade tipoDocumentoFacade = new SrnTblTipoDocumentoFacade();

    @PostConstruct
    public void init() {
        cargarLista();
    }

    @Override
    public void cargarLista() {
        List<SrnTblTipoDocumento> listado = tipoDocumentoFacade.findAll();
        setLista(new ArrayList<SelectItem>());
        for (SrnTblTipoDocumento tipoDocumento : listado) {
            getLista().add(new SelectItem(tipoDocumento.getStrCodTipoDoc(), tipoDocumento.getStrDescripcion()));
        }
    }

}
