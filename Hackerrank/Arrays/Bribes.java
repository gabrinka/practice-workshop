package sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

 class Bribes {

    // Complete the minimumBribes function below.
     //we traverse the array from end to start and we know that if the last index +1 != element sitting there ,
    // the last element must have bribed 1 or max 2 people else its too chaotic,we check if array[index-1] == index+1 if yes we swap them else we slap element at
     // index-1 and index-2 and then we swap elements at index and index-1 on each step we add either 1 or 2 to the bribeCount

    static void minimumBribes(int[] q) {
        int bribeCount = 0;
        for(int j = q.length - 1 ; j>=0 ; j--){
            if ((q[j] - (j+1)) > 2){ System.out.println("Too chaotic");return;}
        }

        for(int i = q.length - 1 ; i >= 0 ; i--){

            if (q[i]!= i+1 ){
                 if ((i-1)>=0 && q[i-1]==i+1){
                    swap(i,i-1,q);
                    bribeCount++;
                }
                else if(i>1 && q[i-2] == i+1){
                    swap(i-1,i-2,q);
                    swap(i-1,i,q);
                    bribeCount += 2;
                }
            }
        }
        System.out.println(bribeCount);


    }
    private static void swap(int i, int j,int[] bribe) {
        int temp = bribe[i];
        bribe[i] = bribe[j];
        bribe[j] = temp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}
