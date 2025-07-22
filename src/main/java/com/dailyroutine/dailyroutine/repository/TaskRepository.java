package com.dailyroutine.dailyroutine.repository;

import com.dailyroutine.dailyroutine.model.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface
    TaskRepository
        extends JpaRepository<TaskModel, Integer> {

    List<TaskModel> findByDailyRoutineId(Integer dailyRoutineId);
}