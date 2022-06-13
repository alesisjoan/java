package edu.alesisjoan;

class MemoryTool {
    public static final MemoryTool instance = new MemoryTool();

    //int MB = 1024*1024;

    public void printUsage(){
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
        //Print used memory
        System.out.println("Used Memory:"
                + (runtime.totalMemory() - runtime.freeMemory()));

    }
}

class MySharedObject {

    //static variable pointing to instance of MySharedObject

    public static final MySharedObject sharedInstance = new MySharedObject();

    //member variables pointing to two objects on the heap

    String[] strings1 = new String[10000];
    String[] strings2 = new String[10000];
}

class MyRunnable implements Runnable {

    public void run() {
        System.out.println("Initial");
        MemoryTool.instance.printUsage();
        methodOne();
        System.out.println("First");
        MemoryTool.instance.printUsage();
        methodOne();
        System.out.println("Second");
        MemoryTool.instance.printUsage();
        methodOne();
        System.out.println("Third");
        MemoryTool.instance.printUsage();
        methodOne();
        System.out.println("Fourth");
        MemoryTool.instance.printUsage();
    }

    public void methodOne() {

        String[] strings = new String[25000]; // An empty String takes 40 bytes (* 25000 = 100000 bytes)
        MySharedObject localVariable2 = MySharedObject.sharedInstance;

        //... do more with local variables.

        methodTwo();
    }

    public void methodTwo() {
        Integer localVariable1 = 99;

        //... do more with local variable.
    }
}

public class main {

    public static void main(String[] args){
        MyRunnable runnable = new MyRunnable();

        runnable.run();

    }
}
