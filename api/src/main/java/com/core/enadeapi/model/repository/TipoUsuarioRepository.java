package com.core.enadeapi.model.repository;

import com.core.enadeapi.model.TbTipoUsuario;
import com.core.enadeapi.model.TbUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TipoUsuarioRepository extends JpaRepository<TbTipoUsuario, Integer> {



}
