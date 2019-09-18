package com.prj.tdd.cars;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {

    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{name}")
    public Car getCars(@PathVariable String name) {
        return carService.getCarDetails(name);
    }

//    Aggiungere questo metodo per catchare l'eccezione
//    Altrimenti Annotare la classe CarNotFoundException con l'annotazione @ResponseStatus(HttpStatus.NOT_FOUND)
//    Come è adesso:
/*
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void carNotFoundException(CarNotFoundException e){}
*/
}
