package Lesson_5.Races;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car {
    private static int CARS_COUNT;

    static {
        CARS_COUNT = 0 ;
    }
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public void runCar(CyclicBarrier cb) {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goCar(Semaphore smp, AtomicBoolean winner) {
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this, smp);
        }
        if (!winner.get()) {
            winner.set(true);
            System.out.println(this.name + " выиграл!!!");
        }
    }
}