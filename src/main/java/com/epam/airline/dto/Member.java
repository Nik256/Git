package com.epam.airline.dto;

import com.epam.airline.enums.Position;

public class Member {

    private long id;
    private String code;
    private Position position;
    private String name;
    private String surname;
    private long crew;

    public Member() {
    }

    public Member(long id, String code, Position position, String name, String surname, long crew) {
        this.id = id;
        this.code = code;
        this.position = position;
        this.name = name;
        this.surname = surname;
        this.crew = crew;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getCrew() {
        return crew;
    }

    public void setCrew(long crew) {
        this.crew = crew;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", position=" + position +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", crew=" + crew +
                '}';
    }
}
