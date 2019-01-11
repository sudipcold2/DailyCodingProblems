package unitTest.maxadjacentsump9;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem9.MaxSumNonAdjcArray;

public class MaxSumOfAdjacentNumbers {

    private int array[];
    private MaxSumNonAdjcArray maxSumNonAdjc;

    @Before
    public void setup(){
        int a[] = {1,2,3,4,-3,-2};
        array = a;
        maxSumNonAdjc = new MaxSumNonAdjcArray();
    }

    @Test
    public void testMaxSumValueOfAdjacentInArray(){
        Assert.assertEquals(6, maxSumNonAdjc.maxSum(array, array.length));
    }


}
