package com.example.project_banco.repository;

import com.example.project_banco.domain.entities.StatusEvento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StatusEventoRepository extends JpaRepository<StatusEvento, Integer> {

    @Query(nativeQuery = true, value = "select distinct name from StatusEvento")
    List<String> listDistinct();
}