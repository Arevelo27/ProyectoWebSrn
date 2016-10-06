package com.proyectoweb.srn.modelo;

import com.proyectoweb.srn.modelo.SrnTblMenuPermisos;
import com.proyectoweb.srn.modelo.SrnTblPermisos;
import com.proyectoweb.srn.modelo.SrnTblUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-30T14:57:40")
@StaticMetamodel(SrnTblRol.class)
public class SrnTblRol_ { 

    public static volatile SingularAttribute<SrnTblRol, Integer> numIdRol;
    public static volatile ListAttribute<SrnTblRol, SrnTblUsuario> srnTblUsuarioList;
    public static volatile ListAttribute<SrnTblRol, SrnTblPermisos> srnTblPermisosList;
    public static volatile SingularAttribute<SrnTblRol, String> strDescripcion;
    public static volatile ListAttribute<SrnTblRol, SrnTblMenuPermisos> srnTblMenuPermisosList;

}