package com.example.designpatterns.creational;

public class Singleton {
}

class EagerSingleton {
    // create an instance of the class.
    private static EagerSingleton instance = new EagerSingleton();

    // private constructor, so it cannot be instantiated outside this class.
    private EagerSingleton() {  }

    // get the only instance of the object created.
    public static EagerSingleton getInstance() {
        return instance;
    }
}































class LazySingleton {
    // initialize the instance as null.
    private static LazySingleton instance = null;

    // private constructor, so it cannot be instantiated outside this class.
    private LazySingleton() {  }

    // check if the instance is null, and if so, create the object.
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}






































class ThreadSafeSingleton {
    // initialize the instance as null.
    private static ThreadSafeSingleton instance = null;

    // private constructor, so it cannot be instantiated outside this class.
    private ThreadSafeSingleton() {  }

    // check if the instance is null, within a synchronized block. If so, create the object
    public static ThreadSafeSingleton getInstance() {
        synchronized (ThreadSafeSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }
        }
        return instance;
    }
































    public static ThreadSafeSingleton getInstanceDoubleLocking() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
