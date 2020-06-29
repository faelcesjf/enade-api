package com.core.enadeapi.model.dto;



import com.core.enadeapi.model.TbProva;
import com.core.enadeapi.model.TbQuestao;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ProvaDTO {


    private Integer idProva;

    private Date dataProva;


    private List<QuestaoDTO> questoes;

    public ProvaDTO(TbProva obj){

        this.idProva = obj.getIdProva();

        this.dataProva = obj.getDataProva();

        this.questoes = getQuestoesDTO(obj.getTbQuestaoList());
    }

    public List<QuestaoDTO> getQuestoesDTO(List<TbQuestao> questoes){
        List<QuestaoDTO> dtos = new ArrayList<QuestaoDTO>();
        for (TbQuestao questao: questoes) {
            QuestaoDTO dto = new QuestaoDTO(questao);
            dtos.add(dto);

        }
        return dtos;

    }

}
