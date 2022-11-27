import java.util.ArrayList;
import java.util.Scanner;

class LZW {

    public static void main(String[] args) {
        
        Scanner scr = new Scanner(System.in);

        // -------------------------------------------------------------- //
        
        // read in the input
        String input = scr.nextLine();

        input = input.replaceAll(" ", "_");

        // create a dictionary
        ArrayList<String> dictionary = new ArrayList<String>();

        for(int i = 0; i < input.length(); i++) {

            String s = Character.toString(input.charAt(i));
            
            if(!dictionary.contains(s)) dictionary.add(s);
        }

        // -------------------------------------------------------------- //

        ArrayList<Integer> output = new ArrayList<Integer>();

        for(int i = 0; i < input.length(); i++) {

            String s = Character.toString(input.charAt(i));

            while(true) {

                s += input.charAt(i + 1);

                if(dictionary.contains(s)) i++;
                else {

                    dictionary.add(s);
                    output.add(dictionary.indexOf(s.substring(0, s.length() - 1)));
                    break;
                }
            }

            if(dictionary.contains(s)) output.add(dictionary.indexOf(s));
            
            // --------------- //

            if(i == input.length() - 1) break;

            String add = s + input.charAt(i + 1);

            if(!dictionary.contains(add)) dictionary.add(add);
            else {

                while(true) {
                        
                    i++;
                    add += input.charAt(i + 1);

                    if(!dictionary.contains(add)) {

                        dictionary.add(add);
                        break;
                    }
                }
            }
        }

        // -------------------------------------------------------------- //

        for(Integer s : output) System.out.print(s + ",");

        scr.close();
    }
}