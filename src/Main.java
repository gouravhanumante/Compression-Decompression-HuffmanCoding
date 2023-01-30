import java.nio.file.Watchable;
import java.util.Timer;

public class Main {
    public static void main(String[] args) {
        ILoseRar loseRar=new HuffmanLoseRarImpl();
        System.out.println(System.currentTimeMillis());
//        loseRar.compression("C:\\Users\\HP\\OneDrive\\Desktop\\New Foldee\\Huffman\\input.txt",
//                "C:\\Users\\HP\\OneDrive\\Desktop\\New Foldee\\Huffman\\s.txt");

        System.out.println(System.currentTimeMillis());
//        System.currentTimeMillis();
//
        loseRar.decompression("C:\\Users\\HP\\OneDrive\\Desktop\\New Foldee\\Huffman\\s.txt",
                "C:\\Users\\HP\\OneDrive\\Desktop\\New Foldee\\Huffman\\onno.txt");
        System.out.println(System.currentTimeMillis());
//
    }
}