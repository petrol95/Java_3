package Lesson_7.reflection;

import java.lang.reflect.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main7 {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, NoSuchFieldException,
            NoSuchMethodException, InvocationTargetException, InstantiationException {

//        String str = "Java";
//        Class<? extends String> clazz = String.class;
//        Class<?> clazz = Class.forName("java.lang.String");

        Cat cat = new Cat("Barsik", "black", 4);
        Class<? extends Cat> clazz = cat.getClass();

        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());

        int modifiers = clazz.getModifiers();
        if (Modifier.isPublic(modifiers)) {
            System.out.println(clazz.getName() + " - Public");
        }
        if (Modifier.isAbstract(modifiers)) {
            System.out.println(clazz.getName() + " - Abstract");
        }
        if (Modifier.isFinal(modifiers)) {
            System.out.println(clazz.getName() + " - Final");
        }

        System.out.println();
        System.out.println("Superclasses:");
        showAllSuperclasses(clazz);

        System.out.println();
        System.out.println("Interfaces:");
        for (Class<?> arg : clazz.getInterfaces()) {
            System.out.println(arg);
        }

        System.out.println();
        System.out.println("Fields:");
//        Field[] fields = clazz.getFields();

        Field ageField = clazz.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(cat, 15);

        Field cattyField = clazz.getDeclaredField("catty");
        cattyField.setAccessible(true);
        cattyField.set(cat, false);

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            System.out.println(field.getName() + " = " + field.get(cat));
        }

        System.out.println();
        System.out.println("Methods:");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(String.format("%s %s %s(%s)",
                    getModifier(method.getModifiers()),
                    method.getReturnType().getSimpleName(),
                    method.getName(),
                    getParamsAsString(method.getParameters())));
        }

        Method meowMethod = clazz.getDeclaredMethod("meow", int.class);
        meowMethod.invoke(cat,45);

        Method jumpMethod = clazz.getDeclaredMethod("jump");
        jumpMethod.setAccessible(true);
        jumpMethod.invoke(cat);


        System.out.println("Constructors:");
        System.out.println();

        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            System.out.println(String.format("%s %s (%s)",
                    getModifier(constructor.getModifiers()),
                    constructor.getName(),
                    getParamsAsString(constructor.getParameterTypes())));
        }

        Cat markiz = clazz.getConstructor(String.class, int.class).newInstance("Markiz", 7);
        System.out.println(markiz);

    }

    private static String getParamsAsString(Parameter[] parameters) {
        return Stream.of(parameters)
                .map(parameter -> {
                    return String.format("%s %s",
                            parameter.getType().getSimpleName(),
                            parameter.getName());
                })
                .collect(Collectors.joining(", "));
    }


    private static String getParamsAsString(Class<?>[] parameters) {
        return Stream.of(parameters)
                .map(parameter -> {
                    return String.format("%s",
                            parameter.getSimpleName());
                })
                .collect(Collectors.joining(", "));
    }

    private static void showAllSuperclasses(Class<?> clazz) {
        if (clazz != null) {
            System.out.println(clazz.getSimpleName());
            showAllSuperclasses(clazz.getSuperclass());
        }
    }

    private static String getModifier(int modifiers) {
        if (Modifier.isPublic(modifiers)) {
            return "Public";
        }
        if (Modifier.isPrivate(modifiers)) {
            return "Private";
        }
        return "";
    }
}
