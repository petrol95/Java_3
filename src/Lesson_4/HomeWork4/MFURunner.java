package Lesson_4.HomeWork4;

public class MFURunner {

    public static void main(String[] args) {
        MFU mfu = new MFU();

        new Thread (() -> mfu.scan()).start();
        new Thread (() -> mfu.scan()).start();
        new Thread (() -> mfu.print()).start();

    }
}
