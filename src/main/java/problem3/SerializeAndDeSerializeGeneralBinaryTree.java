package problem3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class SerializeAndDeSerializeGeneralBinaryTree {

    private String serializedBTString;

    private BinaryTree deSerializedTree;

<<<<<<< HEAD
    private Node root;
=======
    private final String MARKER;

    private static String val;
>>>>>>> fb600eafa383c80da381aafdfa2f7de6807ded99

    public SerializeAndDeSerializeGeneralBinaryTree(){
        serializedBTString = "";
        deSerializedTree = new BinaryTree();
        val = null;
        MARKER  = "null ";

    }

    /**
     * Serialize a Binary Tree
     *
     * @param n is root of a tree that needs to be serialized
     */
    public void serializeBinaryTree(Node n){
        if(n == null){
            serializedBTString = serializedBTString + MARKER;
            return ;
        }

        serializedBTString = serializedBTString + n.val + " ";
        serializeBinaryTree(n.left);
        serializeBinaryTree(n.right);
    }

<<<<<<< HEAD
    public void setSerializedBTInFile(Node n){

        serializeBinaryTree(n);

        FileWriter fw= null;
        try {
            fw = new FileWriter("text");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read character wise from string and write
        // into FileWriter
        for (int i = 0; i < serializedBT.length(); i++) {
            try {
                fw.write(serializedBT.charAt(i));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //close the file
        try {
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Node deSerializeBinaryTree(ListIterator listIterator) {
        if (listIterator.hasNext()) {
            val = Integer.parseInt(listIterator.next().toString());
            if (val == -1) {
                return null;

            }

            root = new Node(val);
            root.setLeft(deSerializeBinaryTree(listIterator));
            root.setRight(deSerializeBinaryTree(listIterator));
        }

        return root;

    }


    public String getSerializedBT() {
        return serializedBT;
    }

    public BinaryTree getBinaryTree() {
        return binaryTree;
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.root = new Node(1);
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);

        SerializeAndDeSerializeGeneralBinaryTree testSerialize =
                new SerializeAndDeSerializeGeneralBinaryTree();
        testSerialize.setSerializedBTInFile(bt.root);
=======
    /**
     * De-Serialize Binary Tree logic
     *
     * @param root initially null
     * @param listIterator the serialized string as an iterator
     * @return the root node of deserialized binary tree
     */
    private static Node deSerializeBT(Node root, ListIterator listIterator){
        if (listIterator.hasNext()){
            val = listIterator.next().toString();
            if(val.equals("null")){
                return null;
            }
            root = new Node(Integer.parseInt(val));
            root.left = deSerializeBT(root.left, listIterator);
            root.right = deSerializeBT(root.right, listIterator);
        }
        return root;
    }

    /**
     * Wrapper over deserializedBT
     *
     * @param serializedTree serialized btree string
     * @return
     */
    public void deSerializeBinaryTree(String serializedTree){
>>>>>>> fb600eafa383c80da381aafdfa2f7de6807ded99
        List<String> list = new ArrayList<String>();
        String str []= serializedTree.split(" ");
        Collections.addAll(list, str);
        ListIterator iterator = list.listIterator();
        //BinaryTree bt = new BinaryTree();
        deSerializedTree.root = deSerializeBT(null, iterator);
    }

<<<<<<< HEAD
        BinaryTree btree = new BinaryTree();
        btree.root = testSerialize.deSerializeBinaryTree(iterator);
        System.out.println(btree);
=======
    public String getSerializedBTString() {
        return serializedBTString;
    }

    public BinaryTree getDeSerializedTree() {
        return deSerializedTree;
>>>>>>> fb600eafa383c80da381aafdfa2f7de6807ded99
    }

}
