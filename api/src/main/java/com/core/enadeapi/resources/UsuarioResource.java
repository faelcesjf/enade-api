package com.core.enadeapi.resources;


import com.core.enadeapi.model.TbTipoUsuario;
import com.core.enadeapi.model.TbUsuario;
import com.core.enadeapi.model.dto.UsuarioDTO;
import com.core.enadeapi.model.parameter.LoginParameter;
import com.core.enadeapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value="/api/usuarios")
public class UsuarioResource {
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
        tipoUsuario.setIdTipoUsuario(new Integer(1));
        obj.setTbTipoUsuarioidTipoUsuario(tipoUsuario);
        obj = service.salvar(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdUsuario()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody TbUsuario obj, @PathVariable Long id) {
        obj.setIdUsuario(id);
        obj = service.atualizar(obj);
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

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public ResponseEntity<UsuarioDTO> logar(@Valid @RequestBody LoginParameter obj) {

        UsuarioDTO dto = new UsuarioDTO(service.isLogin(obj.getEmail(),obj.getSenha()));

        return ResponseEntity.ok().body(dto);
    }

}
