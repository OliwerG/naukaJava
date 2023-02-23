package pl.kurs.carservice.service.car;

import pl.kurs.carservice.models.Car;

import java.util.List;

public interface CarService {
    void createCar(Car car);

    List<Car> sortByProducers(List<Car> carList);

    List<Car> getAllBmw();

    void deleteCar(Car car);

    void updateCar(Car car);

    Car findCarById(Long id);

    List<Car> findAllCars();
}
