/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.enadeapi.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author tassi
 */
@Entity
@Table(name = "tbTipoUsuario")
@Data
public class TbTipoUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "idTipoUsuario")
    private Integer idTipoUsuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nomeTipoUsuario")
    private String nomeTipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbTipoUsuarioidTipoUsuario")
    private List<TbUsuario> tbUsuarioList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoUsuario != null ? idTipoUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipoUsuario)) {
            return false;
        }
        TbTipoUsuario other = (TbTipoUsuario) object;
        if ((this.idTipoUsuario == null && other.idTipoUsuario != null) || (this.idTipoUsuario != null && !this.idTipoUsuario.equals(other.idTipoUsuario))) {
            return false;
        }
        return true;
    }


    
}
