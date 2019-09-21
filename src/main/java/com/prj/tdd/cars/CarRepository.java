package com.prj.tdd.cars;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {

    public Car getFindByName(String name);
}
