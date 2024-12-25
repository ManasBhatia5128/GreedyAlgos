public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(recursiveApproach("(*))", 0, 0));
    }
    static boolean approach1(String s){
        // Basically we will take a counter variable which does +1 for '(' and -1 for ')'
        // However we have to take care of the edge case of "())(", in this case counter at end is still 0 but it is invalid since a parenthesis cannot close before opening, so add a check to return false if at any moment counter < 0

        int count = 0;
        int i = 0;
        while(i < s.length()){
            if(count < 0){
                return false;
            }
            if(s.charAt(i) == '('){
                count++;
            }
            else if(s.charAt(i) == ')'){
                count--;
            }
            i++;
        }
        return true;
    }

    // But in case of artestik you have to think more
    // We are solving using recursion: say you encounter a *, now you have three choices: change it to '(' or ')' or '""'
    static boolean recursiveApproach(String s, int count, int index) {
        if(count < 0){
            return false;
        }
        if(index == s.length()){
            return count == 0;
        }

        if(s.charAt(index) == '('){
            return recursiveApproach(s, count+1, index+1);
        }
        else if(s.charAt(index) == ')'){
            return recursiveApproach(s, count-1, index+1);
        }
        else{
            boolean case1 = recursiveApproach(s.substring(0, index) + '(' + s.substring(index+1, s.length()), count+1, index+1);
            boolean case2 = recursiveApproach(s.substring(0, index) + ')' + s.substring(index+1, s.length()), count-1, index+1);
            boolean case3 = recursiveApproach(s.substring(0, index) + " " + s.substring(index+1, s.length()), count, index+1);
            return case1 || case2 || case3;
        }
    }    
    // TC = O(3^N) due to three branches
    // SC = O(N) 
}
