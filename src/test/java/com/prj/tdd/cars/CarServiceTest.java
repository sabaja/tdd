package com.prj.tdd.cars;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.BDDMockito.given;


@RunWith(MockitoJUnitRunner.class)
public class CarServiceTest {

    @Mock
    private CarRepository carRepository;
    @Autowired
    private CarService carService;

    @Before
    public void setUp() {
        this.carService = new CarServiceImpl(carRepository);
    }

    @Test
    public void getCarDetails_returnCarDetails() {
        given(this.carRepository.getFindByName("Prius"))
                .willReturn(new Car("Prius", "Hybrid"));

        Car car = this.carService.getCarDetails("Prius");
        assertNotNull(car);

        assertThat("Prius".equals(car.getName()));
        assertThat("Hybrid".equals(car.getType()));
    }

    @Test(expected = CarNotFoundException.class)
    public void getCarDetails_NotFound() throws Exception{
        given(this.carRepository.getFindByName("Prius")).willReturn(null);
        Car car = this.carService.getCarDetails("Prius");
        assertNull(car);
    }
}
