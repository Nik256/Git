package com.epam.airline.dto;

import com.epam.airline.enums.Status;

import java.time.LocalDateTime;

public class Flight {

    private long id;
    private String code;
    private Aircraft aircraft;
    private Airport fromAirport;
    private Airport toAirport;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Crew crew;
    private Status status;

    public Flight() {
    }

    public Flight(long id,
                  String code,
                  Aircraft aircraft,
                  Airport fromAirport,
                  Airport toAirport,
                  LocalDateTime departureDateTime,
                  LocalDateTime arrivalDateTime,
                  Crew crew,
                  Status status) {
        this.id = id;
        this.code = code;
        this.aircraft = aircraft;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.crew = crew;
        this.status = status;
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

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(Airport fromAirport) {
        this.fromAirport = fromAirport;
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(Airport toAirport) {
        this.toAirport = toAirport;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", aircraft=" + aircraft +
                ", fromAirport=" + fromAirport +
                ", toAirport=" + toAirport +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", crew=" + crew +
                ", status=" + status +
                '}';
    }
}
