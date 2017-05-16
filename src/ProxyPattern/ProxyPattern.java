package ProxyPattern;

/**
 * Created by lovejoy on 11/05/2017.
 *
 * http://blog.csdn.net/lovelion/article/details/8227953
 * Provide a placeholder for another object to control access to it.
 */
interface Subject {
    void request();
}

class RealSubject implements Subject {
    public void request() {
        System.out.println("Do request here.");
    }
}

class Proxy implements Subject {
    private Subject subject = new RealSubject();

    public void preRequest(){
        System.out.println("Do something before request.");
    }

    public void request(){
        preRequest();
        subject.request();
        postRequest();
    }

    public void postRequest(){
        System.out.println("Do something after request.");
    }
}

class Client{
    public static void main(String args[]){
        Proxy proxy = new Proxy();
        proxy.request();
    }
}