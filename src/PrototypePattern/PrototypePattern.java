package PrototypePattern;

/**
 * Created by lovejoy on 03/05/2017.
 */
class Prototype implements Cloneable {
    public Prototype clone(){
        Prototype prototype = null;
        try{
            prototype = (Prototype)super.clone();
        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }
}

class ConcretePrototype extends Prototype{
    public void show(){
        System.out.println("This is an implementation class of Prototype");
    }
}

class Client {
    public static void main(String args[]){
        ConcretePrototype cp = new ConcretePrototype();
        for(int i=0; i< 10; i++){
            ConcretePrototype clonecp = (ConcretePrototype)cp.clone();
            clonecp.show();
        }
    }
}