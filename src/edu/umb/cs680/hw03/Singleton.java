package edu.umb.cs680.hw03;

public class Singleton {
    private static Singleton s_inst = null;

    private Singleton() {
    }

    public static Singleton getInstance()
    {
        if (s_inst == null)
            s_inst = new Singleton();
        return s_inst;
    }

    public static void main(String[] args) {
        Singleton sng = new Singleton();
    }
}
