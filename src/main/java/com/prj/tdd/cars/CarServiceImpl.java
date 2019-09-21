package com.prj.tdd.cars;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car getCarDetails(String name) throws CarNotFoundException {
        Car car = carRepository.getFindByName(name);
        if (Objects.isNull(car)) {
            throw new CarNotFoundException();
        }
        return car;
    }
}
