package Lesson_5.Races;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

//    public void goTunnel(Car c, Semaphore smp) {
//        try {
//            try {

    @Override
    public void go(Car c) {

    }
//                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
//                smp.acquire();
//                System.out.println(c.getName() + " начал этап: " + description);
//                Thread.sleep(length / c.getSpeed() * 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } finally {
//                System.out.println(c.getName() + " закончил этап: " + description);
//                smp.release();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}