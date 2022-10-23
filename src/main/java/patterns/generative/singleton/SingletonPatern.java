package patterns.generative.singleton;

/**
 * Порождающие
 * Ограничивает создание одного экземпляра класса, обеспечивает доступ к его единственному объекту. Конструктор класса приватный. Метод getInstance() создает только один экземпляр класса.
 */

public class SingletonPatern {
    public static void main(String[] args) {
        Singleton singelton = Singleton.getInstance();
        singelton.setUp();
    }
}

class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void setUp() {
        System.out.println("setUp");
    }
}