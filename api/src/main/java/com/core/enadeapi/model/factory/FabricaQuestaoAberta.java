package com.core.enadeapi.model.factory;

import com.core.enadeapi.model.TbQuestao;

public class FabricaQuestaoAberta implements FabricaQuestao {

    @Override
    public TbQuestao criarQuestao(){
        return new QuestaoAberta();

    }


}
