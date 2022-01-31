import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        System.out.println("Новый массив:");
        Mas<?> m = new Mas<>(new Cat(), new Dog());
        m.info();

        System.out.println("\nОбмен элементами массива:");
        m.masElementsExchange();
        m.info();

        System.out.println("\nМассив ArrayList:");
        ArrayList<?> list = m.arrayToArrayList();
        for (Object o : list) System.out.println(o.getClass().getName());
    }
}