package patterns.generative.factory;

/**
 * Порождающие
 * Используется, когда у нас есть суперкласс с несколькими подклассами и на основе ввода, нам нужно вернуть один из подкласса.
 * Класс не знает какого типа объект он должен создать. Объекты создаются в зависимости от входящих данных.
 */

public class FactoryPatern {

    public static void main(String[] args) {
        String win = "windows";
        Factory factory = new Factory();
        OS os = factory.getCurrentOS(win);
        os.getOS();
    }
}

class Factory {
    public OS getCurrentOS(String inputos) {
        OS os = null;
        if (inputos.equals("windows")) {
            os = new windowsOS();
        } else if (inputos.equals("linux")) {
            os = new linuxOS();
        } else if (inputos.equals("mac")) {
            os = new macOS();
        }
        return os;
    }
}

interface OS {
    void getOS();
}

class windowsOS implements OS {
    public void getOS() {
        System.out.println("применить для виндовс");
    }
}

class linuxOS implements OS {
    public void getOS() {
        System.out.println("применить для линукс");
    }
}

class macOS implements OS {
    public void getOS() {
        System.out.println("применить для мак");
    }
}
