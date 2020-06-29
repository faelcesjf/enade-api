package com.core.enadeapi.services;


import com.core.enadeapi.model.TbUsuario;
import com.core.enadeapi.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;



@Service
public class UsuarioService {

    @Autowired
    public UsuarioRepository repository;


    public TbUsuario findOne(Integer id ){

        return repository.findOne(id);

    }

    public ArrayList<TbUsuario> listar(){

        return (ArrayList<TbUsuario>) repository.findAll();

    }

    public void deletar(Integer id){
        repository.delete(id);
    }

    public TbUsuario salvar(TbUsuario usuario){
        return repository.save(usuario);
    }

    public TbUsuario atualizar(TbUsuario usuario){
        return repository.saveAndFlush(usuario);
    }


    public ArrayList<TbUsuario> findAlunosPendente(Integer prova){
        return repository.findAlunosPendente(prova);
    }

    public TbUsuario isLogin(String email, String senha){
         return repository.isLogin(email,senha).get(0);
    }

    public ArrayList<TbUsuario> findAlunosResultado(Integer idprova){
        return repository.findAlunosResultado(idprova);
    }

}
