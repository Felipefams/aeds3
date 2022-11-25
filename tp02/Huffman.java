import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import javax.swing.plaf.synth.SynthPasswordFieldUI;

public class Huffman {
    class Node {
        public int frequency;
        public char data;
        public Node left;
        public Node right;
    }

    static class Pair<A, B> {
        public A first;
        public B second;
    }

    static Node root;
    static HashMap<Character, String> charMap = new HashMap<>();// hashmap de char pra String do byte O(1)
    static HashMap<String, Character> codeMap = new HashMap<>();// hashmap de String do byte pra char O(1)

    public Huffman(HashMap<Character, Integer> frequency) { // int[] frequency){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(frequency.size(), new Comparator<Node>() {
            public int compare(Node o1, Node o2) {
                if (o1.frequency > o2.frequency) {
                    return 1;
                } else if (o1.frequency < o2.frequency) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        for (char c : frequency.keySet()) {
            Node node = new Node();
            node.frequency = frequency.get(c);
            node.data = c;
            node.left = null;
            node.right = null;
            pq.add(node);
        }
        /*
         * for(int i = 0; i < frequency.length; i++){
         * Node node = new Node();
         * node.frequency = frequency[i];
         * node.data = (char)('a' + i);
         * node.left = null;
         * node.right = null;
         * pq.add(node);
         * }
         */
        while (pq.size() != 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node();
            parent.frequency = left.frequency + right.frequency;
            parent.data = '\0';
            parent.left = left;
            parent.right = right;
            pq.add(parent);
        }
        root = pq.poll();
    }

    /*
     * percorre a arvore e adiciona o codigo de cada letra no map
     * 
     * @param node: no atual
     * 
     * @param s: codigo da letra
     */
    public void traverse(Node root, String s) {
        if (root.left == null && root.right == null) {// && Character.isLetter(root.data)){
            charMap.put(root.data, s);
            codeMap.put(s, root.data);
            return;
        }
        traverse(root.left, s + '0');
        traverse(root.right, s + '1');
    }

    public static void printCode(Node root, String s) {
        if (root.left == null && root.right == null && Character.isLetter(root.data)) {
            System.out.println(root.data + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public void printCode() {
        printCode(root, "");
    }

    static int index = 0;

    public static char travFromBitset(Node root, String s, char ans) {
        if (root.left == null && root.right == null) {
            // ans = root.data;
            // quando chegar no valor nulo retorna
            return root.data;
        }
        if (s.charAt(index) == '1') {// bitSet.get(i)){
            // se o valor do bitset for 1, vai pra direita
            index++;
            ans = travFromBitset(root.right, s, ans);
        } else {
            // else vai pra esquerda
            index++;
            ans = travFromBitset(root.left, s, ans);
        }
        return ans;
    }

    /*
     * descomprime a string de bits
     * 
     * @param s: string a ser decodificada e descomprimida
     */
    public static void decompress(RandomAccessFile source, RandomAccessFile dest) throws IOException {
        source.seek(0);
        // String str = new String();
        String binary = new String();
        while (source.getFilePointer() < source.length() - 1) {
            char c = (char) source.readByte();
            binary +=  c;
        }
        // byte[] b = new byte[binary.length()];
        byte[] b = binary.getBytes(); 
        System.out.println(binary);
        String s = new String();
        for(int i = 0; i < b.length; ++i){
            s += String.format("%8s", Integer.toBinaryString(b[i] & 0xFF)).replace(' ', '0');
        }
        System.out.println(s);
        /* 
        while (source.getFilePointer() < source.length()) {
            // bytes =
            // char c = (char) source.readByte();
            byte b = source.readByte();
            String tmp = String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
            str += tmp;
            // str += (char) source.readByte();
        }
        System.out.println(str);
        String ans = new String();
        while (index < str.length() - 1) {
            char k = ' ';
            k = travFromBitset(root, str, k);
            ans += k;
        }
        RandomAccessFile teste = new RandomAccessFile("teste.bin", "rw");
        teste.writeBytes(ans);
        System.out.println(ans);
        */
    }

    public static void decompress(String s) {
        String ans = new String();
        while (index < s.length()) {
            char k = ' ';
            k = travFromBitset(root, s, k);
            ans += k;
        }
        System.out.println(ans);
    }
    
    /*
     * comprime o arquivo @source para o arquivo @dest
     */
    public static void compress(RandomAccessFile source, RandomAccessFile dest) throws IOException {
        // 2508
        String binary = new String();
        while (source.getFilePointer() < source.length()) {
            char c = (char) source.readByte();
            binary += charMap.get(c);
        }
        RandomAccessFile tmpTeste = new RandomAccessFile("tmp.bin", "rw");
        StringBuilder tmp = new StringBuilder();
        for (int i = 0; i < binary.length(); ++i) {
            tmp.append(binary.charAt(i));
            if (tmp.length() == 8) {
                byte b = (byte) Integer.parseInt(tmp.toString(), 2);// passa 8 bits pra byte
                dest.write(b);// escreve o byte no arquivo comprimido
                tmp.setLength(0); // reseta o stringBuilder
            }
        }
        tmpTeste.close();
    }
}
