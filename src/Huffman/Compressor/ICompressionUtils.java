package Huffman.Compressor;

import Huffman.MyDefines.Node;

import java.util.Map;

public interface ICompressionUtils {

    Node createHuffmanTree(byte[] fileData);

    void buildLookupRecursive(Node root, String s, Map<Byte,String> lookupMap);

    byte[] createCompressedArray(byte[] fileData,Map<Byte, String> lookupMap);


}
