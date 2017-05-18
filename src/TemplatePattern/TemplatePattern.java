package TemplatePattern;

/**
 * Created by lovejoy on 18/05/2017.
 *
 * http://blog.csdn.net/lovelion/article/details/8299794
 */
abstract class AbstractClass {
    void TemplateMethod() {
        MethodBefore();
        ConcreteMethodA();
        ConcreteMethodB();
        MethodAfter();
    }

    void MethodBefore() {
        System.out.println("Before");
    }

    void MethodAfter() {
        System.out.println("After");
    }

    abstract void ConcreteMethodA();

    abstract void ConcreteMethodB();
}

class ConcreteClass extends AbstractClass {

    @Override
    void ConcreteMethodA() {
        System.out.println("Concrete Method A");
    }

    @Override
    void ConcreteMethodB() {
        System.out.println("Concrete Method B");
    }
}

class Client {
    public static void main(String args[]){
        AbstractClass c = new ConcreteClass();
        c.TemplateMethod();
    }
}