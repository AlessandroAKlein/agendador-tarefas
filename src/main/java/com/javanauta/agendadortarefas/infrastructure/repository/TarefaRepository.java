package com.javanauta.agendadortarefas.infrastructure.repository;


import com.javanauta.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends MongoRepository<TarefaEntity, String> {
}
