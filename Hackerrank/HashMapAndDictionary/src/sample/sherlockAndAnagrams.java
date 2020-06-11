package sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Stream;

public class sherlockAndAnagrams {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
 Map<String,Integer> substrings = new HashMap<>(); //(substring,occurences of the substring)
 char[] substringsArray;
 int result = 0;
 if (Stream.of(s.toCharArray()).distinct().toArray().length == s.toCharArray().length) return 0;

 for(int i = 0; i<s.length(); i++){
     for(int j = i+1; j<=s.length();j++){

         substringsArray=s.substring(i,j).toCharArray();
         Arrays.sort(substringsArray);
         String n = String.valueOf(substringsArray);
         if(n.equals(s)) continue;

         if (substrings.containsKey(n)) substrings.put(n,substrings.get(n)+1);
         else substrings.put(n,1);
     }
 }
        for(String key: substrings.keySet()){
            int n = substrings.get(key);
            result += (n * (n-1))/2;
        }
        return result;}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            System.out.println(result);

            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

       // bufferedWriter.close();

        scanner.close();
    }
}
