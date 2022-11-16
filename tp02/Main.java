public class Main {
    public static void main(String[] args) {
        //char[] chars =  {a, b, c, d, e, f, g, h, i};
        int[] frequency = {1, 1, 1, 1, 1};
        Huffman huffman = new Huffman(frequency);
        String teste = "abcde";
        huffman.traverse(Huffman.root, "");
//        String encoded = huffman.encode(testeString);
        Huffman.decompress(teste);
        // huffman.printCode();
    }
}
