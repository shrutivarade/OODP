package edu.umb.cs680.hw03;

public class Singleton {
    private static Singleton inst = null;

    private Singleton() {
    }

    public static Singleton getInstance()
    {
        if (inst == null)
            inst = new Singleton();
        return inst;

    }

    public static void main(String[] args) {

        Singleton sng = Singleton.getInstance();
        System.out.println(sng.hashCode());
        Singleton sng1 = Singleton.getInstance();
        System.out.println(sng1.hashCode());



    }
}
