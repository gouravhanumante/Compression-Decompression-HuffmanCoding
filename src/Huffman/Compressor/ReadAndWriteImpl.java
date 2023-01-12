package Huffman.Compressor;

import java.io.*;
import java.util.Map;

public class ReadAndWriteImpl implements IReadAndWrite{

    @Override
    public byte[] read(String source) {
        try {
            FileInputStream inStream=new FileInputStream(source);
            byte[] b=new byte[inStream.available()];
            inStream.read(b);
            inStream.close();
            return b;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new byte[0];//CLTAE
    }

    @Override
    public void write(String destination, byte[] huffmanBytes, Map<Byte,String> lookupMap) {
        try {
            OutputStream oStream=new FileOutputStream(destination);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(oStream);
            objectOutputStream.writeObject(huffmanBytes);
            objectOutputStream.writeObject(lookupMap);

            oStream.close();
            objectOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
