package sample;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class CountTriplets {
//1224 2
    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        Map<Long,Long> numberCounts = new HashMap<>();
        Map<Long,Long> countTuplets = new HashMap<>(); // dvoiki chiito key e elementa ot masiva/r
        long total=0;
        for (Long elem : arr){
            long n =elem/r;
            if(countTuplets.containsKey(n)) total += countTuplets.get(n); //tursim dvoiki takiva che stavat troiki s tozi element
            countTuplets.put(elem,countTuplets.get(elem)==null ? (numberCounts.get(n)==null ? Long.valueOf(0) :
                    numberCounts.get(n)) : countTuplets.get(elem)+(numberCounts.get(n)==null ? Long.valueOf(0):
                    numberCounts.get(n)));
            numberCounts.put(elem,numberCounts.get(elem)==null ? 1: numberCounts.get(elem)+1);

        }

    return total;}

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        System.out.println(ans);

        bufferedReader.close();

    }
}
