import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        //char[] chars =  {a, b, c, d, e, f, g, h, i};
        var frequency = new HashMap<Character, Integer>();
        frequency.put('a', 1);
        frequency.put('b', 1);
        frequency.put('c', 1);
        frequency.put('d', 1);
        frequency.put('e', 1);
        // int[] frequency = {1, 1, 1, 1, 1};
        Huffman huffman = new Huffman(frequency);
        String teste = "abcde";
        huffman.traverse(Huffman.root, "");
//        String encoded = huffman.encode(testeString);
        Huffman.decompress(teste);
        // huffman.printCode();
    }
}
