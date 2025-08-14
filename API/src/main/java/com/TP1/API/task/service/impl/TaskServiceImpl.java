package com.TP1.API.task.service.impl;

import com.TP1.API.task.dto.PageDTO;
import com.TP1.API.task.dto.TaskRequestDTO;
import com.TP1.API.task.dto.TaskResponseDTO;
import com.TP1.API.task.model.Task;
import com.TP1.API.task.repository.TaskRepository;
import com.TP1.API.task.service.ITaskService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Data
@Service
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    @Override
    public PageDTO<Task> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Task findById(Long id) {
        return null;
    }

    @Override
    public Task create(TaskRequestDTO userDTORequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TaskResponseDTO update(Long id, TaskRequestDTO userDTORequest) {
        return null;
    }

    @Override
    public List<Task> findAllTasks() {
        return List.of();
    }
}
