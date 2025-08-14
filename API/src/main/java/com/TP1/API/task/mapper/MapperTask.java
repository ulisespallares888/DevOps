package com.TP1.API.task.mapper;

import com.TP1.API.task.dto.TaskRequestDTO;
import com.TP1.API.task.dto.TaskResponseDTO;
import com.TP1.API.task.model.Task;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface MapperTask {
    MapperTask INSTANCIA = Mappers.getMapper(MapperTask.class);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "status", source = "status")
    Task TaskRequestDTOToTask(TaskRequestDTO taskRequestDTO);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "status", source = "status")
    TaskResponseDTO taskToTaskResponseDTO(Task task);

}
