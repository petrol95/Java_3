package Lesson_5.Races;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainClass {
    public static final int CARS_COUNT = 4 ;

    public static void main(String[] args) {

        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");

        Tunnel tunnel = new Tunnel();
        Race race = new Race(new Road(60), tunnel, new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        AtomicBoolean winner = new AtomicBoolean();
        winner.set(false);

        for (int j = 0; j < cars.length; j++) {
            cars[j] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        CyclicBarrier cb = new CyclicBarrier(CARS_COUNT);
        Semaphore smp = new Semaphore(CARS_COUNT / 2);

        final CountDownLatch cdl = new CountDownLatch(CARS_COUNT);

        for (int j = 0; j < cars.length; j++) {
            final int w = j;
            new Thread(() -> {
                try {
                    cars[w].runCar(cb);
                    cdl.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");


        final CountDownLatch cdl2 = new CountDownLatch(CARS_COUNT);

        for (int j = 0; j < cars.length; j++) {
            final int w = j;
            new Thread(() -> {
                try {
                    cars[w].goCar(smp, winner);
                    cdl2.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        try {
            cdl2.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

}