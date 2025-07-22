package com.dailyroutine.dailyroutine.service.task;

import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.domain.task.TaskTime;
import com.dailyroutine.dailyroutine.domain.task.Time;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import com.dailyroutine.dailyroutine.model.TaskModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.repository.TaskRepository;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

public class CreateTask implements ServiceInterface<TaskDTO> {
    private final Integer dailyRoutineID;
    private final TaskDTO taskDTO;
    private final TaskRepository taskRepository;
    private final DailyRoutineRepository dailyRoutineRepository;

    public CreateTask(
            Integer dailyRoutineID,
            TaskDTO taskDTO,
            TaskRepository taskRepository,
            DailyRoutineRepository dailyRoutineRepository
    ) {
        this.dailyRoutineID = dailyRoutineID;
        this.taskDTO = taskDTO;
        this.taskRepository = taskRepository;
        this.dailyRoutineRepository = dailyRoutineRepository;
    }

    @Override
    public TaskDTO execute() {
        ID.validate(this.dailyRoutineID, false);

        Time startTime = new Time(this.taskDTO.getStartHour(), this.taskDTO.getStartMinute());
        Time endTime = new Time(this.taskDTO.getEndHour(), this.taskDTO.getEndMinute());

        TaskTime taskTime = new TaskTime(startTime, endTime);

        DailyRoutineModel dailyRoutine = this.dailyRoutineRepository.findById(this.dailyRoutineID)
                .orElseThrow(() -> new ResourceNotFoundException("Rotina não encontrada para associar a tarefa."));

        TaskModel taskModel = new TaskModel();
        taskModel.setName(this.taskDTO.getName());
        taskModel.setDescription(this.taskDTO.getDescription());
        taskModel.setStartHour(taskTime.getStartHour());
        taskModel.setStartMinute(taskTime.getStartMinute());
        taskModel.setEndHour(taskTime.getEndHour());
        taskModel.setEndMinute(taskTime.getEndMinute());
        taskModel.setDailyRoutine(dailyRoutine);

        Integer taskID = this.taskRepository.save(taskModel).getId();

        this.taskDTO.setId(taskID);
        return taskDTO;
    }
}
