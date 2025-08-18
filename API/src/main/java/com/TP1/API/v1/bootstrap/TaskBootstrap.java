package com.TP1.API.v1.bootstrap;

import com.TP1.API.v1.modules.task.model.Task;
import com.TP1.API.v1.modules.task.repository.TaskRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class TaskBootstrap  implements CommandLineRunner {

    private final TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Running TaskBootstrap");

        loadData();

        log.info("TaskBootstrap completed successfully.");
    }

    public void loadData() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:data/tasks_data.csv");

        List<TaskRecordDTO> taskRecordDTOS = convertCSV(file);

        if (taskRepository.count() < 20) {
            log.info("Loading database with tasks");
           for (TaskRecordDTO taskRecordDTO : taskRecordDTOS) {
                taskRepository.save(
                        Task.builder()
                                .title(taskRecordDTO.getTitle())
                                .description(taskRecordDTO.getDescription())
                                .completed(taskRecordDTO.isCompleted())
                                .build()
                );
                log.info("Task with title '{}' has been saved to the repository.", taskRecordDTO.getTitle());
            }
            log.info("Task repository has been populated with initial data.");
        } else {
            log.info("Task repository already contains sufficient data.");
        }

    }

    public List<TaskRecordDTO> convertCSV(File file) throws FileNotFoundException {
        List<TaskRecordDTO> taskRecordDTOS =
                new CsvToBeanBuilder<TaskRecordDTO>(new FileReader(file))
                        .withType(TaskRecordDTO.class)
                        .build()
                        .parse();
        log.info("Turning CSV file to developers list");
        return taskRecordDTOS;
    }

}
