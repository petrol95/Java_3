package Lesson_6.HomeWork6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckArrayTest {
    private CheckArray checkArray;

    @Before
    public void init() {
        checkArray = new CheckArray();
    }

    @Test
    public void test1() {
        Assert.assertEquals(true, checkArray.checkArr(new ArrayList<>(Arrays.asList(1, 2, 4, 7))));
    }

    @Test
    public void test2() {
        Assert.assertEquals(true, checkArray.checkArr(new ArrayList<>(Arrays.asList(1, 2, 5, 7))));
    }

    @Test
    public void test3() {
        Assert.assertEquals(false, checkArray.checkArr(new ArrayList<>(Arrays.asList(3, 2, 8, 9, 7))));
    }

}
