package sample;

import javax.naming.NameClassPair;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Min_swaps {
    // it can work with arrays bigger than 20 in size
    // we need to find the minimum number of swaps to sort an array , this approach looks at cycles between the current index of an element and the index its supposed to be at,the required swaps are the sum of (cycle size - 1)
 static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        Vector<Point> container = new Vector<Point>();
        for (int i = 0 ; i<20 ; i++){
            container.add(new Point(scan.nextInt(),i));
        }
        class PointComparator implements Comparator<Point>{

            @Override
            public int compare(Point o1, Point o2) {
                return Integer.compare(o1.x,o2.x);
            }
        }
        Collections.sort(container,new PointComparator());
        Boolean visited[] = new Boolean[container.size()];
        Arrays.fill(visited,false);
        int min_swaps = 0;
        for (int index = 0 ;index < visited.length;index++){
            if (allAreVisited(visited)) break;
            if(visited[index]) continue;
            int cycle_size = 0;
            while(!visited[index]){
                visited[index] = true;
                index = container.get(index).y;
                cycle_size++;

            }
            min_swaps+=cycle_size-1;
        }

        System.out.println(min_swaps);

    }
    static Boolean allAreVisited(Boolean visited[]){
    for (boolean elem : visited){
       if (elem == false) return false;
        }
        return  true;
    }

}
