package patterns.structure.flyweight;

/**
 * Вместо создания большого количества похожих объектов, объекты используются повторно. Экономит память.
 */

public class FlyweightPatern {
    public static void main(String[] args) {
        int rows = 5;
        Factory theFactory = new Factory(rows);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                theFactory.getFlyweight(i).report(j);
            }
            System.out.println();
        }
    }
}


class Flyweight {
    private int row;

    public Flyweight(int row) {
        this.row = row;
        System.out.println("ctor: " + this.row);
    }

    void report(int col) {
        System.out.print(" " + row + col);
    }
}

class Factory {

    private Flyweight[] pool;

    public Factory(int maxRows) {
        pool = new Flyweight[maxRows];
    }

    public Flyweight getFlyweight(int row) {
        if (pool[row] == null) {
            pool[row] = new Flyweight(row);
        }
        return pool[row];
    }
}
