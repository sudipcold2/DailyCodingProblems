package problem3;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class SerializeAndDeSerializeGeneralBinaryTree {

    private String serializedBT;

    private BinaryTree binaryTree;

    private final String MARKER = "-1 ";

    private int val;



    public SerializeAndDeSerializeGeneralBinaryTree(){
        serializedBT = "";
        binaryTree = new BinaryTree();
        val = 0;

    }

    /**
     * Serialize a Binary Tree
     * @param n is root of a tree that needs to be serialized
     */
    private void serializeBinaryTree(Node n){
        if(n == null){
            serializedBT = serializedBT + MARKER;
            return ;
        }

        serializedBT = serializedBT + n.val + " ";
        serializeBinaryTree(n.left);
        serializeBinaryTree(n.right);
    }

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

    public void deSerializeBinaryTree(Node root, ListIterator listIterator){
        if (listIterator.hasNext()){
            val = Integer.parseInt(listIterator.next().toString());
            if(val == -1){
                return ;

            }else{
                root = new Node(val);
                deSerializeBinaryTree(root.left, listIterator);
                deSerializeBinaryTree(root.right, listIterator);
            }
        }
    }

//    public void deSerializeBinaryTreeWrapper(ListIterator listIterator){
//        binaryTree.root = deSerializeBinaryTree(binaryTree.root, listIterator);
//    }

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
        //testSerialize.serializeBinaryTree(bt.root);
        //System.out.println(testSerialize.serializedBT);
        testSerialize.setSerializedBTInFile(bt.root);
        List<String> list = new ArrayList<String>();
        String str []= testSerialize.serializedBT.split(" ");
        for(String s : str){
            list.add(s);
        }

        ListIterator iterator = list.listIterator();

        // Traversing the list in forward direction
        System.out.println("Displaying list elements in forward direction : ");

//        while (iterator.hasNext())
//            System.out.print(iterator.next() + " ");

 //       System.out.println();
//
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.hasNext());

        testSerialize.deSerializeBinaryTree(null, iterator);
        System.out.println(testSerialize.binaryTree.toString());

    }
}
