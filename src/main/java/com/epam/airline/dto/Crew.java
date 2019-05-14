package com.epam.airline.dto;

import com.epam.airline.enums.Status;

import java.util.List;

public class Crew {

    private long id;
    private String code;
    private Status status;
    private List<Member> members;

    public Crew() {
    }

    public Crew(long id, String code, Status status, List<Member> members) {
        this.id = id;
        this.code = code;
        this.status = status;
        this.members = members;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return "Crew{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", members=" + members +
                '}';
    }
}
