package com.core.enadeapi.model.repository;

import com.core.enadeapi.model.TbTipoQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TipoQuestaoRepository extends JpaRepository<TbTipoQuestao, Integer> {

}