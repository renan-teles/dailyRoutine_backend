package com.dailyroutine.dailyroutine.service.task;

import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import com.dailyroutine.dailyroutine.model.TaskModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private DailyRoutineRepository dailyRoutineRepository;

    public TaskDTO create(Integer dailyRoutineID, TaskDTO taskDTO){
        return new CreateTask(
                dailyRoutineID,
                taskDTO,
                this.taskRepository,
                this.dailyRoutineRepository
        ).execute();
    }

    public void delete(Integer taskID){
        new DeleteTask(taskID, this.taskRepository).execute();
    }

    public TaskDTO getById(Integer taskId){
        return new GetById(taskId, this.taskRepository).execute();
    }

    public List<TaskDTO> getAllOfDailyRoutineID(Integer dailyRoutineID) {
       return new GetAllOfDailyRoutineID(
               dailyRoutineID,
               this.taskRepository,
               this.dailyRoutineRepository
       ).execute();
    }

    public TaskDTO update(Integer taskID, TaskDTO newTaskDTO){
        return new UpdateTask(taskID, newTaskDTO,this.taskRepository).execute();
    }
}