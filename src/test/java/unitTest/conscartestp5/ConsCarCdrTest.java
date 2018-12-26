package unitTest.conscartestp5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem5.Car;
import problem5.Cdr;
import problem5.Cons;

public class ConsCarCdrTest {

    private Car<Object> car;
    private Cdr<Object> cdr;
    private Cons<Object> consInt;
    private Cons<Object> consString;

    @Before
    public void setup() throws Exception{
        car = new Car<Object>();
        cdr = new Cdr<Object>();

        consInt = new Cons<Object>(1,2);
        consString = new Cons<Object>("Sudip", "Ghosh");
    }

    @Test
    public void testConsInt(){
        Assert.assertEquals(1, car.car(consInt));
        Assert.assertEquals(2, cdr.cdr(consInt));
    }

    public void testConsString(){
        Assert.assertEquals("Sudip", car.car(consString));
        Assert.assertEquals("Ghosh", cdr.cdr(consString));
    }

}
