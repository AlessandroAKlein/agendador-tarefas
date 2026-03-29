package com.javanauta.agendadortarefas.business.mapper;


import com.javanauta.agendadortarefas.business.dto.TarefaDTO;
import com.javanauta.agendadortarefas.infrastructure.entity.TarefaEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaConverter {

    TarefaEntity paraTarefaEntity(TarefaDTO tarefaDTO);
    TarefaDTO paraTarefaDTO(TarefaEntity tarefasEntity);
    List<TarefaEntity> paraListaTarefasEntity(List<TarefaDTO> dtos);
    List<TarefaDTO> paraListaTarefasDTO(List<TarefaEntity> entity);


}
