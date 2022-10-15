package patterns.structure.adapter1;

public class MicroCardUSB implements Cards{

    public MicroCardUSB() {
    }

    @Override
    public void insert() {
        System.out.println("Карта памяти MicroCardUSB вставлена...");
    }

    @Override
    public void copyData() {
        System.out.println("Данные скопированны c MicroCardUSB.");
    }
}
