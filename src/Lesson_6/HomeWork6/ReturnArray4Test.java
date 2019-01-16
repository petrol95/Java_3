package Lesson_6.HomeWork6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ReturnArray4Test {
    private ReturnArray4 retArr;

    @Before
    public void init() {
        retArr = new ReturnArray4();
    }

    @Test
    public void test1() {
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Assert.assertEquals(Arrays.asList(5, 6), retArr.returnArr(res));
    }

    @Test
    public void test2() {
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(1, 2, 4, 4, 2, 3, 4, 1, 7));
        Assert.assertEquals(Arrays.asList(1, 7), retArr.returnArr(res));
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidArr() {
        ArrayList<Integer> res = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6));
        Assert.assertEquals(Arrays.asList(0), retArr.returnArr(res));
    }
}
