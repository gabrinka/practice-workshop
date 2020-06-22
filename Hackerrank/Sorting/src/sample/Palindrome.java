package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Palindrome {
    public static int findAllPalindromesWithPivot(String s) {
        int palindromesCount = 0;

        for (int i = 0; i < s.length(); i++) {
            //finding the number of odd sized palindromes as we use every character of the string as a pivot elem
            palindromesCount += (findPalindromes(s,i,i)).size();
            //finding the number of even sized pallindromes
           palindromesCount += (findPalindromes(s, i, i+1)).size();
        }
        return palindromesCount;
    }
    private static List<String> findPalindromes(String s, int low, int high) {
        List<String> palindromes = new ArrayList<>();
        while ( high < s.length() && low > -1 && s.charAt(low) == s.charAt(high)) {
            String substring = s.substring(low,high+1);
            palindromes.add(substring);

            high+=1;

            low-=1;
        }
        return palindromes;
    }
    public static void main(String[] args) {
        String s = "abbba";
        int res = findAllPalindromesWithPivot(s);
        System.out.println(res);


    }
}
