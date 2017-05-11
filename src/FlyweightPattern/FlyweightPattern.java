package FlyweightPattern;

import java.util.HashMap;

/**
 * Created by lovejoy on 11/05/2017.
 * <p>
 * http://blog.csdn.net/lovelion/article/details/7667781
 * Flyweight pattern: reuse one object instance, share the same physical memory.
 */
class FlyweightFactory {
    private HashMap flyweightPool = new HashMap();

    public Flyweight getFlyweight(String key) {
        if (flyweightPool.containsKey(key)) {
            return (Flyweight) flyweightPool.get(key);
        } else if (key == "A") {
            Flyweight fw = new ConcreteFlyweightA("FW");
            flyweightPool.put("A", fw);
            return fw;
        } else if (key == "B") {
            Flyweight fw = new ConcreteFlyweightB("FW");
            flyweightPool.put("B", fw);
            return fw;
        } else {
            return null;
        }
    }
}

abstract class Flyweight {
    // The intrinsic state of one flyweight object is the same
    private String intrinsicState;

    public Flyweight(String intrinsicState) {
        this.intrinsicState = intrinsicState;
    }

    // The extrinsic states of different objects are not the same
    // and they will not be stored in flyweight class.
    public void operation() {
        System.out.println("Intrinsic state is: " + intrinsicState);
        System.out.println("Extrinsic state is: " + getExtrinsicState());
    }

    abstract String getExtrinsicState();
}

class ConcreteFlyweightA extends Flyweight {
    public ConcreteFlyweightA(String intrinsicState) {
        super(intrinsicState);
    }

    public String getExtrinsicState() {
        return "A";
    }
}

class ConcreteFlyweightB extends Flyweight {
    public ConcreteFlyweightB(String intrinsicState) {
        super(intrinsicState);
    }

    public String getExtrinsicState() {
        return "B";
    }
}

class Client {
    public static void main(String args[]){
        FlyweightFactory fwFactory = new FlyweightFactory();
        Flyweight fw1 = fwFactory.getFlyweight("A");
        Flyweight fw2 = fwFactory.getFlyweight("B");
        fw1.operation();
        fw2.operation();
    }
}