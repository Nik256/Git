package com.epam.airline.enums;

import java.util.HashMap;
import java.util.Map;

public enum Position {
    PILOT("Пилот"),
    NAVIGATOR("Навигатор"),
    OPERATOR("Оператор"),
    STEWARDESS("Стюардесса");

    private String name;

    Position(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final Map<String, Position> lookup = new HashMap<>();

    static {
        for(Position position : Position.values()) {
            lookup.put(position.getName(), position);
        }
    }

    public static Position get(String name)
    {
        return lookup.get(name);
    }
}