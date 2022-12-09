public class StringProcessing{
    static long levenshteinDistance(String s, String t) {
        int n = s.length() + 1;
        int m = t.length() + 1;
        int[][] v = new int[n][m];
        for(int i = 0; i < n; ++i) v[i][0] = i;
        for(int i = 1; i < m; ++i) v[0][i] = i;
        for(int i = 1; i < n; ++i){
            for(int j = 1; j < m; ++j){
                int k = Math.min(v[i][j-1], Math.min(v[i-1][j], v[i-1][j-1]));
                if(s.charAt(i-1) == t.charAt(j-1)) v[i][j] = v[i-1][j-1];
                else v[i][j] = k + 1;
            }
        }
        return v[n-1][m-1]; 
    }

    public class kmp{
        //monta o array de falhas 
        static int[] prefixFunction(String s){
            int n = s.length();
            int[] pi = new int[n];
            for(int i = 1; i < n; ++i){
                int j = pi[i-1];
                while(j > 0 && s.charAt(i) != s.charAt(j)) j = pi[j-1];
                if(s.charAt(i) == s.charAt(j)) ++j;
                pi[i] = j;
            }
            return pi;
        }
        //executa o algoritmo de kmp
        static int solve(String s, String t){
            int n = s.length();
            int m = t.length();
            int[] pi = prefixFunction(t);
            int j = 0;
            for(int i = 0; i < n; ++i){
                while(j > 0 && s.charAt(i) != t.charAt(j)) j = pi[j-1];
                if(s.charAt(i) == t.charAt(j)) ++j;
                if(j == m) return i - m + 1;
            }
            return -1;
        }
    }   
}