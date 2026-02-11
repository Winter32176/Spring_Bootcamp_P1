package com.example.demo.Util;

import com.example.demo.Model.Car;
import com.example.demo.Model.CarDAO;
import com.example.demo.Model.MotorDAO;

public class ObjectMapper {

    // Car -> CarDAO (no crash if add has no comma)
    public static CarDAO toEntity(Car c) {
        CarDAO dao = new CarDAO();
        dao.setName(c.getName());
        dao.setColor(c.getColor());
        dao.setDetails(c.getDetails());
        dao.setModel(c.getModel());
        dao.setCategory(c.getCategory());
        applyAdditional(dao, c.getAdditionalInfo());
        return dao;
    }

    // apply "additionalInfo,engineType" safely
    public static void applyAdditional(CarDAO dao, String add) {
        String additionalInfo = (add == null) ? "" : add.trim();
        String engineType = "";

        if (additionalInfo.contains(",")) {
            String[] parts = additionalInfo.split(",", 2);
            additionalInfo = parts[0].trim();
            engineType = parts[1].trim();
        }

        dao.setAdditionalInfo(additionalInfo);

        if (dao.getEngine() == null) dao.setEngine(new MotorDAO(engineType));
        else dao.getEngine().setType(engineType);
    }

    // CarDAO -> Car (use engine.getType())
    public static Car toModel(CarDAO d) {
        if (d == null) return null;
        String engineType = (d.getEngine() == null) ? "" : d.getEngine().getType();

        return new Car(
                d.getId(),
                d.getName(),
                d.getColor(),
                d.getDetails(),
                d.getModel(),
                d.getCategory(),
                d.getAdditionalInfo() + (engineType.isBlank() ? "" : "," + engineType)
        );
    }
}
