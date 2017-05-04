package SingletonPattern;

/**
 * Created by lovejoy on 03/05/2017.
 */
class EagerSingleton {
    /*
     * Notice that instance is initialized at first.
     * And the constructor method is private.
     */
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}

class LazySingleton {
    /*
     * Notice that initialization of instance is postponed.
     * Use synchronized to make thread safety.
     * Double-Check Locking: http://blog.csdn.net/lovelion/article/details/7420886
     */
    private volatile static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance != null) {
            synchronized (LazySingleton.class) {
                if (instance != null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}

class IoDHSingleton {
    /*
     * http://blog.csdn.net/lovelion/article/details/7420888
     */
    private IoDHSingleton() {
    }

    private static class HolderClass {
        private final static IoDHSingleton instance = new IoDHSingleton();
    }

    public static IoDHSingleton getInstance() {
        return HolderClass.instance;
    }
}
