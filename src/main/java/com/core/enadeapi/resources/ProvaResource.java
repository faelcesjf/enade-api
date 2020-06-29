package com.core.enadeapi.resources;


import com.core.enadeapi.model.TbProva;
import com.core.enadeapi.model.dto.ProvaDTO;
import com.core.enadeapi.services.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/provas")
public class ProvaResource {

    @Autowired
    private ProvaService service;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TbProva> find(@PathVariable Integer id) {
        TbProva obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody TbProva obj) {

        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdProva()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody TbProva obj, @PathVariable Integer id) {
        obj.setIdProva(id);
        obj = service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<ProvaDTO>> findAll() {
        List<TbProva> list = service.listar();
        List<ProvaDTO> listDto = list.stream().map(obj -> new ProvaDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }



}
