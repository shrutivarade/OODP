package edu.umb.cs680.hw03;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance()
    {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    public static void main(String[] args) {
        Singleton inst = Singleton.getInstance();
        System.out.println(inst.hashCode());
        System.out.println(inst);
        Singleton inst1 = Singleton.getInstance();
        System.out.println(inst1.hashCode());
        System.out.println(inst1);

    }
}
