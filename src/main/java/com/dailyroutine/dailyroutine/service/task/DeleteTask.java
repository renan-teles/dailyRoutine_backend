package com.dailyroutine.dailyroutine.service.task;

import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.repository.TaskRepository;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

public class DeleteTask implements ServiceInterface<Void> {
    private final Integer taskID;
    private final TaskRepository taskRepository;

    public DeleteTask(Integer taskID, TaskRepository taskRepository){
            this.taskID = taskID;
            this.taskRepository = taskRepository;
    }

    @Override
    public Void execute() {
        ID.validate(this.taskID, false);

        if(!this.taskRepository.existsById(taskID)){
            throw new ResourceNotFoundException("Não foi possível deletar. Tarefa não encontrada.");
        }

        this.taskRepository.deleteById(taskID);
        return null;
    }
}
