package Arrays_and_Strings;

import java.util.Arrays;

/*
Describe what it means for two strings to be permutations of each other.
Now, look at that definition you provided.
Can you check the strings against that definition?

There is one solution that is 0(N log N) time.
Another solution uses some space, but isO(N) time.

Could a hash table be useful?

Two strings that are permutations should have the same characters,
but in different orders. Can you make the orders the same?
 */
public class Permutation {
    // version 1: sort then equal
    private static boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
//        char[] s1Char = s1.toCharArray();
//        char[] s2Char = s2.toCharArray();
//        Arrays.sort(s1Char);
//        Arrays.sort(s2Char);
//        return Arrays.equals(s1Char, s2Char);

        // use helper function, String.equals()
        return sort(s1).equals(sort(s2));
    }

    private static String sort(String str) {
        char[] content = str.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    // version 2: count char frequency and compare two string
    private static boolean permutation2(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        // assumption ASCII 128 chars
        int[] letters = new int[128];
        for (char c1 : s1.toCharArray()) {
            letters[c1]++;
        }

        for (char c2 : s2.toCharArray()) {
            letters[c2]--;
            if (letters[c2] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation2(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}
