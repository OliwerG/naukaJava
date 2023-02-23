package pl.kurs.carservice.dao;

import org.springframework.data.repository.CrudRepository;
import pl.kurs.carservice.models.Car;

public interface CarRepository extends CrudRepository<Car, Long> {
}
