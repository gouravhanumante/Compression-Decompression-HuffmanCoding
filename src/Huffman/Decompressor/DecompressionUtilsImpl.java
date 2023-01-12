package Huffman.Decompressor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecompressionUtilsImpl implements IDecompressionUtils{
    @Override
    public byte[] decompress(byte[] huffmanBytes, Map<Byte, String> lookupMap) {
        String s=convertBytetoBitString(huffmanBytes);

        Map<String,Byte>  map=new HashMap<>();

        for (Map.Entry<Byte,String> entry:lookupMap.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        List<Byte> list=new ArrayList<>();

        for (int i=0;i<s.length();){
            int count=1;
            boolean flag=true;
            Byte b=null;
            while (flag){
                String key=s.substring(i,i+count);
                b=map.get(key);
                if (b==null){
                    count++;
                }else{
                    flag=false;
                }
            }
            list.add(b);
            i+=count;
        }


        byte[] result=new byte[list.size()];
        for ( int i=0;i<result.length;i++){
            result[i]=list.get(i);
        }
        return result;
    }

    public String convertBytetoBitString(byte[] bytes) {
        StringBuilder sb=new StringBuilder();
        int i=0;
        for (i=0;i<bytes.length-1;i++){
            sb.append(String.format("%8s", Integer.toBinaryString(bytes[i] & 0xFF)).replace(' ', '0'));
        }
        String str0 = Integer.toBinaryString(bytes[i]);
        if (bytes[i] < 0){
            sb.append(str0.substring(str0.length() - 8));
        }
        else {
            sb.append(str0);
        }
        return sb.toString();
    }
}
