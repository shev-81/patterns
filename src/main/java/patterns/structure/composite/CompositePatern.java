package patterns.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Структурные.
 * Компоновщик!  Группирует несколько объектов в структуру используя один класс. Позволяет работать с несколькими классами через один объект.
 */

public class CompositePatern {
    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car unknownCar = new UnknownCar();
        Drawing drawing = new Drawing();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("green");
        drawing.clear();
        drawing.add(sportCar);
        drawing.add(unknownCar);
        drawing.draw("white");
    }
}

interface Car {
    void draw(String color);
}

class SportCar implements Car {
    public void draw(String color) {
        System.out.println("SportCar color: " + color);
    }
}

class UnknownCar implements Car {
    public void draw(String color) {
        System.out.println("UnknownCar color: " + color);
    }
}

class Drawing implements Car {
    private List<Car> cars = new ArrayList<>();

    public void draw(String color) {
        for (Car car : cars) {
            car.draw(color);
        }
    }

    public void add(Car s) {
        this.cars.add(s);
    }

    public void clear() {
        System.out.println();
        this.cars.clear();
    }
}


