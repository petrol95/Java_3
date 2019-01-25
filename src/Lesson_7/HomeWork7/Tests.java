package Lesson_7.HomeWork7;

public class Tests {

    @Test(priority = 10)
    public void testMethod1() {
    }

    @Test(priority = 2)
    public void testMethod2() {
    }

    @Test(priority = 4)
    public void testMethod3() {
    }

    @BeforeSuite()
    public void firstMethod() {
        System.out.println("firstMethod");
    }

//    @BeforeSuite()
//    public void firstMethod2() {
//        System.out.println("firstMethod2");
//    }

    @AfterSuite()
    public void lastMethod() {
        System.out.println("lastMethod");
    }

}
