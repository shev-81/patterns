package patterns.structure.bridge;

/**
 * Структурные.   Bridge
 * Разделяет реализацию и абстракцию, дает возможность изменять их свободно друг от друга.
 * Делает конкретные классы независимыми от классов реализации интерфейса.
 */

public class BridgePatern {

    public static void main(String[] args) {
        Car sportCar = new SportCar();
        sportCar.setEngine(new SportEngine());
        sportCar.whatEngine();

        System.out.println();

        Car unknownCar = new UnknownCar();
        unknownCar.setEngine(new UnknownEngine());
        unknownCar.whatEngine();
    }
}

interface Engine {
    void setEngine(Engine engine);
}

abstract class Car implements Engine {
    protected Engine engine;

    public Car() {
    }

    @Override
    public void setEngine(Engine engine){
        this.engine = engine;
    }

    abstract public void whatEngine();
}



class SportCar extends Car {
    public SportCar() {
        super();
    }

    @Override
    public void whatEngine() {
        System.out.print(engine.toString());
    }
}

class UnknownCar extends Car {
    public UnknownCar() {
        super();
    }

    @Override
    public void whatEngine() {
        System.out.print(engine.toString());
    }
}

abstract class Engines implements Engine{
    @Override
    public void setEngine(Engine engine) {
    }
}

class SportEngine extends Engines {

    SportEngine(){
    }

    @Override
    public String toString() {
        return "SportEngine";
    }
}

class UnknownEngine extends Engines {

    public UnknownEngine() {
    }

    @Override
    public String toString() {
        return "UnknownEngine";
    }
}