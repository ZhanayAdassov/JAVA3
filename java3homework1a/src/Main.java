public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        Apple a1 = new Apple();
        Apple a2 = new Apple();
        Apple a3 = new Apple();
        Orange o1 = new Orange();
        Orange o2 = new Orange();
        System.out.println("вес 1 яблока: " + a1.getWeight());
        System.out.println("1 апельсин весит: " + o1.getWeight() + "\n");

        System.out.println("Добавить  3 яблока и 2 апельсина.");

        appleBox1.addFruit(a1);
        appleBox1.addFruit(a2);
        appleBox1.addFruit(a3);
        orangeBox2.addFruit(o1);
        orangeBox2.addFruit(o2);

        System.out.println("\nвес яблоко Box1 составляет: " + appleBox1.getWeight());
        System.out.println("вес апельсин Box2: " + orangeBox2.getWeight());

        System.out.println("Сравнение веса: " + appleBox1.compare(orangeBox2) + "\n");

        Box<Apple> appleBox2 = new Box<Apple>();

        System.out.println("Вес Apple Box до замены: ");
        System.out.println("вес яблоко Box1: " + appleBox1.getWeight());
        System.out.println("вес яблоко Box2: " + appleBox2.getWeight());
        System.out.println("\nЗамена  яблоко Box1 -> яблоко Box2\n");
        appleBox1.replaceAllFruitsToOtherBox(appleBox2);
        System.out.println("Вес ящиков яблок после замены: ");
        System.out.println("вес яблоко Box1: " + appleBox1.getWeight());
        System.out.println("вес яблоко Box2: " + appleBox2.getWeight());
    }
}