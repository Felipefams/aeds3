import java.io.RandomAccessFile;
import java.util.HashMap;

public class Main {
    public static HashMap<Character, Integer> makeFrequency(String filename) {
        var frequency = new HashMap<Character, Integer>();
        try {
            RandomAccessFile raf = new RandomAccessFile(Crud.DEFAULT_FILE, "rw");
            while (raf.getFilePointer() < raf.length()) {
                char c = (char) raf.readByte();
                frequency.merge(c, 1, Integer::sum);
            }
            raf.seek(0);
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return frequency;
    }

    public static void main(String[] args) {
        var frequency = makeFrequency(Crud.DEFAULT_FILE); 
        Huffman huffman = new Huffman(frequency);
        huffman.traverse(Huffman.root, "");// cria o map com os codigos

        try {
            RandomAccessFile source = new RandomAccessFile("accounts.bin", "rw");
            RandomAccessFile dest = new RandomAccessFile("h_compressed.bin", "rw");
            RandomAccessFile desc = new RandomAccessFile("h_descompressed.bin", "rw");
            Huffman.compress(source, dest);
            Huffman.decompress(dest, desc);

            source.seek(0);
            dest.seek(0);
            source.close();
            dest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // huffman.printCode();
    }
}
