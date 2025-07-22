package com.dailyroutine.dailyroutine.service.task;

import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.model.TaskModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.repository.TaskRepository;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetAllOfDailyRoutineID implements ServiceInterface<List<TaskDTO>> {
    private final Integer dailyRoutineID;
    private final TaskRepository taskRepository;
    private final DailyRoutineRepository dailyRoutineRepository;

    public GetAllOfDailyRoutineID(
            Integer dailyRoutineID,
            TaskRepository taskRepository,
            DailyRoutineRepository dailyRoutineRepository
    ) {
        this.dailyRoutineID = dailyRoutineID;
        this.taskRepository = taskRepository;
        this.dailyRoutineRepository = dailyRoutineRepository;
    }

    @Override
    public List<TaskDTO> execute() {
        ID.validate(this.dailyRoutineID, false);

        if(!dailyRoutineRepository.existsById(this.dailyRoutineID)){
            throw new ResourceNotFoundException("Não foi possível buscar as tarefas. Rotina não encontrada.");
        }

        List<TaskModel> listTaskModel = this.taskRepository.findByDailyRoutineId(this.dailyRoutineID);
        if(listTaskModel.isEmpty()){
            return Collections.emptyList();
        }

        return listTaskModel.stream().map(TaskDTO::new).toList();
    }
}
