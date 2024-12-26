public class MinCoinsSum {

    public static void main(String[] args) {
        int[] arr = {9,6,5,2};
        int[] ans = new int[1];
        System.out.println(minSumHelper(arr, 0, 1, ans, 0));
        System.out.println(ans[0]);
    }

    static int minSum(int[] arr, int sum){
        int[] ans = new int[1];
       boolean val = minSumHelper(arr, 0, sum, ans, 0);
        return val ? ans[0]: -1;
    }
    static boolean minSumHelper(int[] arr, int currSum, int sum, int[] ans, int index){
        if(index >= arr.length){
            return false;
        }
        if((currSum == sum && currSum != 0) || sum == 0){
            return true;
        }
        if(currSum > sum){
            ans[0] -= 1;
           return minSumHelper(arr, currSum-arr[index], sum, ans, index+1);
        }
        ans[0] += 1;
       return minSumHelper(arr, currSum + arr[index], sum, ans, index);
    }
}
