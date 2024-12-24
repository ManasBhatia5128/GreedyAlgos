import java.util.Arrays;

public class RemoveOverlapping {
    public static void main(String[] args) {
        int[][] intervals = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        System.out.println(erase(intervals));
    }
    static int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
        Arrays.sort(intervals, (a, b) -> {
            // First, compare by the start value (a[0] and b[0])
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            // If start values are the same, compare by the end value (a[1] and b[1])
            return a[1] - b[1];
        });
        int firstElem = intervals[0][0];
        int lastElem = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= firstElem && intervals[i][0] < lastElem){
                ans++;
            }
            else{
                firstElem = intervals[i][0];
                lastElem = intervals[i][1];
            }
        }
        return ans;
    }

    // Riyal soln: 
    // Similar soch as N meetings in one room, just think like since meeting timings cannot overlap, we also cannot overlap the given intervals
    static int erase(int[][] intervals) {
        if(intervals.length == 0){
            return 0;
        }

        int intervalsTaken = 1;
        Arrays.sort(intervals, (a,b) ->{
            return a[1] - b[1];
        }); // O(NlogN)

        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= prevEnd){
                intervalsTaken++;
            }
        } // O(N)
        return intervals.length - intervalsTaken;

        // Net TC = O(NlogN + N)
        // Net SC = O(1)
    }
}
