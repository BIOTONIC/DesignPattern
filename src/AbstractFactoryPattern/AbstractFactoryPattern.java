package AbstractFactoryPattern;

/**
 * Created by lovejoy on 02/05/2017.
 */
abstract class AbstractProduct {
    abstract String getName();
}

abstract class AbstractProductA extends AbstractProduct {
}

abstract class AbstractProductB extends AbstractProduct {
}

class ConcreteProductA1 extends AbstractProductA {
    String getName() {
        return "Product A created by factory 1.";
    }
}

class ConcreteProductB1 extends AbstractProductB {
    String getName() {
        return "Product B created by factory 1.";
    }
}

abstract class AbstractFactory {
    abstract AbstractProductA createProductA();

    abstract AbstractProductB createProductB();
}

class ConcreteFactory1 extends AbstractFactory {
    @Override
    AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

class Client {
    public static void main(String args[]){
        AbstractFactory factory = new ConcreteFactory1();
        AbstractProduct product = factory.createProductA();
        System.out.println(product.getName());
    }
}

