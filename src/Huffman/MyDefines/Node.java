package Huffman.MyDefines;

public class Node implements Comparable<Node> {
    public Byte data;
    public int frequency;
    public Node left;
    public Node right;

    public Node(Byte data, int frequency){
        this.data=data;
        this.frequency=frequency;
    }

    @Override
    public int compareTo(Node o) {
        return this.frequency - o.frequency;
    }


}
