package problem8;

public class BinaryTree {

    public Node root;

    public BinaryTree(int val){
        this.root = new Node(val);
    }

    public BinaryTree(){
        root = null;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
