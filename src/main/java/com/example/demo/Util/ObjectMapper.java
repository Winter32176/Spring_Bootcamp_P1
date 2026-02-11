package com.example.demo.Util;

import com.example.demo.Model.*;
import org.apache.catalina.Engine;

public class ObjectMapper {
    public static CarDAO getCarDao(Car c, String additional) {
        var add = additional.split(",", 2);
        return new CarDAO(c.getName(), c.getColor(), c.getDetails(), c.getModel(), c.getCategory(), add[0], new MotorDAO(add[1]));
    }

    public static Car getCar(CarDAO carDAO) {
        return new Car(carDAO.getId(), carDAO.getName(), carDAO.getColor(), carDAO.getDetails(), carDAO.getModel(), carDAO.getCategory(), carDAO.getEngine().toString());
    }
}
