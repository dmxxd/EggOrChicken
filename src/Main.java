
public class Main {
    public static void main(String[] args) {
        // Поток "Яйцо"
        Thread egg = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100); // задержка для наглядности
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Яйцо");
            }
        });
        // Запускаем поток "Яйцо"
        egg.start();
        // Пока поток "Яйцо" живой, выводим "Курица"
        while (egg.isAlive()) {
            try {
                Thread.sleep(100); // чтобы чередовались
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println("Курица");
        }
        // Дожидаемся завершения потока "Яйцо"
        try {
            egg.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        // Итог спора
        System.out.println("Спор закончен!");
        if (egg.isAlive()) {
            System.out.println("Победило яйцо!");
        } else {
            System.out.println("Победила курица!");
        }
    }
}


