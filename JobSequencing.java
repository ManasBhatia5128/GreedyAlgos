import java.util.ArrayList;
import java.util.HashMap;

public class JobSequencing {
    public static void main(String[] args) {
        System.out.println();
        int[] id = {1,2,3,4};
        int[] job = {4,1,1,1};
        int[] profit = {20,10,40,30};
        System.out.println(jobSequenc(id, job, profit));
    }

    static ArrayList<Integer> jobSequenc(int[] id, int[] deadline, int[] profit) {
        // code here..
        int ans = 0;
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < id.length; i++){
            if(hash.containsKey(deadline[i])){
                if(hash.get(deadline[i]) < profit[i]){
                    hash.put(deadline[i], profit[i]);
                }
                else{
                    continue;
                }
            }
            else{
                hash.put(deadline[i], profit[i]);
            }
        } 
        for(Integer key: hash.keySet()){
            Integer val = hash.get(key);
            ans += val;
        }
        ArrayList<Integer> finl = new ArrayList<>();
        finl.add(hash.size());
        finl.add(ans);

        return finl;
        // Major flaw in this soch: kisne kaha ye jaruri hai ki 2 day deadline process day 2 pr hi schedule hogi!! bsdk
    }

    // Correct soln: Delay your process as late as possible (greedy soch) so that your upcoming process in high to low order have more days left to be done

    // static ArrayList<Integer> job(int[] id, int[] deadline, int[] profit){
    //     ArrayList<Job> jobs = new ArrayList<>();
    //     for (int i = 0; i < profit.length; i++) {
    //         jobs.add(new Job(id[i], deadline[i], profit[i]));
    //     }
    //     jobs.sort((j1, j2) -> j1.profit - j2.profit);
        
    // }
}

class Job{
    int id;
    int deadline;
    int profit;
    
    Job(int id, int deadline, int profit){
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}