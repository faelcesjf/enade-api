package com.core.enadeapi.model.repository;


import com.core.enadeapi.model.TbQuestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestaoRepository extends JpaRepository<TbQuestao, Integer> {

}
