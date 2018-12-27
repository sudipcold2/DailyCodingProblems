package unitTest.countunivalsubtreesp8;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import problem8.BinaryTree;
import problem8.CountUnivalSubTree;
import problem8.Node;

public class UnivalSubTreeTest {

    BinaryTree binaryTree;
    CountUnivalSubTree countUnivalSubTree;


    @Before
    public void setup(){
        binaryTree = new BinaryTree();
        binaryTree.root = new Node(5);
        binaryTree.root.left = new Node(4);
        binaryTree.root.right = new Node(5);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(4);
        binaryTree.root.right.right = new Node(5);

        /**
         * Tree used for testing
         *
         *               5
         *              / \
         *            4    5
         *          /  \    \
         *         4    4    5
         *
         * No of unival sub trees  is 5
         * */

        countUnivalSubTree = new CountUnivalSubTree();
    }


    @Test
    public void testCountForSameValTrees(){
        Assert.assertEquals(5, countUnivalSubTree.countSingle(binaryTree.root));
    }

}
