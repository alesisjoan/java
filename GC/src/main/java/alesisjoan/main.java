package alesisjoan;

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

class Something {

    String[] strings = new String[25000];

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Something is terminated");
    }
}

public class main {

    public static void main(String[] args) {
        Something something = new Something();
        MemoryTool.instance.printUsage();
        something = null;
        System.out.println("$ Null");
        MemoryTool.instance.printUsage();
        System.gc();
        System.out.println("$ GC called");
        MemoryTool.instance.printUsage();
    }
}
