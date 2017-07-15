package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.storage.MealStorageImpl;

import java.time.LocalDateTime;


public class MealWithExceed {
    private int uuid;
    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean exceed;

    public MealWithExceed(int uuid, LocalDateTime dateTime, String description, int calories, boolean exceed) {
        this.uuid = uuid;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.exceed = exceed;
    }

    public int getUuid() {
        return uuid;
    }

    public boolean getExceed() {
        return exceed;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "UserMealWithExceed{" +
                "dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", calories=" + calories +
                ", exceed=" + exceed +
                '}';
    }
}