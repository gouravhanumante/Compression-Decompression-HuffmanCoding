package Huffman.Decompressor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.util.Map;

public class HuffmanDecompressionImpl implements IDecompressor{
    @Override
    public void decompress(String source, String destination) {
        try {

            FileInputStream iStream=new FileInputStream(source);
            ObjectInputStream objectInputStream=new ObjectInputStream(iStream);

            byte[] huffmanBytes= (byte[]) objectInputStream.readObject();
            Map<Byte,String> lookupMap= (Map<Byte, String>) objectInputStream.readObject();

            byte[] finalRes=getDecompressedData(huffmanBytes,lookupMap);

            OutputStream oStream=new FileOutputStream(destination);
            oStream.write(finalRes);

            objectInputStream.close();
            oStream.close();
            iStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public byte[] getDecompressedData(byte[] huffmanBytes, Map<Byte, String> lookupMap) {
        IDecompressionUtils util=new DecompressionUtilsImpl();
        byte[] decodedData=util.decompress(huffmanBytes,lookupMap);
        return decodedData;

    }
}
