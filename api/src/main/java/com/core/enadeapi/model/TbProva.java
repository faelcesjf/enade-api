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
import java.util.Date;
import java.util.List;

/**
 *
 * @author tassi
 */
@Entity
@Table(name = "tbProva")
@Data
public class TbProva implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProva")
    private Integer idProva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataProva")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataProva;
    @JoinTable(name = "tbProva_has_tbQuestao", joinColumns = {
        @JoinColumn(name = "tbProva_idProva", referencedColumnName = "idProva")}, inverseJoinColumns = {
        @JoinColumn(name = "tbQuestao_idQuestao", referencedColumnName = "idQuestao")})
    @ManyToMany
    private List<TbQuestao> tbQuestaoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tbProvaidProva")
    private List<TbResultado> tbResultadoList;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProva != null ? idProva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProva)) {
            return false;
        }
        TbProva other = (TbProva) object;
        if ((this.idProva == null && other.idProva != null) || (this.idProva != null && !this.idProva.equals(other.idProva))) {
            return false;
        }
        return true;
    }


}
