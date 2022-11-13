package patterns.builder;


/**
 * Недостатки реализации:
 * 1. не определен класс или интерфейс Engine.
 * 2. это поле имеет не правильный модификатор достпа public -> private
 * 3. вместо сеттеров можно использовать Builder как конструктор машины.
 * 4. методы геттеров не нужны для собранной машины так как это нарушит инкапсуляцию сложного объекта Car
 * 5. Класс LightWeightCar хорошо бы имплиментить и интерфейс  Stopable, а классу Lorry было бы здорово реализовать
 *    abstract void open();
 * 6. class Lorry extends Car, Moveable, Stopable пытается наследжоваться не только от абстрактного класса но и от интерфейсов.
 * 7. Всвязи с этим напрашивается имплементация интерфейсов в абстрактном классе а не в наследниках.
 * 8. Предлагаю следующую реализацию  ->
 */




interface Moveable {
    void move();
}
interface Stopable {
    void stop();
}

interface Engine {
    void startEngine();
}
class OldEngine implements Engine {
    @Override
    public void startEngine() {
        System.out.println("брбрбрбрб .... пффффф>");
    }
}
class NewEngine implements Engine {
    @Override
    public void startEngine() {
        System.out.println("РрррРррррРррр");
    }
}


abstract class Car implements Moveable ,Stopable{
    private Engine engine;
    private String color;
    private String name;

    public Car(BuilderCar builderCar) {
        this.engine = builderCar.engine;
        this.color = builderCar.color;
        this.name = builderCar.name;

    }

    abstract void open();

    public static BuilderCar builder(){
        return new BuilderCar();
    }

    protected void start() {
        System.out.println("Car starting");
        engine.startEngine();
    }

    public static class BuilderCar{
        private Engine engine;
        private String color;
        private String name;

        public BuilderCar setEngine(Engine engine) {
            this.engine = engine;
            return this;
        }

        public BuilderCar setColor(String color) {
            this.color = color;
            return this;
        }

        public BuilderCar setName(String name) {
            this.name = name;
            return this;
        }

        public Car build(Class <?> typeCar){
            if(typeCar.equals(LightWeightCar.class)){
                return new LightWeightCar(this);
            }
            return new Lorry(this);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine +
                ", color='" + color + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Car car = Car.builder()
                .setColor("Green")
                .setEngine(new OldEngine())
                .setName("Lorry")
                .build(Lorry.class);

        car.open();
        car.move();
        car.start();
        car.stop();

    }
}

class LightWeightCar extends Car{

    public LightWeightCar(BuilderCar builderCar) {
        super(builderCar);
    }

    @Override
    void open() {
        System.out.println("LightWeightCar is open");
    }
    @Override
    public void move() {
        System.out.println("LightWeightCar is moving");
    }

    @Override
    public void stop() {
        System.out.println("LightWeightCar is stop");
    }
}

class Lorry extends Car{

    public Lorry(BuilderCar builderCar) {
        super(builderCar);
    }

    @Override
    void open() {
        System.out.println("Lorry is open");
    }

    @Override
    public void move(){
        System.out.println("Lorry is moving");
    }
    @Override
    public void stop(){
        System.out.println("Lorry is stop");
    }
}
