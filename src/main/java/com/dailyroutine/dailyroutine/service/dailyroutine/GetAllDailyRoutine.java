package com.dailyroutine.dailyroutine.service.dailyroutine;

import com.dailyroutine.dailyroutine.DTO.DailyRoutineDTO;
import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GetAllDailyRoutine implements ServiceInterface<List<DailyRoutineDTO>> {
    private final DailyRoutineRepository repository;
    private final Boolean getTasks;

    public GetAllDailyRoutine(Boolean getTasks, DailyRoutineRepository repository){
        this.getTasks = getTasks;
        this.repository = repository;
    }

    @Override
    public List<DailyRoutineDTO> execute() {
        List<DailyRoutineModel> listDailyRoutineModel = this.repository.findAll();

        if (listDailyRoutineModel.isEmpty()) {
            return Collections.emptyList();
        }

        return this.getDailyRoutinesDTO(listDailyRoutineModel);
    }

    private List<DailyRoutineDTO> getDailyRoutinesDTO(List<DailyRoutineModel> listDailyRoutineModel){
        return listDailyRoutineModel.stream().map(drm -> {
            DailyRoutineDTO dailyRoutineDTO = new DailyRoutineDTO(drm);

            if (this.getTasks) {
                dailyRoutineDTO.setTasks(this.getTasksDTO(drm));
            }

            return dailyRoutineDTO;
        }).collect(Collectors.toList());
    }

    private List<TaskDTO> getTasksDTO(DailyRoutineModel drm){
        return drm.getTasks().stream()
                .map(TaskDTO::new)
                .collect(Collectors.toList());
    }
}