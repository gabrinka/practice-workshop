package sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SharedSubstrings {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        //we are only going to check whether they share some letters,we dont have to check for whole words
        Map<Character,Integer> letters= new HashMap<>();
        char[] s1_array = s1.toCharArray();
        for (char symbol:s1_array){
            letters.put(symbol,1);
        }
        char[] s2_array = s2.toCharArray();
        for(char symbol : s2_array){
            if (letters.containsKey(symbol)) return ("Yes");
        }
        return ("No");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
