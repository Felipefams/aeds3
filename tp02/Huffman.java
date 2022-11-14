import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {
    class Node{
        public int frequency;
        public char data;
        public Node left;
        public Node right;
    } 
    Node root;
    static HashMap <Character, String> charMap = new HashMap<>();// hashmap de char pra String do byte O(1)
    static HashMap <String, Character> codeMap = new HashMap<>();// hashmap de String do byte pra char O(1)

    public Huffman(int[] frequency){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(11, new Comparator<Node>(){
            public int compare(Node o1, Node o2) {
                if(o1.frequency > o2.frequency){
                    return 1;
                }
                else if(o1.frequency < o2.frequency){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        for(int i = 0; i < frequency.length; i++){
            Node node = new Node();
            node.frequency = frequency[i];
            node.data = (char)('a' + i);
            node.left = null;
            node.right = null;
            pq.add(node);
        }
        while(pq.size() != 1){
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
        percorre a arvore e adiciona o codigo de cada letra no map
        @param node: no atual
        @param s: codigo da letra
    */ 
    public static void traverse(Node root, String s){
        if(root.left == null && root.right == null && Character.isLetter(root.data)){
            charMap.put(root.data, s);
            return;
        }
        traverse(root.left, s + '0');
        traverse(root.right, s + '1');
    }

    public static void printCode(Node root, String s){
        if(root.left == null && root.right == null && Character.isLetter(root.data)){
            System.out.println(root.data + ":" + s);
            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public void printCode(){
        printCode(root, "");
    }

    public static byte[] encode(String s, HashMap<Character, String> charMap){
        byte[] encoded = new byte[s.length()];
        for(int i = 0; i < s.length(); i++){
            encoded[i] = (byte)Integer.parseInt(charMap.get(s.charAt(i)), 2);
        }
        return encoded;
    }

    public static void writeToFile(){

    }

}
