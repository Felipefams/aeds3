import java.io.RandomAccessFile;
import java.util.BitSet;
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
    static class Pair<A, B>{
        public A first;
        public B second;
    }

    static Node root;
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
    public void traverse(Node root, String s){
        if(root.left == null && root.right == null && Character.isLetter(root.data)){
            charMap.put(root.data, s);
            codeMap.put(s, root.data);
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

	static int index = 0;
    public static char travFromBitset(Node root, String s, char ans){
        if(root.left == null && root.right == null){//&& Character.isLetter(root.data)){
//			ans = root.data;
            //quando chegar no valor nulo retorna
            return root.data;
        }if(s.charAt(index) == '1'){// bitSet.get(i)){
            //se o valor do bitset for 1, vai pra direita
            ans = travFromBitset(root.right, s, ans);
        }
        else{
            //else vai pra esquerda
            ans = travFromBitset(root.left, s, ans);
        }
        return ans;
    }
	/*
	 * passa a string s pro formato de bitset, depois percorre a arvore e descomprime.
	 * @param s: string a ser decodificada e descomprimida
	 * */
    public static void decompress(String s){
        var sb = new StringBuilder();
        for(int i = 0; i < s.length(); ++i) sb.append(charMap.get(s.charAt(i))); 

		String ans = "";
		String str = sb.toString();
		while(index < sb.length() - 1){
			if(index < sb.length() - 1) break;
			char k = ' ';
			k = travFromBitset(root, str, k);
			ans += k;
			System.out.println(ans);
			// c a s c a o
			// c a s a c o
		}
        /*
        int i = 0;
        Pair<Character, Integer> ans = new Pair<>();
        while(i < s.length()){
            ans = travFromBitset(Huffman.root, s, i, ans);
            System.out.print(ans.first + ans.second);
            i++;
        }
         
        for(int i = 0; i < arr.length; i++){
            BitSet bitSet = new BitSet();
            bitSet = BitSet.valueOf(new byte[]{arr[i]});
            // bitSet.set(arr[i]);
            char k = travFromBitset(root, bitSet, 0, ' ');
            System.out.println(k);
        }  
        */
    }

}
