package Huffman.Compressor;

import Huffman.MyDefines.Container;
import Huffman.MyDefines.Node;

import java.util.Map;

public interface ICompressionUtils {

    Node createHuffmanTree(byte[] fileData);

    void buildLookupRecursive(Node root, String s, Map<Byte,String> lookupMap);

    Container createCompressedArray(byte[] fileData, Map<Byte, String> lookupMap);


}
