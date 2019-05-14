package com.epam.airline.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {
    READY("Готов"),
    WAITING_FOR_APPROVAL("Ожидает подтверждения");

    private String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static final Map<String, Status> lookup = new HashMap<>();

    static {
        for(Status status : Status.values()) {
            lookup.put(status.getName(), status);
        }
    }

    public static Status get(String name)
    {
        return lookup.get(name);
    }
}
