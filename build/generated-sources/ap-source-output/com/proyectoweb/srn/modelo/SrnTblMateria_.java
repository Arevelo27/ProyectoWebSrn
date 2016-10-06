package com.proyectoweb.srn.modelo;

import com.proyectoweb.srn.modelo.SrnTblMateriaUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-30T14:57:40")
@StaticMetamodel(SrnTblMateria.class)
public class SrnTblMateria_ { 

    public static volatile SingularAttribute<SrnTblMateria, Long> numIdMateria;
    public static volatile SingularAttribute<SrnTblMateria, Long> numIntensidadHoraria;
    public static volatile ListAttribute<SrnTblMateria, SrnTblMateriaUsuario> srnTblMateriaUsuarioList;
    public static volatile SingularAttribute<SrnTblMateria, String> strNombreMateria;

}