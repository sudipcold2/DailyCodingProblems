package problem6;

public class Node {

    int data;
    int xorOfPrevNxt;

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getXorOfPrevNxt() {
        return xorOfPrevNxt;
    }

    public void setXorOfPrevNxt(int xorOfPrevNxt) {
        this.xorOfPrevNxt = xorOfPrevNxt;
    }
}
