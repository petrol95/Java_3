package Lesson_7.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClass {

    @MarkingAnnotation
    private int digit;

    @MarkingAnnotation(valueStr = "MyStrName")
    public void markedMethod() {
        System.out.println("markedMethod");
    }

    public void unmarkedMethod() {
        System.out.println("unmarkedMethod");
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = MyClass.class.getDeclaredMethods();
        for (Method o : methods) {
            if (o.isAnnotationPresent(MarkingAnnotation.class)) {
                System.out.println(o);
                o.invoke(new MyClass() );
                MarkingAnnotation annotation = o.getAnnotation(MarkingAnnotation.class);
                System.out.println(annotation.value1());
                System.out.println(annotation.valueStr());
            }
        }
    }
}
