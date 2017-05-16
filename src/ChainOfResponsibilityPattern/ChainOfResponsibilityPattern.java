package ChainOfResponsibilityPattern;

/**
 * Created by lovejoy on 11/05/2017.
 */
abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(String request);
}

class ConcreteHandlerA extends Handler {
    public void handleRequest(String request) {
        if (request.compareTo("k") < 0) {
            System.out.println("ConcreteHandlerA: " + request + " is before k");
        } else {
            this.successor.handleRequest(request);
        }
    }
}

class ConcreteHandlerB extends Handler {
    public void handleRequest(String request) {
        if (request.compareTo("n") < 0) {
            System.out.println("ConcreteHandlerB: " + request + " is before n");
        } else {
            this.successor.handleRequest(request);
        }
    }
}

class ConcreteHandlerC extends Handler {
    public void handleRequest(String request) {
        if (request.compareTo("n")>=0) {
            System.out.println("ConcreteHandlerB: " + request + " is after n");
        } else {
            this.successor.handleRequest(request);
        }
    }
}

class Client{
    public static void main(String args[]){
        Handler h1,h2,h3;
        h1 = new ConcreteHandlerA();
        h2 = new ConcreteHandlerB();
        h3 = new ConcreteHandlerC();

        h1.setSuccessor(h2);
        h2.setSuccessor(h3);

        h1.handleRequest("achan");
        h1.handleRequest("kashiyuka");
        h1.handleRequest("nocchi");
    }
}