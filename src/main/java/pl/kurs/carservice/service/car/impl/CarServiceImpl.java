package pl.kurs.carservice.service.car.impl;

import org.springframework.stereotype.Service;
import pl.kurs.carservice.dao.CarRepository;
import pl.kurs.carservice.dao.EngineRepository;
import pl.kurs.carservice.models.Car;
import pl.kurs.carservice.service.car.CarService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final EngineRepository engineRepository;

    public CarServiceImpl(CarRepository carRepository, EngineRepository engineRepository) {
        this.carRepository = carRepository;
        this.engineRepository = engineRepository;
    }


    @Override
    public void createCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteCar(Car car) {
        carRepository.delete(car);
    }

    @Override
    public void updateCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public Car findCarById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public List<Car> findAllCars() {
        List<Car> result = new ArrayList<>();
        carRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public List<Car> sortByProducers(List<Car> carList) {
       return carList.stream()
                .sorted(Comparator.comparing(Car::getProducer))
                .collect(Collectors.toList());
    }

    @Override
    public List<Car> getAllBmw() {
        List<Car> carList = new ArrayList<>();
        carRepository.findAll().forEach(carList::add);
        return carList.stream()
                .filter(car -> car.getProducer().equals("Bmw"))
                .collect(Collectors.toList());
    }
}
