package com.proyectoweb.srn.modelo;

import com.proyectoweb.srn.modelo.SrnTblMateria;
import com.proyectoweb.srn.modelo.SrnTblNota;
import com.proyectoweb.srn.modelo.SrnTblUsuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-30T14:57:40")
@StaticMetamodel(SrnTblMateriaUsuario.class)
public class SrnTblMateriaUsuario_ { 

    public static volatile ListAttribute<SrnTblMateriaUsuario, SrnTblNota> srnTblNotaList;
    public static volatile SingularAttribute<SrnTblMateriaUsuario, Long> numIdMateriauser;
    public static volatile SingularAttribute<SrnTblMateriaUsuario, SrnTblMateria> numCodMateria;
    public static volatile SingularAttribute<SrnTblMateriaUsuario, SrnTblUsuario> numCodUsuario;

}