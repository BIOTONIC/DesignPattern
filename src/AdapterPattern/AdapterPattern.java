package AdapterPattern;

/**
 * Created by lovejoy on 09/05/2017.
 */
class Adaptee {
    void specificRequest() {
        System.out.println("Response to Specific Request");
    }
}

/*
 * Both abstract class or interface are OK.
 */
abstract class Target {
    void request() {

    }
}

/*
 * In object adapter, adapter is associated with adaptee.
 * http://blog.csdn.net/lovelion/article/details/8624325
 * In class adapter, adapter extends or implements adaptee.
 * http://blog.csdn.net/lovelion/article/details/8624428
 * Here is an object adapter.
 */
class Adapter extends Target {
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    void request() {
        adaptee.specificRequest();
    }
}

class Client {
    public static void main(String args[]) {
        Adaptee adaptee = new Adaptee();
        Adapter adapter = new Adapter(adaptee);
        adapter.request();
    }
}
