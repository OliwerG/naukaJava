package pl.kurs.carservice.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarWashTest {

    private CarWash carWash;

    @BeforeEach
    public void setup() {
        carWash = new CarWash("Myjnia", 3);
    }

    @Test
    public void shouldReturnTrueIfCarWashIsActive() {
        assertTrue(carWash.isActive());
    }

    @Test
    public void shouldReturnFalseIfCarWashIsInactive() {
        carWash.deactivate();
        assertFalse(carWash.isActive());
    }

    @Test
    public void shouldSuccessWhenAllCarsAreAddedToQueue() {
        Car car1 = new Car("Bmw", "340i", null);
        Car car2 = new Car("Mercedes", "C300", null);
        Car car3 = new Car("Audi", "A5", null);

        createCarsQueue();

        assertEquals(car1, carWash.getNextCarInQueue());
        assertEquals(car2, carWash.getNextCarInQueue());
        assertEquals(car3, carWash.getNextCarInQueue());
        assertNull(carWash.getNextCarInQueue());
    }

    @Test
    public void shouldSuccessWhenAllStationsAreWorking() {
        createCarsQueue();

        assertEquals(3, carWash.getFreeStationsCount());
        carWash.washNextCarInQueue();
        assertEquals(2, carWash.getFreeStationsCount());
        carWash.washNextCarInQueue();
        assertEquals(1, carWash.getFreeStationsCount());
        carWash.washNextCarInQueue();
        assertEquals(0, carWash.getFreeStationsCount());
    }

    private void createCarsQueue() {
        carWash.addCarToQueue(new Car("Bmw", "340i", null));
        carWash.addCarToQueue(new Car("Mercedes", "C300", null));
        carWash.addCarToQueue(new Car("Audi", "A5", null));
    }
}