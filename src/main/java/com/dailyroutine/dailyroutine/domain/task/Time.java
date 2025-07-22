package com.dailyroutine.dailyroutine.domain.task;

import java.util.Objects;

public class Time {
    private final Integer hour;
    private final Integer minute;

    public Time(Integer hour, Integer minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public Integer getHour() {
        return hour;
    }

    public Integer getMinute() {
        return minute;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return Objects.equals(hour, time.hour) && Objects.equals(minute, time.minute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute);
    }
}
