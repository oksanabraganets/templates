package singleton;

public class Application {
    public static void main(String[] args){
        Singleton s = Singleton.getInstance();
        System.out.println(Singleton.count);
        Singleton s1 = Singleton.getInstance();
        System.out.println(Singleton.count);
    }
}

class Singleton{
    public static int count = 0;
    private static Singleton instance;

    private Singleton() { count++; }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}