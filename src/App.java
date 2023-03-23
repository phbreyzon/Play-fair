import java.util.Scanner;
import java.util.Arrays;



// Feedback tool:
// Bei der 1. Submition gibt es immer 1  unknown error

public class App {
    private static final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("Gebe das Keyword ein: ");
        String input = s.next();
        char[] finalvector = vector(alph, input);

        int a = 0;
        int e = 5;
        char[][] finalmatrix = new char[5][5];
        for(int k = 0; k < 5; k++){
            char[] tmparray = Arrays.copyOfRange(finalvector, a, e);
            finalmatrix[k] = tmparray; // assign tmparray to finalmatrix
            a = a +5;
            e = e +5;
        }
        
        System.out.println("Gebe die Message ein: ");
        String message = s.next();
        message = message.replaceAll("\\s+","");
        message = message.toUpperCase();
        
        char[] msgarray = message.toCharArray();

    }


    // Fusions keyword without duplicates with alphabetstring
    public static char[] vector(String alph, String o){
        o = o.toUpperCase();
        char[] tmp = o.toCharArray();

        char[] cword = getCharArray(tmp);

        tmp = alph.toCharArray();

        char main[] = new char[alph.length()];
        
        // Putting values to main Array
        for(int i = 0; i < cword.length; i++){
           main[i] = cword[i];
        }
        // Settings other values to ' '
        for(int i = cword.length ; i < main.length ; i++){
            main[i] = ' ';
        }


        // Putting other Chars to main Char
        for(int i = 0; i < alph.length(); i++){
            for(int k = 0; k < cword.length; k++){
                if(cword[k] == tmp[i]){
                    tmp[i] = '&';
                }
            }
        }
        int c = 0;
        int t = 0;
        while(main[c] != ' '){
            c++;
        }
        for(int i = 0; i < main.length - cword.length - 1; t++){
            if(tmp[t] != '&'){
                if(tmp[t] != 'J'){
                    main[c] = tmp[t];
                    c++;
                    i++;
                }  
            }
        }
        return main;
    }


    // Remove Duplicates from char Array 
    public static char[] getCharArray(char[] array) {
        String _array = "";
        for(int i = 0; i < array.length; i++) {
            if(_array.indexOf(array[i]) == -1){ // Man kann die braces weglassen und es würde immernoch kompilieren
                _array = _array+array[i];
            } 
        }
        return _array.toCharArray();
    }

}
