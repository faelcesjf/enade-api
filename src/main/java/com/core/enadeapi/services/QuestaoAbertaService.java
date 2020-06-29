package com.core.enadeapi.services;


import com.core.enadeapi.model.TbQuestao;
import com.core.enadeapi.model.TbTipoQuestao;
import com.core.enadeapi.model.dto.QuestaoAbertaDTO;
import com.core.enadeapi.model.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class QuestaoAbertaService{


    @Autowired
    public QuestaoRepository repository;


    public TbQuestao findOne(Integer id ){

        return repository.getOne(id);

    }

    public ArrayList<TbQuestao> listar(){

        return (ArrayList<TbQuestao>) repository.findAll();

    }

    public void anular(Integer id){
        TbQuestao questao =  repository.findOne(id);
        short estado = 0;
        questao.setEstadoQuestao(estado);
        repository.saveAndFlush(questao);
    }

    public TbQuestao salvar(TbQuestao questao){
        return repository.save(questao);
    }

    public TbQuestao atualizar(TbQuestao questao){
        return repository.saveAndFlush(questao);
    }



    public TbQuestao fromDTO(QuestaoAbertaDTO objDto) {
        TbQuestao questao =  new TbQuestao();
        TbTipoQuestao tipoQuestao =  new TbTipoQuestao();


        questao.setIdQuestao(objDto.getIdQuestao());
        questao.setEstadoQuestao(objDto.getEstadoQuestao());
        questao.setDescricaoQuestao(objDto.getDescricaoQuestao());
        tipoQuestao.setIdTipoQuestao(1);
        questao.setTbTipoQuestaoidTipoQuestao(tipoQuestao);

        return questao;
    }
}
