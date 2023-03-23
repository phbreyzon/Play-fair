public class Test {
    
    public static void main(String[] args) {
        char[][] matrix = new char[][] {
            {'M', 'N', 'O', 'P', 'Q'},
            {'R', 'S', 'T', 'U', 'V'},
            {'W', 'X', 'Y', 'Z', 'A'},
            {'B', 'C', 'D', 'E', 'F'},
            {'G', 'H', 'I', 'K', 'L'}
        };

        testInternal('A', matrix, 2);
        testInternal('W', matrix, 2);
        testInternal('D', matrix, 3);
        testInternal('O', matrix, 0);
        testInternal('A', matrix, 2);
        testInternal('K', matrix, 4);

    }

    private static void testInternal(char searched, char[][] matrix, int expeced) {
        int result = App.rowOfReference(searched, matrix);
        boolean success = result == expeced;
        System.out.println("Test case " + searched);
        if (success) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("FAILURE (was:" + result + ", expected: " + expeced + ")");
        }
    }

}
