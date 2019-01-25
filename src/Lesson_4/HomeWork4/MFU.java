package Lesson_4.HomeWork4;

public class MFU {

    private Object printMon;
    private Object scanMon;

    private final int PAGES_NUM = 10;

    public MFU() {
        printMon = new Object();
        scanMon = new Object();
    }

    public void scan() {
        synchronized (scanMon) {
            for (int i = 0; i < PAGES_NUM; i++) {
                System.out.println(Thread.currentThread().getName() + " Scanned page: " + (i + 1));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                }

            }
        }

    }

    public void print() {
        synchronized (printMon) {
            for (int i = 0; i < PAGES_NUM; i++) {
                System.out.println(Thread.currentThread().getName() + " Printed page: " + (i + 1));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

}
