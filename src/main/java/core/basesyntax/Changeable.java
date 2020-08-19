package core.basesyntax;

public interface Changeable {
    Car changeEngine(Engine engine);

    Car changeColor(String newColor);

    Car addWheel(Wheel newWheel);
}
