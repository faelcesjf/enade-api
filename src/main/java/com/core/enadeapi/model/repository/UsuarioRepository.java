package com.core.enadeapi.model.repository;


import com.core.enadeapi.model.TbUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface UsuarioRepository extends JpaRepository<TbUsuario, Integer> {

    @Query("SELECT u FROM TbUsuario u " +
            "where u.idUsuario NOT IN (SELECT r.tbUsuarioidUsuario.idUsuario FROM TbResultado r where r.tbProvaidProva.idProva =:idProva) " +
            "and u.tbTipoUsuarioidTipoUsuario.idTipoUsuario = 2 ")
    public ArrayList<TbUsuario> findAlunosPendente(@Param("idProva") Integer idProva);


    @Query("SELECT u FROM TbUsuario u " +
            "where u.idUsuario IN (SELECT r.tbUsuarioidUsuario.idUsuario FROM TbResultado r where r.tbProvaidProva.idProva =:idProva) " +
            "and u.tbTipoUsuarioidTipoUsuario.idTipoUsuario = 2 ")
    public ArrayList<TbUsuario> findAlunosResultado(@Param("idProva") Integer idProva);

    @Query("SELECT u FROM TbUsuario u " +
            "where u.emailUsuario =:email and u.senhaUsuario =:senha")
    public ArrayList<TbUsuario> isLogin(@Param("email") String email, @Param("senha") String senha);
}
