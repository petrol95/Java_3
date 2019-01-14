package Lesson_6.HomeWork6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class ReturnArray4Test {

    @Parameterized.Parameters
    public static Collection<Collection<Object[]>> data() { // Collection<Object[]>
        List<List<Integer>> group = new ArrayList<>();
        group.add(Arrays.asList(1, 2, 3));
        group.add(Arrays.asList(4, 5, 6));

        return group;
    }

    private ArrayList<Integer> alIn;
    private ArrayList<Integer> alOut;


    public ReturnArray4Test(ArrayList<Integer> alIn, ArrayList<Integer> alOut) {
        this.alIn.addAll(alIn);
        this.alOut.addAll(alOut);
    }

    ReturnArray4 retArr;

    @Before
    public void init() {
        retArr = new ReturnArray4();
    }

    @Test
    public void massTestAdd() {
        Assert.assertEquals(alOut, retArr.returnArr(alIn));
    }
}
