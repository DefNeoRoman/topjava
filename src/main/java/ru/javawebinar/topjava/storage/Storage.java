package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;

import java.util.ArrayList;
import java.util.List;

public interface Storage {
     void save(Meal meal);

     Meal get(int id);

     void update(Meal meal, int id);

     void delete(int id);
     List getAll();
}
