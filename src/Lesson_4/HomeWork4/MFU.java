package Lesson_4.HomeWork4;

public class MFU {

    private Integer pagesNum;

    public MFU(Integer pagesNum) {
        this.pagesNum = pagesNum;
    }

    public void scan(Integer pagesNum) {
        for (int i = 0; i < pagesNum; i++) {
            System.out.println("Scanned page: " + (i + 1));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
        synchronized (pagesNum) {
            pagesNum.notifyAll();
        }
    }

    public void print(Integer pagesNum) {
        for (int i = 0; i < pagesNum; i++) {
            System.out.println("Printed page: " + (i + 1));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                return;
            }
        }
        synchronized (pagesNum) {
            pagesNum.notifyAll();
        }
    }
}
