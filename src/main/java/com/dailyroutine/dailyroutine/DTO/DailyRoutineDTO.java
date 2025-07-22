package com.dailyroutine.dailyroutine.DTO;

import com.dailyroutine.dailyroutine.model.DailyRoutineModel;

import java.util.List;

public class DailyRoutineDTO extends AbstractDTO{
    private List<TaskDTO> tasks;

    public DailyRoutineDTO(){super();}

    public DailyRoutineDTO(String name, String description) {
        super(name, description);
    }

    public DailyRoutineDTO(Integer id, String name, String description) {
       super(id, name, description);
    }

    public DailyRoutineDTO(DailyRoutineModel drm){
        this(drm.getId(), drm.getName(), drm.getDescription());
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }
}