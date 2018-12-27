package problem8;

public class CountUnivalSubTree {

    private Count ct = new Count();

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

    public int countSingle(Node node)
    {
        // Recursive function to count
        countSingleRec(node, ct);
        return ct.count;
    }


}
