package sample;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ArrayManipulation {
/*Instead of filling the array we fill only the starting index of the array of the element with the sum element and at index (ending index of the interval) we substract */
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        Integer [] resultArray = new Integer[n];
        Arrays.fill(resultArray,0);
        long max = 0,currValue = 0;
        for(int i = 0 ; i<queries.length;i++){
            resultArray[queries[i][0] - 1]+=queries[i][2];
            if(queries[i][1]<n) resultArray[queries[i][1]]-=queries[i][2];

        }
        for (int j = 0; j<resultArray.length;j++){
            currValue+=resultArray[j];
            if(currValue> max) max = currValue;
        }
        return max;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
