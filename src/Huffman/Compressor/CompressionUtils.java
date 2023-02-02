package Huffman.Compressor;

import Huffman.MyDefines.Container;
import Huffman.MyDefines.MinPriorityQueue;
import Huffman.MyDefines.Node;

import java.util.HashMap;
import java.util.Map;

public class CompressionUtils implements ICompressionUtils{
    @Override
    public Node createHuffmanTree(byte[] fileData) {


        Map<Byte,Integer> freq=new HashMap<>();
        for (byte b : fileData) {
            Integer value = freq.get(b);
            if (value == null)
                freq.put(b, 1);
            else
                freq.put(b, value + 1);
        }

        MinPriorityQueue<Node> pq=new MinPriorityQueue<>();
        //adding freq in Min Heap Priority queue

        for (Map.Entry<Byte,Integer> entry:freq.entrySet()){
            pq.add(new Node(entry.getKey(),entry.getValue()));
        }


        //create tree using pq
        while (pq.len()>1){
            Node left=pq.poll();
            Node right=pq.poll();

            Node parent=new Node(null,left.frequency+right.frequency);
            parent.left=left;
            parent.right=right;
            pq.add(parent);

        }

        return pq.poll();
    }

    @Override
    public void buildLookupRecursive(Node root, String s, Map<Byte, String> lookupMap) {
        if (root.left!=null && root.right!=null){
            buildLookupRecursive(root.left,s+"0",lookupMap);
            buildLookupRecursive(root.right,s+"1",lookupMap);

        }else{
            if (s==""){
                 lookupMap.put(root.data,"1");
            }else lookupMap.put(root.data,s);
        }
    }

    @Override
    public Container createCompressedArray(byte[] fileData, Map<Byte, String> lookupMap) {

        StringBuilder sb = new StringBuilder();

        for (byte b : fileData){
                sb.append(lookupMap.get(b));
        }

        int length=(sb.length()+7)/8;
        byte[] huffCodeBytes = new byte[length];

        int counter=0;
        int idx = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String s;
            if (i + 8 > sb.length()){

                s = sb.substring(i);
                counter=s.length();
            }

            else s = sb.substring(i, i + 8);
            huffCodeBytes[idx] = (byte) Integer.parseInt(s , 2);
            idx++;
        }
        return new Container(huffCodeBytes, (byte) counter);
    }
}
