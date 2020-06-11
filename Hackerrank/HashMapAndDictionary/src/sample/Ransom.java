package sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Ransom {

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String,Integer> magazineWords = new HashMap<>();
        int counter = 0;
        for (int i = 0; i<magazine.length ; i++){
            //the value stores how many times the key is in the magazine
            if(magazineWords.containsKey(magazine[i])) magazineWords.put(magazine[i],magazineWords.get(magazine[i])+1);
            else magazineWords.put(magazine[i],1);
        }
        for (String noteWords : note){

            if (!magazineWords.containsKey(noteWords)) {
                    System.out.println("No");
                    return;
             }
            else{
                counter = magazineWords.get(noteWords);
                magazineWords.put(noteWords,--counter);
                if(counter==0) magazineWords.remove(noteWords);
            }

        }
        System.out.println("Yes");


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
