package problem3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class SerializeAndDeSerializeGeneralBinaryTree {

    private String serializedBTString;

    private BinaryTree deSerializedTree;

    private final String MARKER;

    private static String val;

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
        List<String> list = new ArrayList<String>();
        String str []= serializedTree.split(" ");
        Collections.addAll(list, str);
        ListIterator iterator = list.listIterator();
        //BinaryTree bt = new BinaryTree();
        deSerializedTree.root = deSerializeBT(null, iterator);
    }

    public String getSerializedBTString() {
        return serializedBTString;
    }

    public BinaryTree getDeSerializedTree() {
        return deSerializedTree;
    }

}
