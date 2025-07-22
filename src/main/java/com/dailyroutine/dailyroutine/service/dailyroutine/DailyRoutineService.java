package com.dailyroutine.dailyroutine.service.dailyroutine;

import com.dailyroutine.dailyroutine.DTO.DailyRoutineDTO;
import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import com.dailyroutine.dailyroutine.repository.DailyRoutineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyRoutineService {
    @Autowired
    private DailyRoutineRepository repository;

    public DailyRoutineDTO create(DailyRoutineDTO dailyRoutineDTO){
        return new CreateDailyRoutine(dailyRoutineDTO, this.repository).execute();
    }

    public void delete(Integer id){
        new DeleteDailyRoutine(id, this.repository).execute();
    }

    public List<DailyRoutineDTO> getAll(Boolean getTasks){
        return new GetAllDailyRoutine(getTasks, this.repository).execute();
    }

    public DailyRoutineDTO getById(Integer id, Boolean getTask){
        return new GetByIdDailyRoutine(id, getTask, this.repository).execute();
    }

    public DailyRoutineDTO update(Integer id, DailyRoutineDTO newDailyRoutineDTO){
        return new UpdateDailyRoutine(id, newDailyRoutineDTO, this.repository).execute();
    }
}
