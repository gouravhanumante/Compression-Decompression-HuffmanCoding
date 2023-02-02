package Huffman.Compressor;

import Huffman.MyDefines.Container;
import Huffman.MyDefines.Node;

import java.util.HashMap;
import java.util.Map;

public class HuffmanCompressionImpl implements ICompressor{

    private Map<Byte,String> lookupMap=new HashMap<>();
    @Override
    public void compress(String source, String destination) {
        IReadAndWrite rw=new ReadAndWriteImpl();
        byte[] b=rw.read(source);
        //Condition for empty file



        Container huffmanByte=mainCompressionMethods(b);

        rw.write(destination,huffmanByte,lookupMap);
    }

    private Container mainCompressionMethods(byte[] b) {
        if (b.length==0) return new Container(b,(byte)0);

        ICompressionUtils utils=new CompressionUtils();

        Node root=utils.createHuffmanTree(b);
        utils.buildLookupRecursive(root,"",lookupMap);
        Container huffmanBytesContainer=utils.createCompressedArray(b,lookupMap);

        return huffmanBytesContainer;
    }
}
