package com.example.demo.Util;

import com.example.demo.Model.*;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ObjectMapper {
    public static CarDAO getCarDao(Car c, String additional) {
        var add = additional.split(",", 2);
        return new CarDAO(c.getName(), c.getColor(), c.getDetails(), c.getModel(), c.getCategory(), add[0], new MotorDAO(add[1]));
    }

    public static Car getCar(CarDAO carDAO) {
        return new Car(carDAO.getId(), carDAO.getName(), carDAO.getColor(), carDAO.getDetails(), carDAO.getModel(), carDAO.getCategory(), carDAO.getEngine().toString());
    }

    public static CarDAO getCarDao(Car c) {
        var add = c.getAdditionalInfo().split(",", 2);
        Field[] fields = Car.class.getDeclaredFields();

        return new CarDAO(c.getName(), c.getColor(), c.getDetails(), c.getModel(), c.getCategory(), add[0], new MotorDAO(add[1]));
    }
}
