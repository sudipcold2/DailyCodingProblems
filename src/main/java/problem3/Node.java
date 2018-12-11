package problem3;

public class Node {

    int val;
    Node left,right;

    public Node(int key){
        this.val = key;
        left = right = null;
    }


    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

}
