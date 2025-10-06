
public class Main {
    public static void main(String[] args) {
        // Последовательный (однопоточный) вывод
        for (int i = 0; i < 5; i++) {
            System.out.println("Яйцо");
            try {
                Thread.sleep(100); // просто задержка для наглядности
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Курица");
        }

        // Итог спора
        System.out.println("Спор закончен!");
        System.out.println("Победила курица!");
    }
}
