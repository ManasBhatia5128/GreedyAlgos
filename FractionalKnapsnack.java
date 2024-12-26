import java.util.ArrayList;
import java.util.List;

public class FractionalKnapsnack {
    double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {
        // code here
        // My soch: sort elements by value/kg and then add
        double totalMaxValue = 0;
        List<Elem> list = new ArrayList<>();
        for (int i = 0; i < val.size(); i++) {
            list.add(new Elem(val.get(i), wt.get(i)));
        }

        /*What Happens in the Comparator:
If the result is positive: b is considered greater than a, meaning b will appear before a in the sorted list.
If the result is negative: a is considered greater than b, so a will appear before b in the sorted list.
If the result is zero: a and b are considered equal in terms of sorting order. */
        // list.sort((a,b) -> b.val/b.wt - a.val/a.wt);

        list.sort((a,b) -> Float.compare((b.val / (float)b.wt), (a.val / (float)a.wt))); // We are using compare method directly which gives val<0 if parm1 < parm2, it gives val > 0 if parm1 > parm2 and thus it sorts on basis of values from low to high
        // that's why: for a,b => sorted in ascending order say 
        int capacityDone = 0;
        for(Elem elem: list){
            if(elem.wt < (capacity - capacityDone)){
                totalMaxValue += (double) elem.val;
                capacityDone += elem.wt;
            }
            else{
                totalMaxValue += (elem.val * (capacity-capacityDone))/elem.wt;
                break;
            }
        }
        double roundedAns = Double.parseDouble(String.format("%.6f", totalMaxValue));
        return roundedAns;
    }
}

class Elem{
    int val;
    int wt;
    Elem(int val, int wt){
        this.val = val;
        this.wt = wt;
    }
}