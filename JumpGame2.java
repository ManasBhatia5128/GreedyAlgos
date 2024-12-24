public class JumpGame2 {
    public static void main(String[] args) {
        int[] arr = {2,3,1,1,4};
        System.out.println(recursionHelper(arr, 0, 0));
    }

    static int recursionHelper(int[] arr, int index, int jumps){
        if(index >= arr.length-1){
            return jumps;
        }
        int min = Integer.MIN_VALUE;
        for(int i = 1; i < arr.length; i++){
            min = Math.min(min, recursionHelper(arr, index+1, jumps+1));
        }
        return min;
    }
}
