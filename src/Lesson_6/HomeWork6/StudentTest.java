package Lesson_6.HomeWork6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {
    private Student student;

    @Before
    public void init() {
        student = new Student("student.db");
    }

    @Test
    public void test_read() {
        Assert.assertEquals(5, student.getMarkById(1));
    }

    @Test
    public void test_update() {
        Assert.assertEquals(true, student.changeMarkById(1, 4));
    }

    @Test
    public void test_insert() {
        Assert.assertEquals(true, student.insertMark("Sidorov", 3));
    }

}

