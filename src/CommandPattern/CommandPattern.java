package CommandPattern;

/**
 * Created by lovejoy on 16/05/2017.
 *
 * http://blog.csdn.net/lovelion/article/details/8796736
 */
class Invoker {
    private Command command;

    // Inject by constructor
    public Invoker(Command command) {
        this.command = command;
    }

    //Inject by setting value
    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        command.execute();
    }
}

class Receiver {
    public void action() {
        System.out.println("Here is the action.");
    }
}

abstract class Command {
    public abstract void execute();
}

class ConcreteCommand extends Command {
    private Receiver receiver = new Receiver();

    public void execute() {
        receiver.action();
    }
}

class Client {
    public static void main(String args[]) {
        Command c = new ConcreteCommand();
        Invoker i = new Invoker(c);
        i.call();
    }
}