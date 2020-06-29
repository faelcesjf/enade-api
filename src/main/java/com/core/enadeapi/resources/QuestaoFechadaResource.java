package com.core.enadeapi.resources;


import com.core.enadeapi.model.TbQuestao;
import com.core.enadeapi.model.dto.QuestaoFechadaDTO;
import com.core.enadeapi.services.QuestaoFechadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/questoes/fechadas")
public class QuestaoFechadaResource {

    @Autowired
    private QuestaoFechadaService service;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TbQuestao> find(@PathVariable Integer id) {
        TbQuestao obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody QuestaoFechadaDTO objDto) {
        TbQuestao obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdQuestao()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody QuestaoFechadaDTO objDto, @PathVariable Integer id) {
        TbQuestao obj = service.fromDTO(objDto);
        obj.setIdQuestao(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<QuestaoFechadaDTO>> findAll() {
        List<TbQuestao> list = service.listar();
        List<QuestaoFechadaDTO> listDto = list.stream().map(obj -> new QuestaoFechadaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


}