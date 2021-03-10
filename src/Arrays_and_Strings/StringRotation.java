package Arrays_and_Strings;

/*
If a string is a rotation of another, then it's a rotation at a particular point.
For example, a rotation of waterbottle at character 3 means cutting waterbottle at character 3
and putting the right half (erbottle) before the left half (wat).

We are essentially asking if there's a way of splitting the first string into two parts, x and y,
such that the first string is xy and the second string is yx.
For example,x = watand y = erbottle. The first string is xy = waterbottle. The second string is yx = erbottlewat.

Think about the earlier hint. Then think about what happens when you concatenate erbottlewat to itself.
You get erbottlewaterbottlewat.
 */
public class StringRotation {

    public static boolean isSubstring(String big, String small) {
        return big.contains(small);
    }
    private static boolean isRotation(String s1, String s2) {
        int len = s1.length();
        /* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
            /* concatenate s1 and s1 within new buffer */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
