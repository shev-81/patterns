package patterns.structure.proxy;

/**
 * Представляет объекты, которые могут контролировать другие объекты перехватывая их вызовы. Можно перехватить вызов оригинального объекта.
 */

public class ProxyPatern {
    public static void main(String[] args) {
        Image image = new RealImage("test.jpg");
        Image proxyImage = new ProxyImage(image);
        image.display();
        System.out.println();
        proxyImage.display();
    }
}

interface Image {
    void display();
}

class RealImage implements Image {
    private String file;
    public RealImage(String file){
        this.file = file;
    }

    public void display() {
        System.out.println("Просмотр " + file);
    }
}

class ProxyImage implements Image {
    private Image image;
    public ProxyImage(Image image){
        this.image = image;
    }
    public void display() {
        System.out.println("Качаем файл...");
        image.display();
        System.out.println("Стираем файл из памяти...");

    }
}
