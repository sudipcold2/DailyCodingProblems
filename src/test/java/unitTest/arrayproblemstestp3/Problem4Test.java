package unitTest.arrayproblemstestp3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem4.MissingPositiveIntegerInArray;

public class Problem4Test {

    int array [];
    MissingPositiveIntegerInArray missingSmallestPositiveInteger;

    @Before
    public void setup() throws Exception {
        array = new int[4];
        missingSmallestPositiveInteger= new MissingPositiveIntegerInArray();

        array[0] =  1;
        array[1] = -2;
        array[2] =  3;
        array[3] =  4;

    }

    @Test
    public void testPositiveMissingInteger(){
        Assert.assertEquals(2,missingSmallestPositiveInteger.findMissingNumber(array));


    }






}
