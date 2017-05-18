package StrategyPattern;

/**
 * Created by lovejoy on 18/05/2017.
 *
 * http://blog.csdn.net/lovelion/article/details/7819136
 */
abstract class AbstractStrategy {
    public abstract void algorithm();
}

class ConcreteStrategyA extends AbstractStrategy {
    public void algorithm() {
        System.out.println("This is algorithm A");
    }
}

class ConcreteStrategyB extends AbstractStrategy {
    public void algorithm() {
        System.out.println("This is algorithm B");
    }
}

class Context {
    private AbstractStrategy strategy;

    public void setStrategy(AbstractStrategy strategy) {
        this.strategy= strategy;
    }

    public void algorithm() {
        strategy.algorithm();
    }
}

class Client {
    public static void main(String args[]){
        Context context = new Context();
        AbstractStrategy strategy = new ConcreteStrategyA();
        context.setStrategy(strategy);
        context.algorithm();
    }
}