package ru.javawebinar.topjava.model;

import ru.javawebinar.topjava.storage.MealStorageImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public class Meal {
    public static final Meal EMPTY = new Meal();
    private int uuid;
    private LocalDateTime dateTime;

    private  String description;

    private int calories;

    public Meal() {
        this.calories = 100;
        this.description = "Новая еда";
        this.dateTime = LocalDateTime.now();
    }

    public Meal(LocalDateTime dateTime, String description, int calories) {

        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUuid(int uuid) {
        this.uuid = uuid;
    }

    public int getUuid() {
        return uuid;
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

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }
    public boolean isNew(){
        if(this.uuid == 0){
            return true;
        }else {
            return false;
        }
    }
}
