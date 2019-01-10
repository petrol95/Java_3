package Lesson_5.Races;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

//public class Car implements Runnable {
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

    public void goTunnel(Semaphore smp, Tunnel tunnel) {
        try {
            try {
                System.out.println(this.name + " готовится к этапу(ждет): " + tunnel.description);
                smp.acquire();
                System.out.println(this.name + " начал этап: " + tunnel.description);
                Thread.sleep(tunnel.length / this.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(this.name + " закончил этап: " + tunnel.description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        for (int i = 0; i < race.getStages().size(); i++) {
//            if (!race.getStages().get(i).getClass().getName().equals("Lesson_5.Races.Tunnel"))
//                race.getStages().get(i).go(this);
//        }

    }

}