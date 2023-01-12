package Huffman.Compressor;

import java.util.Map;

public interface IReadAndWrite {
    public byte[] read(String source);
    void write(String destination, byte[] huffmanBytes, Map<Byte,String> lookupMap);
}
