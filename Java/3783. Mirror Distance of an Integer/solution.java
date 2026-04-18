class Solution {

    public int reverse(int n){
        String reversedStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        return Integer.parseInt(reversedStr);
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }
}
