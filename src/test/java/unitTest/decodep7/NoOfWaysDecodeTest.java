package unitTest.decodep7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem7.NoOfWaysToDecode;

public class NoOfWaysDecodeTest {


    private char digits[];
    private int n;
    private NoOfWaysToDecode noOfWaysToDecode;

    @Before
    public void setup() throws Exception{

        digits = new char[4];

        digits[0] = '1';
        digits[1] = '2';
        digits[2] = '3';
        digits[3] = '4';

        n = digits.length;

        noOfWaysToDecode = new NoOfWaysToDecode();
    }

    @Test
    public void testNoOfWaysToDecode(){
        Assert.assertEquals(3, noOfWaysToDecode.countDecoding(digits, n));
    }

    @Test
    public void testNoOfWaysToDecodeDP(){
        Assert.assertEquals(3, noOfWaysToDecode.countDecodingDP(digits, n));
    }




}
