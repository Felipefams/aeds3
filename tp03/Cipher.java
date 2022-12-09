public class Cipher{
    /* 
    faz a cifra de cesar com a string passada como parametro
    */
    static String encrypt(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
            result += (char)(s.charAt(i) + 1);
        }
        return result;
    }

    /* decifra a cifra de cesar */
    static String decrypt(String s) {
        String result = "";
        for(int i = 0; i < s.length(); i++) {
           result += (char)(s.charAt(i) - 1);
        }
        return result;
    }
}