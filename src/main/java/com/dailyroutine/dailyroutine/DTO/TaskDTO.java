package com.dailyroutine.dailyroutine.DTO;

import com.dailyroutine.dailyroutine.model.TaskModel;

import jakarta.validation.constraints.*;

public class TaskDTO extends AbstractDTO{
    @NotNull(message = "A hora inicial da tarefa não pode ser nula.")
    @Min(value = 0, message = "A hora inicial não pode ser menor que 0.")
    @Max(value = 24, message = "A hora inicial não pode ser maior que 23.")
    private Integer startHour;

    @NotNull(message = "O minuto inicial não pode ser nulo.")
    @Min(value = 0, message = "O minuto inicial não pode ser menor que 0.")
    @Max(value = 60, message = "O minuto inicial não pode ser maior que 23.")
    private Integer startMinute;

    @NotNull(message = "A hora final da tarefa não pode ser nula")
    @Min(value = 0, message = "A hora final não pode ser menor que 0")
    @Max(value = 24, message = "A hora final não pode ser maior que 23")
    private Integer endHour;

    @NotNull(message = "O minuto final não pode ser nulo.")
    @Min(value = 0, message = "O minuto final não pode ser menor que 0.")
    @Max(value = 60, message = "O minuto final não pode ser maior que 23.")
    private Integer endMinute;

    public TaskDTO(){super();}

    public TaskDTO(
            Integer id,
            String name,
            String description,
            Integer startHour,
            Integer startMinute,
            Integer endHour,
            Integer endMinute
    ) {
        super(id, name, description);
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public TaskDTO(
            String name,
            String description,
            Integer startHour,
            Integer startMinute,
            Integer endHour,
            Integer endMinute
    ) {
        super(name, description);
        this.startHour = startHour;
        this.startMinute = startMinute;
        this.endHour = endHour;
        this.endMinute = endMinute;
    }

    public TaskDTO(TaskModel tm){
        this(
                tm.getId(),
                tm.getName(),
                tm.getDescription(),
                tm.getStartHour(),
                tm.getStartMinute(),
                tm.getEndHour(),
                tm.getEndMinute()
        );
    }

    public Integer getStartHour() {
        return startHour;
    }

    public Integer getStartMinute() {
        return startMinute;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public Integer getEndMinute() {
        return endMinute;
    }
}