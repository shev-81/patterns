package patterns.structure.decorator;

/**
 * Структурные.
 * Добавляет новые функциональные возможности существующего объекта без привязки его структуры.
 */

public class DecoratorPatern {

    public static void main(String[] args) {
        Car sportCar = new SportCar();
        Car blueUnknownCar = new BlueCarDecorator(new UnknownCar());
        sportCar.draw();
        System.out.println();
        blueUnknownCar.draw();
    }
}


interface Car {
    void draw();
}

class SportCar implements Car {
    public void draw() {
        System.out.println("SportCar");
    }
}

class UnknownCar implements Car {
    public void draw() {
        System.out.println("UnknownCar");
    }
}

abstract class CarDecorator implements Car {
    protected Car decoratedCar;

    public CarDecorator(Car decoratedCar) {
        this.decoratedCar = decoratedCar;
    }

    public void draw() {
        decoratedCar.draw();
    }
}

class BlueCarDecorator extends CarDecorator {

    public BlueCarDecorator(Car decorated) {
        super(decorated);
    }

    public void draw() {
        decoratedCar.draw();
        setColor();
    }

    private void setColor() {
        System.out.println("Color: red");
    }
}

