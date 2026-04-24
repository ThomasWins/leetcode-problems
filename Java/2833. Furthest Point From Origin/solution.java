class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        
        int n = moves.length();
        int numL = 0, numR = 0;

        for (int i = 0; i < n; i++){
            if (moves.charAt(i) == 'L'){
                numL++;
                numR--;
            } else if (moves.charAt(i) == 'R'){
                numR++;
                numL--;
            } else{
                numR++;
                numL++;
            }
        }
        if (numL >= numR) return numL;
        return numR;
    }
}
