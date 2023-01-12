import Huffman.Compressor.HuffmanCompressionImpl;
import Huffman.Compressor.ICompressor;
import Huffman.Decompressor.HuffmanDecompressionImpl;
import Huffman.Decompressor.IDecompressor;

public class HuffmanLoseRarImpl implements ILoseRar{

    @Override
    public void compression(String source, String destination) {
        ICompressor compressor=new HuffmanCompressionImpl();
        compressor.compress(source,destination);
    }


    @Override
    public void decompression(String source, String destination) {
        IDecompressor decompressor=new HuffmanDecompressionImpl();
        decompressor.decompress(source,destination);
    }
}
