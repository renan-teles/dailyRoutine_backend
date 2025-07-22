package com.dailyroutine.dailyroutine.service.task;

import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.model.TaskModel;
import com.dailyroutine.dailyroutine.repository.TaskRepository;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

import java.util.Optional;

public class GetById implements ServiceInterface<TaskDTO> {
    private final Integer taskID;
    private final TaskRepository taskRepository;

    public GetById(Integer taskID, TaskRepository taskRepository) {
        this.taskID = taskID;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTO execute() {
        ID.validate(this.taskID ,false);

        TaskModel tm = this.taskRepository.findById(this.taskID)
                .orElseThrow(() -> new ResourceNotFoundException("Tarefa não encontrada!"));

        return new TaskDTO(tm);
    }
}
