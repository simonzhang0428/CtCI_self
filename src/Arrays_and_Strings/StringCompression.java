package Arrays_and_Strings;

import java.util.HashMap;
import java.util.Map;

/*
Do the easy thing first. Compress the string, then compare the lengths.

Be careful that you aren't repeatedly concatenating strings together. This can be very inefficient.
 */
public class StringCompression {
    private static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            // short circuit evaluation
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                sb.append(str.charAt(i));
                sb.append(count);
                count = 0;
            }
        }

        if (sb.length() > str.length()) {
            return str;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(stringCompression("abcccc"));
    }
}
