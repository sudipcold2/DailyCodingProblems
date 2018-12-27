package problem6;

import java.util.HashMap;

public class XORLinkedList {

    private Node head, tail;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    private HashMap<Integer, Node> map = new HashMap<>();

    /**
     * Insert Data at end of the XOR linked list
     *
     * @param data to be stored in the end of the list
     */
    public void addToEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            newNode.setXorOfPrevNxt(0);
            head = tail = newNode;
        }else if(head == tail){
            newNode.setXorOfPrevNxt(getPointer(null) ^ getPointer(tail));
            head.setXorOfPrevNxt(getPointer(null) ^ getPointer(newNode));
            tail = newNode;
        }
        else{
            Node prev = dereferencePointer(tail.getXorOfPrevNxt() ^ getPointer(null) );
            newNode.setXorOfPrevNxt(getPointer(null) ^ getPointer(tail));
            tail.setXorOfPrevNxt(getPointer(prev) ^ getPointer(newNode));
            tail = newNode;
        }
        map.put(getPointer(newNode), newNode);
    }

    /**
     * Get the node at a particular index starting from 0
     *
     * @param index for which the data is retrieved.
     * @return the Node at the index
     */
   public Node getNodeAtIndex(int index){
       Node prev = null;
       Node curr = head;
       Node next;
       int j = 0;

       while(curr != null) {
           if(index == j){
               return curr;
           }
           j++;
           next = dereferencePointer(getPointer(prev) ^ curr.getXorOfPrevNxt());
           prev = curr;
           curr = next;
       }
       return null;
   }

    /**
     * traverse the list in forward direction
     */
    public void traverseInForward(){
        Node prev = null;
        Node curr = head;
        Node next;

        while(curr != null){
            System.out.print(curr.data + " -> ");
            next = dereferencePointer(getPointer(prev) ^ curr.getXorOfPrevNxt());
            prev = curr;
            curr = next;
        }
        System.out.print("null ");
        System.out.println();

    }

    private int getPointer(Node node){
        return node != null ? node.hashCode() : 0;
    }

    private Node dereferencePointer(int pointer){
        if(pointer != 0){
            return map.get(pointer);
        }else{
            return null;
        }
    }

}
