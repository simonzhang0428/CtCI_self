package Arrays_and_Strings;

import java.util.Arrays;

public class URLify {
    /*
    Input: "Mr John Smith ", 13
    Output: "Mr%20John%20Smith"

    It's often easiest to modify strings by going from the end of the string to the beginning.
    You might find you need to know the number of spaces. Can you just count them?
     */
    public static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0, index, i = 0;
        for (i = 0; i < trueLength; i++) {
            if (str[i] == ' ') {
                spaceCount++;
            }
        }
        index = trueLength + spaceCount * 2;
        if (trueLength < str.length) str[trueLength] = '\0';
        for (i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[index - 1] = '0';
                str[index - 2] = '2';
                str[index - 3] = '%';
                index = index - 3;
            } else {
                str[index - 1] = str[i];
                index--;
            }
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "abc d e f";
        char[] arr = new char[str.length() + 3 * 2 + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i);
        }
        System.out.println(Arrays.toString(arr));
        replaceSpaces(arr, str.length());
        System.out.println(Arrays.toString(arr));

        // str.deepToString()
        String[][] deepArray = new String[][] {{"John", "Mary"}, {"Alice", "Bob"}};
        System.out.println(Arrays.toString(deepArray));
        //output: [[Ljava.lang.String;@106d69c, [Ljava.lang.String;@52e922]
        System.out.println(Arrays.deepToString(deepArray));
    }
}
