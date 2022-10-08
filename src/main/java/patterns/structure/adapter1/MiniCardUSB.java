package patterns.structure.adapter1;

public class MiniCardUSB implements Cards{

    public MiniCardUSB() {
    }

    @Override
    public void insert() {
        System.out.println("Карта памяти MiniCardUSB вставлена...");
    }

    @Override
    public void copyData() {
        System.out.println("Данные скопированны c MiniCardUSB.");
    }
}
