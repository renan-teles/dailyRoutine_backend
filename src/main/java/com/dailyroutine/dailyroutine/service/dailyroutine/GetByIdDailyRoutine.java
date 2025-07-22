package com.dailyroutine.dailyroutine.service.dailyroutine;

import com.dailyroutine.dailyroutine.DTO.DailyRoutineDTO;
import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

import java.util.List;

public class GetByIdDailyRoutine implements ServiceInterface<DailyRoutineDTO> {
    private final DailyRoutineRepository repository;
    private final Integer id;
    private final boolean getTask;

    public GetByIdDailyRoutine(Integer id, Boolean getTask, DailyRoutineRepository repository){
        this.id = id;
        this.repository = repository;
        this.getTask = getTask;
    }

    @Override
    public DailyRoutineDTO execute() {
        ID.validate(this.id, false);

        DailyRoutineModel dailyRoutineDB = this.repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Rotina não encontrada!"));

        DailyRoutineDTO dailyRoutineDTO = new DailyRoutineDTO(dailyRoutineDB);

        if(this.getTask){
             List<TaskDTO> listTaskDTO = dailyRoutineDB.getTasks().stream()
                .map(TaskDTO::new)
                .toList();

            dailyRoutineDTO.setTasks(listTaskDTO);
        }

        return dailyRoutineDTO;
    }
}
