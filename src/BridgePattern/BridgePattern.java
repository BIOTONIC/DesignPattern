package BridgePattern;

/**
 * Created by lovejoy on 09/05/2017.
 * http://blog.csdn.net/lovelion/article/details/7464204
 */
interface Implementor {
    void operationImpl();
}

abstract class Abstraction {
    protected Implementor impl;

    public void setImpl(Implementor impl) {
        this.impl = impl;
    }

    public abstract void operation();
}

class RefinedAbstraction extends Abstraction {
    public void operation() {
        impl.operationImpl();
    }
}

class ConcreteImplementor implements Implementor {
    public void operationImpl() {
        System.out.println("This is the concrete implementor.");
    }
}

class Client {
    public static void main(String args[]) {
        Implementor impl = new ConcreteImplementor();
        Abstraction ab = new RefinedAbstraction();
        ab.setImpl(impl);
        ab.operation();
    }
}