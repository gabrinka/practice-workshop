package sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Notifications {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        Queue<Integer> firstDdays = new LinkedList<>();
        int[] frequencyTable = new int[201];
        Arrays.fill(frequencyTable,0);
        int notifications = 0;
        int i =0;
        for (i = 0 ; i<d ; i++){
            firstDdays.add(expenditure[i]);
             ++frequencyTable[expenditure[i]];
        }

        for (int j=i;j<expenditure.length;j++){
            int spentMoney = expenditure[j];
            if (spentMoney>=2* getMedian(frequencyTable,d)) notifications++;
            frequencyTable[firstDdays.peek()]-=1;
            firstDdays.remove();
            firstDdays.add(expenditure[j]);
            ++frequencyTable[expenditure[j]];
        }

        return notifications;
    }
    private static double getMedian(int[] frequencies, int d) {
        int center = 0;
        int center1 = -1;
        int center2 = -1;

        if (d % 2 != 0) {

            for (int i = 0; i < frequencies.length; i++) {
                center += frequencies[i];

                if (center > d / 2)
                    return i;
            }
        } else {
            for (int i = 0; i < frequencies.length; i++) {
                center += frequencies[i];

                if (center == d / 2)
                    center1 = i;
                else if (center > d / 2) {
                    if (center1 < 0) {
                        center1 = i;
                    }

                    center2 = i;
                    return (double) (center1 + center2) / 2;
                }
            }
        }
        return 0;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        scanner.close();
    }
}
