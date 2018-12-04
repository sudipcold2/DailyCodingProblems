package problem3;

public class SerializeGeneralBinaryTree {

    String s = "";
    public void serializeBinaryTree(Node n){
        if(n == null){
            s = s + "-1 ";
            return ;
        }

        s = s + n.val + " ";
        serializeBinaryTree(n.left);
        serializeBinaryTree(n.right);
    }

    public String getS() {
        return s;
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        SerializeGeneralBinaryTree serializeGeneralBinaryTree = new SerializeGeneralBinaryTree();
        serializeGeneralBinaryTree.serializeBinaryTree(bt.root);
        System.out.println(serializeGeneralBinaryTree.s);
    }
}
