class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        
        for (int i = 0; i < letters.length; i++){
            if (target -97 < letters[i] -97) return letters[i];
        }
        return letters[0];
    }
}
