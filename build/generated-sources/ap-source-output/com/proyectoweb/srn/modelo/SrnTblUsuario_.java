package com.proyectoweb.srn.modelo;

import com.proyectoweb.srn.modelo.SrnTblEstado;
import com.proyectoweb.srn.modelo.SrnTblGenero;
import com.proyectoweb.srn.modelo.SrnTblMateriaUsuario;
import com.proyectoweb.srn.modelo.SrnTblRol;
import com.proyectoweb.srn.modelo.SrnTblTipoDocumento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-09-30T14:57:40")
@StaticMetamodel(SrnTblUsuario.class)
public class SrnTblUsuario_ { 

    public static volatile SingularAttribute<SrnTblUsuario, String> strLogin;
    public static volatile SingularAttribute<SrnTblUsuario, Long> numCodDocumento;
    public static volatile SingularAttribute<SrnTblUsuario, SrnTblGenero> strGenero;
    public static volatile SingularAttribute<SrnTblUsuario, Long> numIdUsuario;
    public static volatile SingularAttribute<SrnTblUsuario, String> strNombre;
    public static volatile SingularAttribute<SrnTblUsuario, SrnTblTipoDocumento> numTipoDocumento;
    public static volatile SingularAttribute<SrnTblUsuario, SrnTblRol> numCodRol;
    public static volatile SingularAttribute<SrnTblUsuario, SrnTblEstado> strEstado;
    public static volatile ListAttribute<SrnTblUsuario, SrnTblMateriaUsuario> srnTblMateriaUsuarioList;
    public static volatile SingularAttribute<SrnTblUsuario, String> strApellido;
    public static volatile SingularAttribute<SrnTblUsuario, String> strPassword;

}