package com.dailyroutine.dailyroutine.domain.task;

import java.time.LocalTime;

public class TaskTime {
    private final Time startTime;
    private final Time endTime;

    public TaskTime(Time startTime, Time endTime) {
        this.validateTimes(startTime,endTime);
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getStartHour(){
        return this.startTime.getHour();
    }

    public Integer getStartMinute(){
        return this.startTime.getMinute();
    }

    public Integer getEndHour(){
        return this.endTime.getHour();
    }

    public Integer getEndMinute(){
        return this.endTime.getMinute();
    }

    private void validateTimes(Time startTime, Time endTime){
        if(startTime.equals(endTime)){
            throw new IllegalArgumentException("Os horários da tarefa não podem ser iguais.");
        }

        LocalTime localStartTime = LocalTime.of(startTime.getHour(), startTime.getMinute());
        LocalTime localEndTime = LocalTime.of(endTime.getHour(), endTime.getMinute());

        if (localEndTime.isBefore(localStartTime)) {
            throw new IllegalArgumentException("O horário de término não pode ser antes do horário de início da tarefa.");
        }
    }
}