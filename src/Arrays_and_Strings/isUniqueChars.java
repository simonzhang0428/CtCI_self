package Arrays_and_Strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* hints:
Use hash table
Could a bit vector be useful?
Can you solve it inO(N log N)time?What might a solution like that look like?
 */
public class isUniqueChars {
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) {
            return false;
        }

        boolean[] bitVector = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (bitVector[c]) {
                return false;
            }
            bitVector[c] = true;
        }
//        Set<Character> char2int = new HashSet<>();
//        for (int i = 0; i < str.length(); i++) {
//            if (char2int.contains(str.charAt(i))) {
//                return false;
//            }
//            char2int.add(str.charAt(i));
//        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
