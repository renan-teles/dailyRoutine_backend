package com.dailyroutine.dailyroutine.service.task;

import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.domain.task.TaskTime;
import com.dailyroutine.dailyroutine.domain.task.Time;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.model.TaskModel;
import com.dailyroutine.dailyroutine.repository.TaskRepository;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

public class UpdateTask implements ServiceInterface<TaskDTO> {
    private final Integer taskID;
    private final TaskDTO newTaskDTO;
    private final TaskRepository taskRepository;

    public UpdateTask(
            Integer taskID,
            TaskDTO newTaskDTO,
            TaskRepository taskRepository
    ){
        this.taskID = taskID;
        this.newTaskDTO = newTaskDTO;
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTO execute() {
        ID.validate(this.taskID, false);

        Time startTime = new Time(this.newTaskDTO.getStartHour(), this.newTaskDTO.getStartMinute());
        Time endTime = new Time(this.newTaskDTO.getEndHour(), this.newTaskDTO.getEndMinute());

        TaskTime taskTime = new TaskTime(startTime, endTime);

        TaskModel tm = this.taskRepository.findById(taskID)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível editar. Tarefa não encontrada."));
        tm.setName(this.newTaskDTO.getName());
        tm.setDescription(this.newTaskDTO.getDescription());
        tm.setStartHour(taskTime.getStartHour());
        tm.setStartMinute(taskTime.getStartMinute());
        tm.setEndHour(taskTime.getEndHour());
        tm.setEndMinute(taskTime.getEndMinute());

        Integer taskID = this.taskRepository.save(tm).getId();

        this.newTaskDTO.setId(taskID);
        return this.newTaskDTO;
    }
}
