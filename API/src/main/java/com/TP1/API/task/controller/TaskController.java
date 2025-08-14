package com.TP1.API.task.controller;

import com.TP1.API.task.dto.PageDTO;
import com.TP1.API.task.dto.TaskResponseDTO;
import com.TP1.API.task.service.ITaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final ITaskService taskService;
    private final PagedResourcesAssembler<TaskResponseDTO> pagedResourcesAssembler;

    private PagedModel<EntityModel<TaskResponseDTO>> toPagedModel(Page<TaskResponseDTO> taskResponseDTOPage) {
        return pagedResourcesAssembler.toModel(taskResponseDTOPage, taskResponseDTO -> {
            EntityModel<TaskResponseDTO> taskResponseDTOEntityModelEntityModel = EntityModel.of(taskResponseDTO);
            taskResponseDTOEntityModelEntityModel.add(
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(TaskController.class)
                            .findById(taskResponseDTO.getId())).withSelfRel());
            return taskResponseDTOEntityModelEntityModel;
        });
    }
    @GetMapping("")
    public ResponseEntity<PagedModel<EntityModel<TaskResponseDTO>>> getAllTasks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sortOrder = direction.equalsIgnoreCase("desc")
                ? Sort.by(sort).descending()
                : Sort.by(sort).ascending();

        Pageable pageable = PageRequest.of(page, size, sortOrder);

        PageDTO<TaskResponseDTO> pageDTO = taskService.findAll(pageable);

        Page<TaskResponseDTO> taskResponseDTOPage = new PageImpl<>(
                pageDTO.getContent(),
                PageRequest.of(pageDTO.getPage(), pageDTO.getSize(), sortOrder),
                pageDTO.getTotalElements()
        );

        if (taskResponseDTOPage.isEmpty()) {
            return ResponseEntity.ok(PagedModel.empty());
        }

        return ResponseEntity.ok(toPagedModel(taskResponseDTOPage));
    }


    @GetMapping(value = "{id}")
    public TaskResponseDTO findById(@Valid @PathVariable Long id) {
        return taskService.findById(id);
    }

}
