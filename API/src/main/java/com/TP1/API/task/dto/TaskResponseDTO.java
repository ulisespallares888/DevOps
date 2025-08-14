package com.TP1.API.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResponseDTO {
    private String title;
    private String description;
    private boolean completed;
}