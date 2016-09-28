/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoweb.srn.control;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Andres-Desarrollo2
 */
public interface GenericBean<T> {

    void verForm();

    void volverForm();

    void renderizarItem(T entity);

    void eliminarItem(T entity);

    String aceptar();

    boolean preAction();
}
