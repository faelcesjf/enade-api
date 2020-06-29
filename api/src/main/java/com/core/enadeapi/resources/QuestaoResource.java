package com.core.enadeapi.resources;


import com.core.enadeapi.model.TbQuestao;
import com.core.enadeapi.services.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping(value="/api/questoes")
public class QuestaoResource {

    @Autowired
    private QuestaoService service;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TbQuestao> find(@PathVariable Integer id) {
        TbQuestao obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/anular/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> anular(@PathVariable Integer id) {

        service.anular(id);
        return ResponseEntity.noContent().build();
    }



    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<ArrayList<TbQuestao>> findAll() {
        ArrayList<TbQuestao> list = service.listar();
        return ResponseEntity.ok().body(list);
    }



}
