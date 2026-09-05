import java.util.*;

public class M2 {

    static boolean iterative(String s) {
        for (int i = 0; i < s.length() / 2; i++)
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        return true;
    }

    static boolean recursive(String s) {
        if (s.length() <= 1)
            return true;

        if (s.charAt(0) != s.charAt(s.length() - 1))
            return false;

        return recursive(s.substring(1, s.length() - 1));
    }

    static boolean arrayReverse(String s) {
        char[] a = s.toCharArray();

        for (int i = 0; i < a.length / 2; i++) {
            char temp = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = temp;
        }

        return s.equals(new String(a));
    }

    public static void main(String[] args) {

        String s = "madam";

        System.out.println("Iterative: " +
                (iterative(s) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (recursive(s) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (arrayReverse(s) ? "Palindrome" : "Not Palindrome"));
    }
}