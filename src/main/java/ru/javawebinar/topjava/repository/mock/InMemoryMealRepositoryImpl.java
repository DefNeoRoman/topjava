package ru.javawebinar.topjava.repository.mock;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.util.MealsUtil;

import java.rmi.MarshalledObject;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class InMemoryMealRepositoryImpl implements MealRepository {
    private Map<Integer, Map<Integer, Meal>> repository = new ConcurrentHashMap<>();
    private AtomicInteger counter = new AtomicInteger(0);

    {
        MealsUtil.MEALS.forEach(userMeal -> save(userMeal,userMeal.getId())); // Пока что просто сохраним еду юзера
    }

    @Override
    public Meal save(Meal meal, int userId) {
        if (meal.isNew()) {
            meal.setId(counter.incrementAndGet());
        }
        Map<Integer, Meal>  mealsForOneUser;
        if (repository.get(userId) == null){
            mealsForOneUser = new ConcurrentHashMap<>();
            repository.put(userId,mealsForOneUser);


        }else {
            mealsForOneUser = repository.get(userId);

        }
        mealsForOneUser.put(meal.getId(), meal);
        return meal;
    }

    @Override
    public boolean delete(int id, int userId) {
        Map<Integer,Meal> meals = repository.get(userId);
        if(meals != null && meals.get(id) != null){
            meals.remove(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Meal get(int id, int userId) {
        Map<Integer, Meal> mealsForOneUser = repository.get(userId);
        if(mealsForOneUser.get(userId) != null){
            return mealsForOneUser.get(id);
        }else {
             return null;
        }

    }

    @Override
    public List<Meal> getAll(int userId) {
        List<Meal> ml;
        if(repository.containsKey(userId)){
           ml = new ArrayList<>(repository.get(userId).values());
        }else{
            ml = Collections.emptyList();
        }


        return ml.stream().sorted(Comparator.comparing(Meal::getDateTime).reversed()).collect(Collectors.toList());
    }
}

