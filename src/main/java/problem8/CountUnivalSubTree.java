package problem8;

public class CountUnivalSubTree {

    private Count ct = new Count();

    /**
     * Taverse the tree in bottom up manner. For every subtree visited,
     * return true if subtree rooted under it is single valued and increment count.
     * So the idea is to use count as a reference parameter in recursive calls and
     * use returned values to find out if left and right subtrees are single valued or not.
     *
     * PostOrder
     * @param node root node for which the tree is to b checked
     * @param c count parameter
     * @return true or false and recurse
     */
    boolean countSingleRec(Node node, Count c){
        if(node == null){
            return true;
        }

        boolean left = countSingleRec(node.left, c);
        boolean right = countSingleRec(node.right, c);

        if(left == false || right == false){
            return false;
        }

        if(node.left != null && node.val != node.left.val){
            return false;
        }

        if(node.right != null && node.val != node.right.val){
            return false;
        }

        c.count++;
        return true;
    }

    /**
     * Count no of unival sub trees
     *
     * @param node Root node for which the tree is to b checked
     * @return the count of unival sub trees
     */
    public int countSingle(Node node)
    {
        // Recursive function to count
        countSingleRec(node, ct);
        return ct.count;
    }


}
