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

/**
 *
 * @author tassi
 */
@Entity
@Table(name = "tbResultado")
@Data
public class TbResultado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idResultado")
    private Integer idResultado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valorObtido")
    private double valorObtido;
    @JoinColumn(name = "tbProva_idProva", referencedColumnName = "idProva")
    @ManyToOne(optional = false)
    private TbProva tbProvaidProva;
    @JoinColumn(name = "tbUsuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private TbUsuario tbUsuarioidUsuario;

    public TbResultado() {
    }

    public TbResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public TbResultado(Integer idResultado, double valorObtido) {
        this.idResultado = idResultado;
        this.valorObtido = valorObtido;
    }

    public Integer getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public double getValorObtido() {
        return valorObtido;
    }

    public void setValorObtido(double valorObtido) {
        this.valorObtido = valorObtido;
    }

    public TbProva getTbProvaidProva() {
        return tbProvaidProva;
    }

    public void setTbProvaidProva(TbProva tbProvaidProva) {
        this.tbProvaidProva = tbProvaidProva;
    }

    public TbUsuario getTbUsuarioidUsuario() {
        return tbUsuarioidUsuario;
    }

    public void setTbUsuarioidUsuario(TbUsuario tbUsuarioidUsuario) {
        this.tbUsuarioidUsuario = tbUsuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResultado != null ? idResultado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbResultado)) {
            return false;
        }
        TbResultado other = (TbResultado) object;
        if ((this.idResultado == null && other.idResultado != null) || (this.idResultado != null && !this.idResultado.equals(other.idResultado))) {
            return false;
        }
        return true;
    }


}
