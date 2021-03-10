package Arrays_and_Strings;

import java.util.HashSet;
import java.util.Set;

/*
You do not have to-and should not-generate all permutations. This would be very inefficient.
What characteristics would a string that is a permutation of a palindrome have?
Have you tried a hash table? You should be able to get this down to 0(N) time.
Can you reduce the space usage by using a bit vector?
 */
public class Palindrome_Permutation {
    public static boolean  isPalindromePermutation(String str) {
        String lowerCase = str.toLowerCase();
        Set<Character> set = new HashSet<>();
        for (Character c : lowerCase.toCharArray()) {
            if (c == ' ') {
                continue;
            }
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.isEmpty() || set.size() == 1;
    }

    public static void main(String[] args) {
        String test = "Rats live on no evil star";
        System.out.println(isPalindromePermutation(test));
    }
}
