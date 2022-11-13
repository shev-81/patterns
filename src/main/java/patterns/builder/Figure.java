package patterns.builder;

/**
 * Пример наследования!
 */

interface IFigure{
    String param();
}

public class Figure implements IFigure{
    private String color;
    private String name;

    public Figure(String color, String name) {
        this.color = color;
    }

    @Override
    public String param(){
        return "Name: " + name  + "Color :" + color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


    public static void main(String[] args) {
        
        // класс созданный при наследовани
        IFigure figure1 = new Triangle("Green", 20);
        System.out.println(figure1.param()); // полиморфный вызов метода

        // класс созданный при композиции
        Figure figure2 = new Triangle("Green", 20);
        IFigure square = new Square(figure2, 20);
        System.out.println(square.param()); // вызов метода

    }
}

/**
 * Наследование
 */
class Triangle extends Figure{

    private String name;
    private final int square;

    public Triangle(String color, int square) {
        super(color , "Triangle");
        this.square = square;
    }

    /**
     * Полиморфизм (метод ведет себя в соответствии с логикой наследника, а не супер класса)
     */
    @Override
    public String param() {
        return super.param() + " Square :" + square + " m2.";
    }
}

/**
 * Композиция
 */

class Square implements IFigure{

    private String color;
    private String name;
    private final int square;
    private int sideLength;

    /**
     * Класс унаследован от фигуры при помощи композиции.
     */
    public Square(Figure figure, int sideLength) {
        this.color = figure.getColor();
        this.name = figure.getName();;
        this.sideLength = sideLength;
        this.square = sideLength * sideLength;
    }

    @Override
    public String param() {
        return "Name: " + name + ", Color :" + color + ", Square :" + square + " m2.";
    }
}





