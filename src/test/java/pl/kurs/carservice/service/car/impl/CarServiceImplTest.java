package pl.kurs.carservice.service.car.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.test.context.support.WithMockUser;
import pl.kurs.carservice.dao.CarRepository;
import pl.kurs.carservice.dao.EngineRepository;
import pl.kurs.carservice.models.Car;

import java.util.List;


@ExtendWith(MockitoExtension.class)
@EnableWebSecurity
class CarServiceImplTest {

    private final List<Car> carList = List.of(
            new Car("Bmw", "M3", 2015, null),
            new Car("Audi", "A6", 2010, null),
            new Car("Mercedes", "C", 2011, null),
            new Car("Opel", "Corsa", 2008, null)
    );

    private final List<Car> expectedResult = List.of(
            new Car("Audi", "A6", 2010, null),
            new Car("Bmw", "M3", 2015, null),
            new Car("Mercedes", "C", 2011, null),
            new Car("Opel", "Corsa", 2008, null)
    );

    @Mock
    private CarRepository carRepository;

    @Mock
    private EngineRepository engineRepository;

    @InjectMocks
    private CarServiceImpl carService;

    @Test
    void sortByProducers() {
        Assertions.assertTrue(expectedResult.equals(carService.sortByProducers(carList)));
    }

    @Test
    @WithMockUser(username = "user", password = "123", authorities = "USER")
    void getAllBmw() {
        List<Car> expected = List.of(new Car("Bmw", "M3", 2015, null));

        Mockito.when(carRepository.findAll()).thenReturn(carList);

        List<Car> result = carService.getAllBmw();

        Assertions.assertEquals(expected, result);
    }
}