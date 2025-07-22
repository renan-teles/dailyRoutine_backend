package com.dailyroutine.dailyroutine.service.dailyroutine;

import com.dailyroutine.dailyroutine.DTO.DailyRoutineDTO;
import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

public class CreateDailyRoutine implements ServiceInterface<DailyRoutineDTO> {
    private final DailyRoutineDTO dailyRoutineDTO;
    private final DailyRoutineRepository repository;

    public CreateDailyRoutine(DailyRoutineDTO dailyRoutineDTO, DailyRoutineRepository repository) {
        this.dailyRoutineDTO = dailyRoutineDTO;
        this.repository = repository;
    }

    @Override
    public DailyRoutineDTO execute() {
        DailyRoutineModel dailyRoutineModel = new DailyRoutineModel();
        dailyRoutineModel.setName(this.dailyRoutineDTO.getName());
        dailyRoutineModel.setDescription(this.dailyRoutineDTO.getDescription());

        Integer dailyRoutineID = this.repository.save(dailyRoutineModel).getId();

        this.dailyRoutineDTO.setId(dailyRoutineID);
        return this.dailyRoutineDTO;
    }
}
