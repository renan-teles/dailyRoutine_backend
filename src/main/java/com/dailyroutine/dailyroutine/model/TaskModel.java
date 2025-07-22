package com.dailyroutine.dailyroutine.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class TaskModel{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "daily_routine_id")
    private DailyRoutineModel dailyRoutine;

    @Column(name = "start_hour")
    private Integer startHour;

    @Column(name = "start_minute")
    private Integer startMinute;

    @Column(name = "end_hour")
    private Integer endHour;

    @Column(name = "end_minute")
    private Integer endMinute;

    public TaskModel(){}

    public DailyRoutineModel getDailyRoutine() {
        return this.dailyRoutine;
    }

    public void setDailyRoutine(DailyRoutineModel dailyRoutine) {
        this.dailyRoutine = dailyRoutine;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStartHour() {
        return startHour;
    }

    public void setStartHour(Integer startHour) {
        this.startHour = startHour;
    }

    public Integer getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(Integer startMinute) {
        this.startMinute = startMinute;
    }

    public Integer getEndHour() {
        return endHour;
    }

    public void setEndHour(Integer endHour) {
        this.endHour = endHour;
    }

    public Integer getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(Integer endMinute) {
        this.endMinute = endMinute;
    }
}