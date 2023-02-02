package Huffman.Compressor;

import Huffman.MyDefines.Container;

import java.util.Map;

public interface IReadAndWrite {
    public byte[] read(String source);
    void write(String destination, Container huffmanBytes, Map<Byte,String> lookupMap);
}
