package integrationTest.notImp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem3.BinaryTree;
import problem3.Node;
import problem3.SerializeAndDeSerializeGeneralBinaryTree;


public class BTSerializeDeSerializeTestIT {

    private BinaryTree bt;

    @Before
    public void setup() throws Exception {
        bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
    }

    @Test
    public void testSerializeAndDeSerializeBT(){
        SerializeAndDeSerializeGeneralBinaryTree testSerializeString = new SerializeAndDeSerializeGeneralBinaryTree();
        testSerializeString.serializeBinaryTree(bt.root);

        String serializedStringPrimaryTree = testSerializeString.getSerializedBTString();

        SerializeAndDeSerializeGeneralBinaryTree testDeSerializeTree = new SerializeAndDeSerializeGeneralBinaryTree();
        testDeSerializeTree.deSerializeBinaryTree(serializedStringPrimaryTree);

        SerializeAndDeSerializeGeneralBinaryTree testDeSerialize = new SerializeAndDeSerializeGeneralBinaryTree();
        testDeSerialize.serializeBinaryTree(testDeSerializeTree.getDeSerializedTree().root);

        String serializedStringFromDeSerializedTree = testDeSerialize.getSerializedBTString();

        Assert.assertEquals(serializedStringPrimaryTree, serializedStringFromDeSerializedTree);

    }

}
