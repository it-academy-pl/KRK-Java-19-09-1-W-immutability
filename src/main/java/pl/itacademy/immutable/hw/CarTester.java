package pl.itacademy.immutable.hw;

import java.util.ArrayList;
import java.util.List;

public class CarTester {
    public static void main(String[] args) {
        Wheel wheel1 = new Wheel(10);
        Wheel wheel2 = new Wheel(10);
        Wheel wheel3 = new Wheel(10);
        Wheel wheel4 = new Wheel(10);

        List<Wheel> wheels = new ArrayList<>();
        wheels.addAll(List.of(wheel1, wheel2, wheel3, wheel4));

        Car car = new Car(wheels);
        System.out.println(car.hashCode());

        wheels.add(new Wheel(10));
        System.out.println(car.hashCode());

        wheel4.setRadius(20);
        System.out.println(car.hashCode());

        car.getWheels().add(new Wheel(10));
        System.out.println(car.hashCode());
    }
}
