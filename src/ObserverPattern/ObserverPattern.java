package ObserverPattern;

import java.util.ArrayList;

/**
 * Created by lovejoy on 16/05/2017.
 * <p>
 * http://blog.csdn.net/lovelion/article/details/7720382
 */
abstract class Observer {
    private String name;

    public Observer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void update();
}

class ConcreteObserver extends Observer {
    public ConcreteObserver(String name) {
        super(name);
    }

    public void update() {
        System.out.println(getName() + ": Something new happened?");
    }
}

abstract class Subject {
    protected ArrayList<Observer> observers = new ArrayList();

    public void attach(Observer observer) {
        System.out.println("Add " + observer.getName());
        observers.add(observer);
    }

    public void detach(Observer observer) {
        System.out.println("Remove " + observer.getName());
        observers.remove(observer);
    }

    public abstract void notice();
}

class ConcreteSubject extends Subject {
    public void notice() {
        for (Object obs : observers) {
            ((Observer) obs).update();
        }
    }
}

class Client {
    public static void main(String args[]) {
        Subject s = new ConcreteSubject();

        Observer o1 = new ConcreteObserver("Achan");
        Observer o2 = new ConcreteObserver("Kashiyuka");
        Observer o3 = new ConcreteObserver("Nocchi");

        s.attach(o1);
        s.attach(o2);
        s.attach(o3);

        s.notice();
    }
}