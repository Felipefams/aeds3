public class Main {
    public static void main(String[] args) {
        //char[] chars =  {a, b, c, d, e, f};
        int[] frequency = {2, 3, 4, 5, 6, 7};
        Huffman huffman = new Huffman(frequency);
        
        huffman.printCode();
    }
}
