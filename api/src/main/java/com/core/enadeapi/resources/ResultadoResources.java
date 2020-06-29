package com.core.enadeapi.resources;


import com.core.enadeapi.model.TbQuestao;
import com.core.enadeapi.model.TbResultado;
import com.core.enadeapi.model.dto.QuestaoAbertaDTO;
import com.core.enadeapi.model.dto.RespostaDTO;
import com.core.enadeapi.services.QuestaoService;
import com.core.enadeapi.services.ResultadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import javax.validation.Valid;
import java.net.URI;


@RestController
@RequestMapping(value="/api/resultado")
public class ResultadoResources {

    @Autowired
    private ResultadoService service;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody List<RespostaDTO> objDto) {
        TbResultado obj = service.fromDTO(objDto);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdResultado()).toUri();
        return ResponseEntity.created(uri).build();
    }



}
