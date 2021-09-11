package com.refactorizando.example.record.controller;

import com.refactorizando.example.record.model.BrandDto;
import com.refactorizando.example.record.model.CarDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@Slf4j
public class CarController {


    private static final List<CarDto> cars = List.of(new CarDto(1L, new BrandDto(1L, "Ford"), "Mustang", "Black"));

    @GetMapping
    public List<CarDto> getCars() {

        log.info("Get cars " );

        return cars;
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable Long id) {

        log.info("Get car with id {}", id);

        return cars
                .stream()
                .filter(car -> car.id().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Element with id " + id + "not found"));
    }

    @PostMapping()
    public CarDto newCar(@RequestBody CarDto car) {

        return car;
    }
}
