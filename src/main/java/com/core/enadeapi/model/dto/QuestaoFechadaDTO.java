package com.core.enadeapi.model.dto;

import com.core.enadeapi.model.TbQuestao;
import lombok.Data;

;


@Data
public class QuestaoFechadaDTO {

    private Integer idQuestao;
    private String descricaoQuestao;
    private String alternativaA;
    private String alternativaB;
    private String alternativaC;
    private String alternativaD;
    private String alternativaE;
    private Character questaoCorreta;
    private short estadoQuestao;

    private final int idTipoQuestao = 2;


    public QuestaoFechadaDTO(){

    }

    public QuestaoFechadaDTO(TbQuestao obj){

        this.idQuestao = obj.getIdQuestao();
        this.descricaoQuestao =  obj.getDescricaoQuestao();
        this.alternativaA = obj.getAlternativaA();
        this.alternativaB = obj.getAlternativaB();
        this.alternativaC = obj.getAlternativaC();
        this.alternativaD = obj.getAlternativaD();
        this.alternativaE = obj.getAlternativaE();
        this.questaoCorreta = obj.getQuestaoCorreta();
        this.estadoQuestao = obj.getEstadoQuestao();

    }

}
