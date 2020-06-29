package com.core.enadeapi.model.dto;



import com.core.enadeapi.model.TbQuestao;
import lombok.Data;


@Data
public class QuestaoAbertaDTO {

    private Integer idQuestao;
    private String descricaoQuestao;
    private short estadoQuestao;

    private final int idTipoQuestao = 1;

    public QuestaoAbertaDTO() {
    }

    public QuestaoAbertaDTO(TbQuestao obj) {
        this.idQuestao = obj.getIdQuestao();
        this.descricaoQuestao =  obj.getDescricaoQuestao();
        this.estadoQuestao = obj.getEstadoQuestao();

    }

    public int getTipoQuestao(){
        return this.idTipoQuestao;
    }
}
