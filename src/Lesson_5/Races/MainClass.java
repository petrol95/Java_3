package Lesson_5.Races;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class MainClass {
    public static final int CARS_COUNT = 4 ;

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Tunnel tunnel = new Tunnel();
        Race race = new Race( new Road(60), tunnel, new Road(40));
        Car[] cars = new Car[CARS_COUNT];

        for (int j = 0; j < cars.length; j++) {
            cars[j] = new Car(race, 20 + (int)(Math.random() * 10));
        }



//        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");



        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);
        for (int i = 0; i < CARS_COUNT; i++) {
//            final int w = i;
            new Thread(() -> {
                try {

                    CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);

                    for (int j = 0; j < cars.length; j++) {
                        final int w = j;
                        new Thread(() -> {
                            cars[w].runCar(cb);
                        }).start();

                    }




//                    // Tunnel
//                    Semaphore smp = new Semaphore(CARS_COUNT / 2);
//                    for (int j = 0; j < cars.length; j++) {
//                        final int v = j;
//                        new Thread(() -> {
//                            cars[v].goTunnel(smp, tunnel);
//                        }).start();
//
//                    }

                    Thread.sleep( 500 + ( int )( 500 * Math.random()));
                    cdl.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}