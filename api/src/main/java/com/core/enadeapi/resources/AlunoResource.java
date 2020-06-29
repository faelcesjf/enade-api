package com.core.enadeapi.resources;


import com.core.enadeapi.model.TbTipoUsuario;
import com.core.enadeapi.model.TbUsuario;
import com.core.enadeapi.model.dto.AlunoDTO;
import com.core.enadeapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value="/api/alunos")
public class AlunoResource {

    @Autowired
    private UsuarioService service;


    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<TbUsuario> find(@PathVariable Integer id) {
        TbUsuario obj = service.findOne(id);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody TbUsuario obj) {
        TbTipoUsuario tipoUsuario = new TbTipoUsuario();
        tipoUsuario.setIdTipoUsuario(2);
        obj.setTbTipoUsuarioidTipoUsuario(tipoUsuario);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody TbUsuario obj, @PathVariable Long id) {

        TbTipoUsuario tipoUsuario = new TbTipoUsuario();
        tipoUsuario.setIdTipoUsuario(2);
        obj.setIdUsuario(id);
        service.atualizar(obj);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<TbUsuario>> findAll() {
        List<TbUsuario> list = service.listar();
        return ResponseEntity.ok().body(list);
    }
    @RequestMapping(value="/relatorios/pendentes/{idProva}", method=RequestMethod.GET)
    public ResponseEntity<List<AlunoDTO>> findAlunosPendente(@PathVariable Integer idProva) {
        ArrayList<TbUsuario> list = service.findAlunosPendente(idProva);
        List<AlunoDTO> listDto = list.stream().map(obj -> new AlunoDTO(obj)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/relatorios/resultados/{idProva}", method=RequestMethod.GET)
    public ResponseEntity<List<AlunoDTO>> findAlunosResultado(@PathVariable Integer idProva) {
        ArrayList<TbUsuario> list = service.findAlunosResultado(idProva);
        List<AlunoDTO> listDto = list.stream().map(obj -> new AlunoDTO(obj,idProva)).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);
    }





}
