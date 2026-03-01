class Solution {
    public int minPartitions(String n) {
        int ret = 0;
        for (int i = 0; i < n.length(); i++){
            ret = Math.max(ret, n.charAt(i) - '0');
        }
        return ret;
    }
}
