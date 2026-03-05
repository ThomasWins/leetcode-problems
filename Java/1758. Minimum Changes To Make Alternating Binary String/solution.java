class Solution {
    public int minOperations(String s) {
        
        int n = s.length();
        int evenRet = 0, oddRet = 0;

        for (int i = 0; i < n; i++){
            if (i % 2 == 0){
                if (s.charAt(i) - '0' == 0){
                    evenRet++;
                } else {
                    oddRet++;
                }
            } else {
                if (s.charAt(i) - '0' == 0){
                    oddRet++;
                } else {
                    evenRet++;
                }
            }
        }
        return Math.min(oddRet, evenRet);
    }
}
