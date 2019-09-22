package com.prj.tdd.cars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
@AutoConfigureCache
public class CarCashingTest {

    //@Mock non funziona, il mock prima isola da dipendenze complesse e poi simula il service, quindi non va benes
    @Autowired
    private CarService carService;
    //Simula il repository nello Spring Context
    @MockBean
    private CarRepository carRepository;

    @Test
    public void caching_shouldCashACar() {
        given(this.carRepository.getFindByName(anyString())).willReturn(new Car("Prius", "Hybrid"));

        this.carService.getCarDetails("Prius");
        this.carService.getCarDetails("Prius");

        verify(carRepository, times(1)).getFindByName("Prius");

    }

}