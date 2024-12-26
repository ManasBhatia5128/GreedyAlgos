import java.util.ArrayList;
import java.util.List;

public class Candy {
    public static void main(String[] args) {
        // int[] arr = {1,2,87,87,87,2,1};
        int[] arr = {5,4,3,2,1};
        // System.out.println(candyBetter(arr));
        System.out.println(candyLinear(arr));
    }

    // My bruteforce solution: it's correct but it is taking
    // O(N) {adding initally} + O(N^2) {correcting the values} + O(N) {finding final ans}
    // Sc = O(N)

    // Basically greedy approach was to assign min number of candies so I tried assigning min possible candy ie 1 to each unless it is visible that neighbours are smaller

    static int candyBrute(int[] arr){
        int ans = 0;
        List<PairNew> list = new ArrayList<>();
        int candies = 1;
        list.add(new PairNew(arr[0], candies));
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > arr[i-1]){
                candies++;
            }
            else if(arr[i] <= arr[i-1]){
                candies = 1;
            }
            list.add(new PairNew(arr[i], candies));
        }

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if(list.get(j).num > list.get(j+1).num && list.get(j).candies == list.get(j+1).candies){
                    list.get(j).candies += 1;
                }
            }
        }

        for(PairNew pt: list){
            ans += pt.candies;
        }
        return ans;
    }

    // slight optimisation: introduce a swapped flag, agar koi change nhi hua toh aage check krne ka koi sense nhi banta hai
    static int candyBetter(int[] arr) {
        int ans = 0;
        List<PairNew> list = new ArrayList<>();
        int candies = 1;
        list.add(new PairNew(arr[0], candies));

        // First pass: Assign minimum candies and keep track of elements
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                candies++;
            } else if (arr[i] <= arr[i - 1]) {
                candies = 1;
            }
            list.add(new PairNew(arr[i], candies));
        }

        // Second pass: Minimize comparisons by early termination
        boolean swapped;
        do {
            swapped = false; // Track if any changes were made
            for (int i = 0; i < arr.length - 1; i++) {
                // If no change needed, skip the iteration
                if (list.get(i).num > list.get(i + 1).num && list.get(i).candies == list.get(i + 1).candies) { // 2nd check is due to the fact that for case of 5, 4, 3 subarray keys are 5, 4, 3 then their is no need of adding, it is only needed for configuration like {5,4,3} ie keys {1,1,1}
                    list.get(i).candies += 1;
                    swapped = true; // A change was made, so continue checking
                }
            }
        } while (swapped); // Repeat the loop only if changes were made

        // Calculate the total number of candies
        for (PairNew pt : list) {
            ans += pt.candies;
        }

        return ans;
    }

    // Accidently saw GPT suggested approach
    static int candyLinear(int[] arr){
        int ans = 0;
        int candies = 1;
        List<PairNew> list = new ArrayList<>();
        list.add(new PairNew(arr[0], candies));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                candies++;
            } else if (arr[i] <= arr[i - 1]) {
                candies = 1;
            }
            list.add(new PairNew(arr[i], candies));
        }
        // Check for i > i+1 in both forward and reverse ways (in order to check for left as well as right element)
        for(int i = 0; i < list.size()-1; i++){
            if(list.get(i).num > list.get(i+1).num && list.get(i).candies == list.get(i + 1).candies){
                list.get(i).candies += 1;
            }
        }
        for (int i = list.size()-2; i >= 0; i--) {
            if(list.get(i).num > list.get(i+1).num && list.get(i).candies <= list.get(i + 1).candies){
                list.get(i).candies = list.get(i+1).candies + 1;
            }
        }

        for(PairNew pt: list){
            ans += pt.candies;
        }
        return ans;
    }
}

class PairNew{
    int num;
    int candies;
    PairNew(int num, int candies){
        this.num = num;
        this.candies = candies;
    }
}