import java.util.Scanner;
import java.util.Arrays;



// Feedback tool:
// Bei der 1. Submition gibt es immer 1  unknown error

public class App {
    private static final String alph = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    public static void main(String[] args) throws Exception {
        
        // Making the keyword matrix
        Scanner s = new Scanner(System.in);
        System.out.println("Gebe das Keyword ein: ");
        String input = s.next();
        char[] finalvector = vector(alph, input);
        // erste Arraydimension: Zeilennummer
        char[][] finalmatrix = new char[5][5];
        finalmatrix = vectorToMatrix(finalmatrix, finalvector, 5, 5);
        
        // Getting message
        System.out.println("Gebe die Message ein: ");
        String message = s.nextLine();
        do{
            message = s.nextLine();
        }while(message == "");
       
        // Preparing the message Vector
        message = message.replaceAll("\\s+","");
        message = message.toUpperCase();
        if(((message.length() % 2) != 0) ){
            message = message + 'A';
        }
        char[] msgarray = message.toCharArray();
        for(int i = 0; i < message.length() -1; i++){
            for(int k = i +1; k < i + 2; k++){
                if(msgarray[i] == msgarray[k] ){
                    message = addChartoString(message, 'X', i+1);
                    msgarray = message.toCharArray();
                }
            }            
        }

        // making message matrix
        char[][] msgmatrix = new char[message.length() / 2][2];

        // Inner array: pair of chars
        msgmatrix = vectorToMatrix(msgmatrix, msgarray, message.length() / 2, 2);
       
        // Encryption
        for (int i = 0; i < msgmatrix.length; i++) {
            char[] pair = msgmatrix[i];
            char[] newPair = computeNewPair(pair, finalmatrix);
            msgmatrix[i] = newPair;
        }

    }

    /**
     * 
     * @param target
     * @param reference Coding matrix (Square)
     * @return
     */
    public static char[] computeNewPair( char[] target, char[][] reference) {
        Object finalmatrix;
        // Only works correctly if both characters really are in the reference matrix, otherwise -1 == -1
          if(rowOfReference(target[0],  reference) == rowOfReference(target[1], reference)) {
            int newColFirst =(colOfReference(target[0], reference)+ 1)%5;
            int newColSecond =(colOfReference(target[1], reference)+ 1)%5;
            return new char[] {
                reference[rowOfReference(target[0], reference)][newColFirst],reference[rowOfReference(target[0], reference)][newColSecond] 
            };
          }
          else if(colOfReference(target[0], reference) == colOfReference(target[1], reference)){
            
          }
          else{

          }
    
    }

    public static int rowOfReference(char c, char[][] reference) {
        for(int row = 0; row < reference.length; row++){
            for(int col = 0; col < reference[row].length; col++){
                if(c == reference[row][col]){
                    return row;
                }
            }
        }
        return -1;
    }

    public static int colOfReference(char c, char[][] reference) {
        for(int row = 0; row < reference.length; row++){
            for(int col = 0; col < reference[row].length; col++){
                if(c == reference[row][col]){
                    return col;
                }
            }
        }
        return -1;
    }

    public static char[][] vectorToMatrix(char[][] matrix, char[] vector, int height, int lenght) {
        int a = 0;
        int e = lenght;
        for(int k = 0; k < height; k++){
            char[] tmparray = Arrays.copyOfRange(vector, a, e);
            matrix[k] = tmparray; // assign tmparray to finalmatrix
            a = a + lenght;
            e = e + lenght;
        }
        return matrix;
    }
    // add 'X' between Duplicates in Message
    public static String addChartoString(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
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
