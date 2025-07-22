package com.dailyroutine.dailyroutine.controller;

import com.dailyroutine.dailyroutine.DTO.TaskDTO;
import com.dailyroutine.dailyroutine.service.task.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private TaskService service;

    @GetMapping("/{taskID}")
    public TaskDTO getById(@PathVariable Integer taskID){
        return this.service.getById(taskID);
    }

    @GetMapping
    public List<TaskDTO> getAllOfDailyRoutineID(
            @RequestParam(value = "daily-routine-id") Integer dailyRoutineID
    ){
        return this.service.getAllOfDailyRoutineID(dailyRoutineID);
    }

    @PostMapping
    public TaskDTO create (
            @RequestParam(value = "daily-routine-id") Integer dailyRoutineID,
            @Valid @RequestBody TaskDTO taskDTO
    ){
        return this.service.create(dailyRoutineID, taskDTO);
    }

    @PutMapping("/{taskID}")
    public TaskDTO update(
            @PathVariable Integer taskID, @Valid @RequestBody  TaskDTO taskDTO
    ){
        return this.service.update(taskID, taskDTO);
    }

    @DeleteMapping("/{taskID}")
    public void delete(@PathVariable Integer taskID){
        this.service.delete(taskID);
    }
}
