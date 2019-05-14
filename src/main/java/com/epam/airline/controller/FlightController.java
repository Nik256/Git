package com.epam.airline.controller;

import com.epam.airline.dto.Flight;
import com.epam.airline.service.AircraftService;
import com.epam.airline.service.AirportService;
import com.epam.airline.service.CrewService;
import com.epam.airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightService;

    @Autowired
    private AirportService airportService;

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private CrewService crewService;

    @GetMapping("/flights")
    private ModelAndView flights() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/flight/flights");
        modelAndView.addObject("flights", flightService.findAll());
        modelAndView.addObject("aircrafts", aircraftService.findAll());
        modelAndView.addObject("airports", airportService.findAll());
        modelAndView.addObject("crews", crewService.findAll());
        return modelAndView;
    }

    @PostMapping("/create-flight")
    private ModelAndView createFlight(@RequestParam(value = "code") String code,
                                      @RequestParam(value = "aircraft") String aircraft,
                                      @RequestParam(value = "fromAirport") String fromAirport,
                                      @RequestParam(value = "toAirport") String toAirport,
                                      @RequestParam(value = "departureDateTime")
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                  LocalDateTime departureDateTime,
                                      @RequestParam(value = "arrivalDateTime")
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                  LocalDateTime arrivalDateTime,
                                      @RequestParam(value = "crew") String crew,
                                      @RequestParam(value = "status") String status) {
        Flight newFlight = flightService.getFlightFromParams(0,
                code,
                aircraft,
                fromAirport,
                toAirport,
                departureDateTime,
                arrivalDateTime,
                crew,
                status);
        flightService.createFlight(newFlight);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/flights");
        return modelAndView;
    }

    @GetMapping("/flight/{id}")
    private ModelAndView editFlight(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/flight/flight");
        modelAndView.addObject("flight", flightService.getFlightById(id));
        modelAndView.addObject("aircrafts", aircraftService.findAll());
        modelAndView.addObject("airports", airportService.findAll());
        modelAndView.addObject("crews", crewService.getReadyCrew());
        System.out.println("sdjflsdjfkl");
        return modelAndView;
    }

    @PostMapping("/edit-flight")
    private ModelAndView editFlight(@RequestParam(value = "id") long id,
                                    @RequestParam(value = "code") String code,
                                    @RequestParam(value = "aircraft") String aircraft,
                                    @RequestParam(value = "fromAirport") String fromAirport,
                                    @RequestParam(value = "toAirport") String toAirport,
                                    @RequestParam(value = "departureDateTime")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                LocalDateTime departureDateTime,
                                    @RequestParam(value = "arrivalDateTime")
                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                                                LocalDateTime arrivalDateTime,
                                    @RequestParam(value = "crew") String crew,
                                    @RequestParam(value = "status") String status) {
        Flight editedFlight = flightService.getFlightFromParams(id,
                code,
                aircraft,
                fromAirport,
                toAirport,
                departureDateTime,
                arrivalDateTime,
                crew,
                status);
        flightService.editFlight(editedFlight);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/flights");
        return modelAndView;
    }

    @GetMapping("/delete-flight/{id}")
    private ModelAndView deleteFlight(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        Flight flightToDelete = flightService.getFlightById(id);
        flightService.deleteFlight(flightToDelete);
        modelAndView.setViewName("redirect:/flights");
        return modelAndView;
    }
}
