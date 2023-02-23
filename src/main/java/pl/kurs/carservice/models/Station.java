package pl.kurs.carservice.models;

public class Station {
    private final int number;
    private boolean isActive;
    private boolean isBusy;
    private Car washedCar;

    public Station(final int number) {
        this.number = number;
        this.isActive = true;
        this.isBusy = false;
    }

    public int getNumber() {
        return number;
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

    public void setBusy() {
        this.isBusy = true;
    }

    public void free() {
        this.isBusy = false;
    }

    public boolean isBusy() {
        return this.isBusy;
    }

    public Car getWashedCar() {
        return washedCar;
    }

    public void washingCar(final Car car) {
        this.setBusy();
        this.washedCar = car;
    }

    public void finishWashingCar() {
        this.free();
        this.washedCar = null;
    }
}
