package Huffman.Decompressor;

import java.util.Map;

public interface IDecompressionUtils {
    byte[] decompress(byte[] huffmanBytes, Map<Byte, String> lookupMap, byte counter);


}
