package patterns.generative.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Порождающие
 * Помогает создать дублированный объект с лучшей производительностью, вместо нового создается возвращаемый клон существующего объекта. Клонирует существующий объект.
 */
public class PrototypePatern {
    public static void main(String[] args) {

        ComplicatedObject prototype = new ComplicatedObject();
        prototype.setType(ComplicatedObject.Type.ONE);

        ComplicatedObject copy = prototype.copy();
        copy.setType(ComplicatedObject.Type.TWO);

        /**
         *  В клоне тип объекта устанавливается в методе clone() как Type.THREE
         */
        ComplicatedObject clone = prototype.clone(copy);


        List<Copyable> list = new ArrayList<>();
        list.add(prototype);
        list.add(copy);
        list.add(clone);

        System.out.println(list.stream().map(Copyable::getType).collect(Collectors.joining(" ")));
        

    }
}

interface Copyable {
    Copyable copy();
    String getType();
}

class ComplicatedObject implements Copyable, Cloneable{
    private Type type;

    public enum Type {
        ONE, TWO, THREE
    }

    /**
     *  метод создающий новый объект своего же типа
     */

    public ComplicatedObject copy() {
        return new ComplicatedObject();
    }

    /**
     *  метод клонирования использует нативный метод clone() у класса Object
     */
    public ComplicatedObject clone(ComplicatedObject object){
        ComplicatedObject complicatedobject = null;
        try {
            complicatedobject = (ComplicatedObject) object.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        complicatedobject.setType(Type.THREE);
        return complicatedobject;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getType() {
        return type.toString();
    }
}
