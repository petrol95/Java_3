package Lesson_7.HomeWork7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException,
            IllegalAccessException, NoSuchMethodException, InstantiationException {
        //start(TestClass.class);
        start("Tests");
    }


    private static void start(String clazzName) throws ClassNotFoundException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("Lesson_7.HomeWork7." + clazzName);
        start(clazz);
    }

    private static void start(Class<?> clazz) throws IllegalAccessException, InvocationTargetException,
            NoSuchMethodException, InstantiationException {
        Method[] methods = clazz.getDeclaredMethods();

        // count check
        int countBefore = 0;
        int countAfter = 0;
        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                countBefore++;
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                countAfter++;
            }
        }
        if (countBefore > 1 || countAfter > 1) {
            throw new RuntimeException("More than one method");
        }

        // BeforeSuite
        for (Method o : methods) {
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                o.invoke(clazz.getConstructor().newInstance());
            }
        }

        // Tests
        for (int i = 0; i < 11; i++) {
            for (Method o : methods) {
                if (o.isAnnotationPresent(Test.class)) {
                    o.invoke(clazz.getConstructor().newInstance());
                    Test annotation = o.getAnnotation(Test.class);
                    if (annotation.priority() == i) {
                        System.out.println("Test " + o.getName() + " with priority = " + annotation.priority());
                    }
                }
            }
        }

        // AfterSuite
        for (Method o : methods) {
            if (o.isAnnotationPresent(AfterSuite.class)) {
                o.invoke(clazz.getConstructor().newInstance());
            }
        }
    }
}