
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        final boolean[] eggTurn = {true};

        Thread egg = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    while (!eggTurn[0]) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    System.out.println("Яйцо");
                    eggTurn[0] = false;
                    lock.notify();
                }
            }
        });

        Thread chicken = new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 5; i++) {
                    while (eggTurn[0]) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                    System.out.println("Курица");
                    eggTurn[0] = true;
                    lock.notify();
                }
            }
        });

        egg.start();
        chicken.start();

        egg.join();
        chicken.join();
        
        System.out.println("Спор закончен!");
    }
}
