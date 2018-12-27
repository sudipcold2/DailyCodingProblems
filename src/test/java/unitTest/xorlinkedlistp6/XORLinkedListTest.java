package unitTest.xorlinkedlistp6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem6.XORLinkedList;

public class XORLinkedListTest {

    private XORLinkedList xorLinkedList = new XORLinkedList();
    private int index;

    @Before
    public void setup(){

        xorLinkedList.addToEnd(1);
        xorLinkedList.addToEnd(2);
        xorLinkedList.addToEnd(3);
        index = 1;
    }

    @Test
    public void testElementAtAnIndex(){
        Assert.assertEquals(2,xorLinkedList.getNodeAtIndex(index).getData());
    }

}
