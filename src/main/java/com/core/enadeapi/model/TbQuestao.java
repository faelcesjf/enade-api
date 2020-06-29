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
@Table(name = "tbQuestao")
@Data
public class TbQuestao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idQuestao")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer idQuestao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;
    @Column(name = "alternativaA")
    private String alternativaA;
    @Column(name = "alternativaB")
    private String alternativaB;
    @Column(name = "alternativaC")
    private String alternativaC;
    @Column(name = "alternativaD")
    private String alternativaD;
    @Column(name = "alternativaE")
    private String alternativaE;
    @Column(name = "questaoCorreta")
    private Character questaoCorreta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estadoQuestao")
    private short estadoQuestao;
    @ManyToMany(mappedBy = "tbQuestaoList")
    private List<TbProva> tbProvaList;
    @JoinColumn(name = "tbTipoQuestao_idTipoQuestao", referencedColumnName = "idTipoQuestao")
    @ManyToOne(optional = false)
    private TbTipoQuestao tbTipoQuestaoidTipoQuestao;


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbQuestao)) {
            return false;
        }
        TbQuestao other = (TbQuestao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }


}
