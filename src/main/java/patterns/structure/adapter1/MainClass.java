package patterns.structure.adapter1;

/**
 * Структурные
 * Используя паттерн, мы можем объединить два несовместимых объекта. Конвертер между двумя несовместимыми объектами.
 */

public class MainClass {
    public static void main(String[] args) {

        USB adapter1 = new AdapterCards(new MicroCardUSB());
        adapter1.connectCart();

        USB adapter2 = new AdapterCards(new MiniCardUSB());
        adapter2.connectCart();

    }
}
