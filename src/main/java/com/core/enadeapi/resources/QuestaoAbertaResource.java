package com.core.enadeapi.resources;


import com.core.enadeapi.model.TbQuestao;
import com.core.enadeapi.model.dto.QuestaoAbertaDTO;
import com.core.enadeapi.services.QuestaoAbertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/questoes/abertas")
public class QuestaoAbertaResource {

    @Autowired
    private QuestaoAbertaService questaoAbertaService;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TbQuestao> find(@PathVariable Integer id) {
        TbQuestao obj = questaoAbertaService.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody QuestaoAbertaDTO objDto) {
        TbQuestao obj = questaoAbertaService.fromDTO(objDto);
        obj = questaoAbertaService.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdQuestao()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody QuestaoAbertaDTO objDto, @PathVariable Integer id) {
        TbQuestao obj = questaoAbertaService.fromDTO(objDto);
        obj.setIdQuestao(id);
        questaoAbertaService.atualizar(obj);
        return ResponseEntity.noContent().build();
    }


    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<QuestaoAbertaDTO>> findAll() {
        List<TbQuestao> list = questaoAbertaService.listar();
        List<QuestaoAbertaDTO> listDto = list.stream().map(obj -> new QuestaoAbertaDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }


}