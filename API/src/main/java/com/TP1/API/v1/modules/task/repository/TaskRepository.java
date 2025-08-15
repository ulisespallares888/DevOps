package com.TP1.API.v1.modules.task.repository;

import com.TP1.API.v1.modules.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
