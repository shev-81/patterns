package patterns.generative.multiton;

/**
 * Порождающие
 * Cоздает экземпляры класса, обеспечивает доступ к его объектам.
 */

import java.util.HashMap;
import java.util.Map;

public class MultitonPatern {
    public static void main(String[] args) {

        System.out.println(Multitone.getInstance("One"));
        System.out.println(Multitone.getInstance("two"));
        System.out.println(Multitone.getInstance("Tree"));
        System.out.println(Multitone.getInstance("One"));
        System.out.println(Multitone.getInstance("Five"));
    }
}


class Multitone {

    private static final Map<String ,Multitone> map = new HashMap();
    private static Multitone instance = null;

    public static Multitone getInstance(String key) {
        instance = map.get(key);
        if (instance == null) {
            instance = new Multitone();
            map.put(key, instance);
        }
        return instance;
    }
}

