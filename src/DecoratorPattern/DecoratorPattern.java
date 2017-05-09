package DecoratorPattern;

/**
 * Created by lovejoy on 09/05/2017.
 */
interface Component {
    void operation();
}

class ConcreteComponent implements Component {
    public void operation() {
        System.out.println("Concrete Operation");
    }
}

class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    public void operation() {
        component.operation();
    }
}

class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    public void operation() {
        super.operation();
        addedBehavior();
    }

    public void addedBehavior() {
        System.out.println("Added Behavior");
    }
}

/*
 * If there are many different concrete operations and added behaviors,
 * there is no need to generate a class for any two attributes,
 * because we can use decorator pattern to bind two attributes dynamically.
 */
class Client {
    public static void main(String args[]) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }
}