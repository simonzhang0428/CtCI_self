package Arrays_and_Strings;

public class OneAway {

    /*
    Start with the easy thing. Can you check each of the conditions separately?

    What is the relationship between the "insert character" option and the "remove character" option?
    Do these need to be two separate checks?

    Can you do all three checks in a single pass?
     */
    private static boolean oneEditAway(String s1, String s2) {
        if (s1.length() == s2.length()) {
            return oneEditReplace(s1, s2);
        } else if (s1.length() + 1 == s2.length()) {
            return oneEditInsert(s1, s2);
        } else if (s1.length() - 1 == s2.length()) {
            return oneEditInsert(s2, s1);
        }
        return false;
    }

    // s2 is longer
    /* Check if you can insert a character into s1 to make s2. */
    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    private static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "ple";
        String b = "pale";

        boolean isOneEdit = oneEditAway(a, b);
        System.out.println(a + ", " + b + ": " + isOneEdit);
    }
}
