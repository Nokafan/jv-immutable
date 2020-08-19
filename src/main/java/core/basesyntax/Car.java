package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in the README file
 */
public final class Car implements Changeable, Cloneable {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        this.wheels = createWheelsCopy(wheels);
        this.engine = createEngineCopy(engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return createWheelsCopy(wheels);
    }

    public Engine getEngine() {
        return createEngineCopy(engine);
    }

    private Engine createEngineCopy(Engine engine) {
        if (engine == null) {
            return null;
        }
        return engine.clone();
    }

    private List<Wheel> createWheelsCopy(List<Wheel> wheels) {
        List<Wheel> newWheels = new ArrayList<>();
        for (Wheel wheel : wheels) {
            newWheels.add(wheel.clone());
        }
        return newWheels;
    }

    @Override
    public Car changeEngine(Engine engine) {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public Car changeColor(String newColor) {
        return new Car(year, newColor, wheels, engine);
    }

    @Override
    public Car addWheel(Wheel newWheel) {
        List<Wheel> newWheels = createWheelsCopy(wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine);
    }

    @Override
    protected Car clone() {
        return new Car(year, color, wheels, engine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year
                && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels)
                && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }
}


