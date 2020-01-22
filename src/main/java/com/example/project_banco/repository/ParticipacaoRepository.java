package com.example.project_banco.repository;

import com.example.project_banco.domain.entities.Participacao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ParticipacaoRepository extends JpaRepository<Participacao, Integer> {

    @Query(nativeQuery = true, value = "select distinct name from Participacao")
    List<String> listDistinct();
}