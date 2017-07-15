package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;


public class Mock {
    public static final Meal MEAL1 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500);
    public static final Meal MEAL2 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "обед", 700);
    public static final Meal MEAL3 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "ужин", 800);
    public static final Meal MEAL4 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "полдник", 900);
    public static final Meal MEAL5 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "второй ужин", 80);
    public static final Meal MEAL6 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "второй Завтрак", 540);
    public static final Meal MEAL7 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "разминочка", 300);
    public static final Meal MEAL8 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "заминочка", 20);
    public static final Meal MEAL9 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Когда голодный", 1500);
    public static final Meal MEAL10 =   new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Когда устал", 500);
    
   
}
