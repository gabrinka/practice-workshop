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

public class FrequencyQueries {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer,Integer> result = new HashMap<>();
        List<Integer> arrayResult = new ArrayList<>();

        for (List<Integer> operation : queries){
            int op = operation.get(0);
            int num = operation.get(1);
            if (op==1) {
                if(!result.containsKey(num)) result.put(num,1);
                else result.put(num,result.get(num)+1 );
            }
            if (op==2 && result.containsKey(num)) { //should be careful cuz i didnt remove it at first if value was <1 and it ended up messing the frequency
                if(result.get(num)<=1) result.remove(num);
                else result.put(num, result.get(num) - 1);
            }
            if(op == 3) {
                if(result.containsValue(num)) arrayResult.add(1);
                else arrayResult.add(0);

            }
        }
        return arrayResult;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

       System.out.println(ans);

        bufferedReader.close();

    }
}
