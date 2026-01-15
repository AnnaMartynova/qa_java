import com.example.*;

public class Main {

    public static void main(String[] args) {
        try {
            // 1. Создаем реализацию
            Feline feline = new Feline();

            // 2. Внедряем зависимость в потребителей
            Lion lion = new Lion("Самец", feline);
            Lion lioness = new Lion("Самка", feline);
            Cat cat = new Cat(feline);

            // 3. Используем объекты

            System.out.println("=== Лев-самец ===");
            System.out.println("Грива: " + lion.doesHaveMane());
            System.out.println("Котят: " + lion.getKittens());
            System.out.println("Еда: " + lion.getFood());

            System.out.println("\n=== Львица ===");
            System.out.println("Грива: " + lioness.doesHaveMane());
            System.out.println("Котят: " + lioness.getKittens());
            System.out.println("Еда: " + lioness.getFood());

            System.out.println("\n=== Кот ===");
            System.out.println("Звук: " + cat.getSound());
            System.out.println("Еда: " + cat.getFood());

            System.out.println("\n=== Feline (прямой вызов) ===");
            System.out.println("Семейство: " + feline.getFamily());
            System.out.println("Котят (по умолчанию): " + feline.getKittens());
            System.out.println("Котят (5 штук): " + feline.getKittens(5));

            System.out.println("\n=== Полиморфизм через Predator ===");
            System.out.println("Еда через Predator: " + feline.eatMeat());
            System.out.println("Котят через Predator: " + feline.getKittens());

        } catch (Exception e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
    }
}

