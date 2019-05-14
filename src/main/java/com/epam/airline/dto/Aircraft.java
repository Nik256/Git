package com.epam.airline.dto;

public class Aircraft {
    private long id;
    private String name;
    private String tailNumber;

    public Aircraft() {
    }

    public Aircraft(long id, String name, String tailNumber) {
        this.id = id;
        this.name = name;
        this.tailNumber = tailNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTailNumber() {
        return tailNumber;
    }

    public void setTailNumber(String tailNumber) {
        this.tailNumber = tailNumber;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tailNumber='" + tailNumber + '\'' +
                '}';
    }
}
