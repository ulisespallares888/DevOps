package com.TP1.API.task.service;


import com.TP1.API.task.dto.PageDTO;
import com.TP1.API.task.dto.TaskRequestDTO;
import com.TP1.API.task.dto.TaskResponseDTO;
import com.TP1.API.task.model.Task;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITaskService {
    PageDTO<TaskResponseDTO> findAll(Pageable pageable);
    TaskResponseDTO findById(Long id);
    TaskResponseDTO create(TaskRequestDTO userDTORequest)  ;
    void delete (Long id);
    TaskResponseDTO update(Long id, TaskRequestDTO userDTORequest);
    List<Task> findAllTasks();
}

