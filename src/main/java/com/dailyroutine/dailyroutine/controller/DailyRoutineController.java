package com.dailyroutine.dailyroutine.controller;

import com.dailyroutine.dailyroutine.DTO.DailyRoutineDTO;
import com.dailyroutine.dailyroutine.service.dailyroutine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/daily-routine")
public class DailyRoutineController {
    @Autowired
    private DailyRoutineService service;

    @GetMapping
    public List<DailyRoutineDTO> getAll(
            @RequestParam(value = "get-tasks", required = false, defaultValue = "false") Boolean getTasks
    ){
        return this.service.getAll(getTasks);
    }

    @GetMapping("/{id}")
    public DailyRoutineDTO getById(
            @PathVariable Integer id,
            @RequestParam(value = "get-tasks", required = false, defaultValue = "false") Boolean getTasks
    ){
        return this.service.getById(id, getTasks);
    }

    @PostMapping
    public DailyRoutineDTO create(@Valid @RequestBody DailyRoutineDTO dailyRoutineDTO){
        return this.service.create(dailyRoutineDTO);
    }

    @PutMapping("/{id}")
    public DailyRoutineDTO update(
            @PathVariable Integer id,
            @Valid @RequestBody DailyRoutineDTO dailyRoutineDTO
    ){
        return this.service.update(id, dailyRoutineDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        this.service.delete(id);
    }
}
