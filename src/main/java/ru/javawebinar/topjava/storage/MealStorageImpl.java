package ru.javawebinar.topjava.storage;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MealStorageImpl implements Storage {
    private Map<Integer, Meal> mealsStorage = new ConcurrentHashMap<>();
    public static AtomicInteger atomicInt = new AtomicInteger(0);
    private LocalTime startTime;
    private LocalTime endTime;
    private int caloriesPerDay;
    public MealStorageImpl() {
        this.startTime = LocalTime.of(0,0);
        this.endTime = LocalTime.of(23, 0);
        this.caloriesPerDay = 2000;


            }
    {
       save(Mock.MEAL1);
       save(Mock.MEAL2);
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setCaloriesPerDay(int caloriesPerDay) {
        this.caloriesPerDay = caloriesPerDay;
    }

    @Override
    public void save(Meal meal) {
        if(meal.isNew()){
           meal.setUuid(atomicInt.incrementAndGet());
        }
        mealsStorage.put(meal.getUuid(),meal);
    }

    @Override
    public Meal get(int idMeal) {
        if(idMeal == 0){
            System.out.println("i have not id to get");
        }
        return mealsStorage.get(idMeal);
    }

    @Override
    public void update(Meal meal, int id) {
        if(id == 0 || meal == null){
            System.out.println("nothing to update");
        }
        mealsStorage.remove(id);
        mealsStorage.put(meal.getUuid(),meal);

    }

    @Override
    public void delete(int id) {
        if(id == 0){
            System.out.println("nothing to remove");
        }
        mealsStorage.remove(id);
    }

    @Override
    public List<MealWithExceed> getAll() {

        return MealsUtil.getFilteredWithExceeded(new ArrayList<>(mealsStorage.values()),startTime,endTime,caloriesPerDay);
    }
}
