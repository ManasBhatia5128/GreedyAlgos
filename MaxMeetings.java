import java.util.ArrayList;

public class MaxMeetings {
    public static void main(String[] args) {
        // Basically our greedy approach is to finish a meeting as soon as possible
        // ending time should be as low as possible
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] e = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(s, e));
    }

    static int maxMeetings(int[] start, int[] end){
        if(start.length == 1){
            return 1;
        }
        ArrayList<Pair> meets = new ArrayList<>();
        for (int i = 0; i < end.length; i++) {
            Pair toAdd = new Pair(start[i], end[i]);
            meets.add(toAdd);
        }
        meets.sort((n1, n2) -> n1.end-n2.end);
        int prevEnd = meets.get(0).end;
        int maxMeets = 1;
        for (int i = 1; i < meets.size(); i++) {
            if(meets.get(i).start > prevEnd){
                prevEnd = meets.get(i).end;
                maxMeets++;
            }
        }
        return maxMeets;
    }
}

class Pair {
    int start;
    int end;

    Pair(int s, int e) {
        this.start = s;
        this.end = e;
    }
}