package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.storage.MealStorageImpl;
import ru.javawebinar.topjava.storage.Storage;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private Storage storage;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        storage = new MealStorageImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("redirect to meals");
        String uuid = req.getParameter("id");

        String action = req.getParameter("action");
        if (action == null) {
            req.setAttribute("meals", storage.getAll());
            req.getRequestDispatcher("/meals.jsp").forward(req, resp);
            return;
        }
        switch (action) {
            case "delete":
                storage.delete(Integer.parseInt(uuid));
                req.setAttribute("meals", storage.getAll());
                req.getRequestDispatcher("/meals.jsp").forward(req, resp);
                return;
           case "create":
                Meal meal  = Meal.EMPTY;
                req.setAttribute("meal", meal);
                req.getRequestDispatcher("/edit.jsp").forward(req, resp);
                break;
            case "update":
                Meal meal2 = storage.get(Integer.parseInt(uuid));
                req.setAttribute("meal", meal2);
                req.getRequestDispatcher("/edit.jsp").forward(req, resp);
                break;

    }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uuid = req.getParameter("uuid");
        String description = req.getParameter("description");
        String datetime = req.getParameter("datetime");
        String calories = req.getParameter("calories");

        final boolean isCreated = (uuid == null || uuid.length() == 0);
        Meal m;
        if (isCreated) {
            m = new Meal();
        } else {
            m = storage.get(Integer.parseInt(uuid));
            m.setCalories(Integer.parseInt(calories));

        }
    }

}
