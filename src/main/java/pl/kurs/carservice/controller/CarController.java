package pl.kurs.carservice.controller;

import org.springframework.web.bind.annotation.*;
import pl.kurs.carservice.models.Car;
import pl.kurs.carservice.service.car.CarService;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.findAllCars();
    }

    @GetMapping("/byId/{id}")
    public Car getCarById(@PathVariable Long id) {
       return carService.findCarById(id);
    }

    @PostMapping("/create")
    public void postCar(@RequestBody Car car) {
        carService.createCar(car);
    }

    @DeleteMapping("/delete")
    public void deleteCar(@RequestBody Car car) {
        carService.deleteCar(car);
    }
}
