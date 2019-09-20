package com.prj.tdd.cars;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCarDetails(String name) {
        return null;
    }
}
