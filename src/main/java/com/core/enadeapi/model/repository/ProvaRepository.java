package com.core.enadeapi.model.repository;


import com.core.enadeapi.model.TbProva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvaRepository extends JpaRepository<TbProva, Integer> {




}
