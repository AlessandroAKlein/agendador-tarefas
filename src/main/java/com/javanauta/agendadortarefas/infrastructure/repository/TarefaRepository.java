package com.javanauta.agendadortarefas.infrastructure.repository;


import com.javanauta.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TarefaRepository extends MongoRepository<TarefaEntity, String> {

    List<TarefaEntity> findByDataAgendamentoBetween(LocalDateTime dataInicial, LocalDateTime dataFinal);
    List<TarefaEntity> findByemailUsuario(String emailUsuario);




}
