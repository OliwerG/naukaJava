package pl.kurs.carservice.models;

import lombok.Getter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

@Getter
public class CarWash {
    private final String name;
    private boolean isActive;
    private final HashMap<Integer, Station> stations;
    private final Queue<Car> carQueue;

    public CarWash(final String name, final int stationsCount) {
        this.name = name;
        this.isActive = true;
        this.stations = createStations(stationsCount);
        this.carQueue = new LinkedList<>();
    }

    /**
     * This method create new Stations
     *
     * @param stationsCount number of stations
     * @return map of stations
     */
    private HashMap<Integer, Station> createStations(final int stationsCount) {
        HashMap<Integer, Station> stationsMap = new HashMap<>();
        for (int i = 1; i <= stationsCount; i++) {
            stationsMap.put(i, new Station(i));
        }
        return stationsMap;
    }

    public void activate() {
        this.isActive = true;
    }

    public void deactivate() {
        this.isActive = false;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void addCarToQueue(Car car) {
        this.carQueue.offer(car);
    }

    public Car getNextCarInQueue() {
        return this.carQueue.poll();
    }

    public int getFreeStationsCount() {
        int count = 0;
        for (Station station : this.stations.values()) {
            if (!station.isBusy()) {
                count++;
            }
        }
        return count;
    }

    /**
     * This method gets first free station
     *
     * @return return find first free station as optional
     */
    public Optional<Station> getFirstFreeStation() {
        return this.stations.values()
                .stream()
                .filter(station -> !station.isBusy())
                .findFirst();
    }

    /**
     * This method get a car from queue and put it into free station
     */
    public void washNextCarInQueue() {
        Car nextCar = this.getNextCarInQueue();
        if (nextCar != null) {
            Optional<Station> freeStation = this.getFirstFreeStation();
            if (freeStation.isPresent()) {
                freeStation.get().washingCar(nextCar);
            }
        }
    }
}
