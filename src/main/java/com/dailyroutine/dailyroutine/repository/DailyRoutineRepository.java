package com.dailyroutine.dailyroutine.repository;

import com.dailyroutine.dailyroutine.model.DailyRoutineModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface
    DailyRoutineRepository
        extends JpaRepository<DailyRoutineModel, Integer> {}