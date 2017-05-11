package FacadePattern;

/**
 * Created by lovejoy on 11/05/2017.
 *
 * Facade pattern provide a unified interface to a set of interfaces in a subsystem.
 * Facade defines a higher-level interface that make the subsystem easier to use.
 */
class SubSystemA
{
    public void MethodA()
    {
        System.out.println("A");
    }
}

class SubSystemB
{
    public void MethodB()
    {
        System.out.println("B");
    }
}

class SubSystemC
{
    public void MethodC()
    {
        System.out.println("C");
    }
}

class Facade
{
    private SubSystemA obj1 = new SubSystemA();
    private SubSystemB obj2 = new SubSystemB();
    private SubSystemC obj3 = new SubSystemC();

    public void Method()
    {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
    }
}

class Client
{
    public static void main(String[] args)
    {
        Facade facade = new Facade();
        facade.Method();
    }
}