import java.util.ArrayList;
import java.util.Arrays;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4},{5,7},{8,10},{12,16}};
        int[] ar = {6,8};
        for (int[] elemi : insert(arr, ar)) {
            System.out.println(Arrays.toString(elemi));
        }
    }
    // static int[][] insert(int[][] intervals, int[] newInterval){
    //     int[][] ans = new int[intervals.length][2];
    //     int ptr1 = 0;
    //     int ptr2 = 1;
    //     int count = 0;
    //     while (ptr2 < intervals.length) {
    //         // Case-1: No overlapping
    //         if(newInterval[0] > intervals[ptr1][1] && newInterval[1] < intervals[ptr2][0]){
    //             ans[count] = newInterval;
    //         }
    //         else if(newInterval[0] >= intervals[ptr1][0] && newInterval[1] < intervals[ptr2][0]){
    //             int[] newVal = new int[2];
    //             newVal[0] = intervals[ptr1][0];
    //             newVal[1] = newInterval[1];
    //             ans[count] = newVal;
    //         }
    //         else if(newInterval[0] < intervals[ptr1][0] && newInterval[1] >= intervals[ptr2][0]){
    //             int[] newVal = new int[2];
    //             newVal[0] = newInterval[0];
    //             newVal[1] = intervals[ptr2][1];
    //             ans[count] = newVal;
    //         }
            
    //     }
    // }

    // This approach doesn't correctly handles all the cases

    // Soch 
    // Add the element and merge overlapping intervals, also intervals are given in sorted order

    // Brute force: break the interval[] into 3 different parts:
    // 1.) Left to given and not overlap
    // 2.) Middle and do overlap
    // 3.) Right and not overlap
    // Eg: {{1,2},{3,4},{5,7},{8,10},{12,16}} and newInterval is {6,8}

    static int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        ans.add(newInterval);
        while (i < newInterval.length) {
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
