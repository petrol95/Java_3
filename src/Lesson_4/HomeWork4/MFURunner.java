package Lesson_4.HomeWork4;

public class MFURunner {

    public static void main(String[] args) throws InterruptedException {
        Integer pages = 10;
        MFU mfu = new MFU(pages);
        new Thread(() -> mfu.scan(pages)).start();
        new Thread(() -> mfu.print(pages)).start();

    }
}
