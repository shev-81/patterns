package patterns.behavioral.templatemethod;

/**
 * Template Method (Шаблонный метод)
 * Позволяет определить основу алгоритма и позволяющий подклассам переопределять определенные шаги алгоритма, не изменяя его структуру в целом.
 */
public class TemplateMethodPatern {
    public static void main(String[] args) {
        Car car1 = new OneCar();
        car1.start();
        System.out.println();
        Car car2 = new TwoCar();
        car2.start();
    }
}

abstract class Car {
    abstract void startEngine();

    abstract void stopEngine();

    public final void start() {
        startEngine();
        stopEngine();
    }
}

class OneCar extends Car {
    public void startEngine() {
        System.out.println("Start engine.");
    }

    public void stopEngine() {
        System.out.println("Stop engine.");
    }
}

class TwoCar extends Car {
    public void startEngine() {
        System.out.println("Start engine.");
    }

    public void stopEngine() {
        System.out.println("Stop engine.");
    }
}
