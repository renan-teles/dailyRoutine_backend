package com.dailyroutine.dailyroutine.service.dailyroutine;

import com.dailyroutine.dailyroutine.DTO.DailyRoutineDTO;
import com.dailyroutine.dailyroutine.exception.resource.ResourceNotFoundException;
import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import com.dailyroutine.dailyroutine.domain.valueobject.number.ID;
import com.dailyroutine.dailyroutine.service.ServiceInterface;

public class UpdateDailyRoutine implements ServiceInterface<DailyRoutineDTO> {
    private final Integer id;
    private final DailyRoutineRepository repository;
    private final DailyRoutineDTO newDailyRoutineDTO;

    public UpdateDailyRoutine(
            Integer id,
            DailyRoutineDTO newDailyRoutine,
            DailyRoutineRepository repository
    ){
        this.id = id;
        this.newDailyRoutineDTO = newDailyRoutine;
        this.repository = repository;
    }

    @Override
    public DailyRoutineDTO execute() {
        ID.validate(this.id, false);

        DailyRoutineModel drm = this.repository.findById(this.id)
                .orElseThrow(() -> new ResourceNotFoundException("Não foi possível editar. Rotina não encontrada!"));

        drm.setName(this.newDailyRoutineDTO.getName());
        drm.setDescription(this.newDailyRoutineDTO.getDescription());

        Integer dailyRoutineID = this.repository.save(drm).getId();

        this.newDailyRoutineDTO.setId(dailyRoutineID);
        return this.newDailyRoutineDTO;
    }
}