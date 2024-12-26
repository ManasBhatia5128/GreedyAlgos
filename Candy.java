import java.util.ArrayList;
import java.util.List;

public class Candy {
    public static void main(String[] args) {
        int[] arr = {1,2,87,87,87,2,1};
        System.out.println(candy(arr));
    }

    // My bruteforce solution: it's correct but it is taking
    // O(N) {adding initally} + O(N^2) {correcting the values} + O(N) {finding final ans}
    

    static int candy(int[] arr){
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
}

class PairNew{
    int num;
    int candies;
    PairNew(int num, int candies){
        this.num = num;
        this.candies = candies;
    }
}