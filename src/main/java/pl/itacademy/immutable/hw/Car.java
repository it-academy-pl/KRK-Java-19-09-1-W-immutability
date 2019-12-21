package pl.itacademy.immutable.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class Car {
    private final List<Wheel> wheels;

    public Car(List<Wheel> wheels) {
        this.wheels = copyOf(wheels);
    }

    public List<Wheel> getWheels() {
        return copyOf(wheels);
    }

    private List<Wheel> copyOf(List<Wheel> wheels) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(new Wheel(wheel.getRadius()));
        }
        return copy;
    }

    @Override
    public String toString() {
        return "Car{" +
                "wheels=" + wheels +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(wheels, car.wheels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheels);
    }
}
