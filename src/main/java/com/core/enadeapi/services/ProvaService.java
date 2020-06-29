package com.core.enadeapi.services;



import com.core.enadeapi.model.TbProva;
import com.core.enadeapi.model.TbQuestao;
import com.core.enadeapi.model.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProvaService {

    @Autowired
    public ProvaRepository repository;


    public TbProva findOne(Integer id ){

        return repository.getOne(id);

    }

    public ArrayList<TbProva> listar(){

        return (ArrayList<TbProva>) repository.findAll();

    }

    public void delete(Integer id){
        repository.delete(id);

    }

    public TbProva salvar(TbProva prova){
        return repository.save(prova);
    }

    public TbProva atualizar(TbProva prova){
        return repository.saveAndFlush(prova);
    }

}
