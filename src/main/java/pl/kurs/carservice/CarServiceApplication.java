package pl.kurs.carservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.carservice.dao.CarRepository;
import pl.kurs.carservice.models.Car;
import pl.kurs.carservice.models.Engine;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CarServiceApplication {
    public static final String MERCEDES = "Mercedes";
    public static final String CAR_NAME = "car.model.name";
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(CarServiceApplication.class, args);

        CarRepository carRepository = ctx.getBean(CarRepository.class);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car(MERCEDES, "S-klasa", new Engine("4500cm", 465, 650)));

        Car car = new Car(MERCEDES, "S-klasa", new Engine("4500cm", 465, 650));
        Car car1 = new Car("Audi", "RS7", new Engine("4000cm", 560, 700));
        Car car2 = new Car("BMW", "M8", new Engine("4800cm", 625, 700));

        carRepository.save(car);
        carRepository.save(car1);
        carRepository.findById(1L);
//        carRepository.delete();
    }
}