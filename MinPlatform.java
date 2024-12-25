import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinPlatform {
    public static void main(String[] args) {

    }

    // static int findPlatform(int arr[], int dep[]) {
    // List<Pair> list = new ArrayList<>();
    // for (int i = 0; i < dep.length; i++) {
    // list.add(new Pair(arr[i], dep[i]));
    // }
    // list.sort((a,b) -> a.dep - b.dep);

    // int prev = list.get(0).dep;
    // int currPlatforms = 1;
    // int minPlatforms = 0;
    // Queue<Pair> scheduled = new LinkedList<>();
    // scheduled.add(list.get(0));
    // for (int i = 1; i < list.size(); i++) {
    // if(list.get(i).arr > prev){
    // while (!scheduled.isEmpty() && scheduled.peek().dep < list.get(i).arr) {
    // scheduled.poll();
    // currPlatforms--;
    // }
    // scheduled.add(list.get(i));
    // currPlatforms++;
    // prev = scheduled.peek().dep;
    // }
    // else{
    // scheduled.add(list.get(i));
    // currPlatforms++;
    // minPlatforms = Math.max(minPlatforms, currPlatforms);
    // }
    // }
    // return minPlatforms;
    // }

    static int findPlatformBrute(int[] arr, int[] dep) {

        // Intution: check for overlapping intervals and jis time mein max overlappings hain uss time mein max platforms chaiye
        int maxIntersection = 0;
        for (int i = 0; i < dep.length; i++) {
            int intersections = 0;
            for (int j = 0; j < dep.length && j != i; j++) {
                if(arr[i] <= dep[j] ){
                    intersections++;
                    maxIntersection = Math.max(maxIntersection, intersections);
                }
            }
        }
        return maxIntersection;
    }
}

class Pair {
    int arr;
    int dep;

    Pair(int a, int b) {
        this.arr = a;
        this.dep = b;
    }
}