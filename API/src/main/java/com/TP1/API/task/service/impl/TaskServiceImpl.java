package com.TP1.API.task.service.impl;

import com.TP1.API.exceptions.exceptions.ResourceNotFoundException;
import com.TP1.API.task.dto.PageDTO;
import com.TP1.API.task.dto.TaskRequestDTO;
import com.TP1.API.task.dto.TaskResponseDTO;
import com.TP1.API.task.mapper.MapperTask;
import com.TP1.API.task.model.Task;
import com.TP1.API.task.repository.TaskRepository;
import com.TP1.API.task.service.ITaskService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements ITaskService {

    private final TaskRepository taskRepository;

    //@Cacheable(value = "tasks", key = "#pageable.pageNumber + '-' + #pageable.pageSize + '-' + #pageable.sort.toString()")
    public PageDTO<TaskResponseDTO> findAll(Pageable pageable) {
        List<Task> tasks = findAllTasks();
        int start = (int) pageable.getOffset();
        int end = Math.min(start + pageable.getPageSize(), tasks.size());
        List<Task> pageContent = new ArrayList<>(tasks.subList(start, end));

        List<TaskResponseDTO> dtoContent = pageContent.stream()
                .map(MapperTask.INSTANCIA::taskToTaskResponseDTO)
                .toList();
        return new PageDTO<>(dtoContent, pageable.getPageNumber(), pageable.getPageSize(), tasks.size());

    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll();

    }

    @Override
    public TaskResponseDTO findById(Long id) {
        TaskResponseDTO taskResponseDTO = taskRepository.findById(id)
                .map(MapperTask.INSTANCIA::taskToTaskResponseDTO)
                .orElseThrow(() -> new ResourceNotFoundException("Task no found with ID = %s".formatted(id)));
        return taskResponseDTO;
    }

    @Override
    public TaskResponseDTO create(TaskRequestDTO userDTORequest) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TaskResponseDTO update(Long id, TaskRequestDTO userDTORequest) {
        return null;
    }


}
