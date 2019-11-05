package by.mironenka.recursion;

public class Recursion {


    public static void print(int i) {
        System.out.println(i);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (i <= 0) {  //basic case
            return;
        } else {
            print(i - 1); //recursive case
        }
    }

    public static void greet(String name) {
        System.out.println("Hello " + name);
        greetTwo(name);
        System.out.println("Getting ready to say bye ...");
        bye();
    }

    private static void bye() {
        System.out.println("Ok, bye");
    }

    private static void greetTwo(String name) {
        System.out.println("How are you " + name);
    }

    public static void main(String[] args) {

//        print(10);
        greet("Mike");
    }
}
