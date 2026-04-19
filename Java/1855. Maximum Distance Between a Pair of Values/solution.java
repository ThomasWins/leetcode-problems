class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int n1 = nums1.length, n2 = nums2.length;
        int max = 0;

        for (int i = 0, j = 0; i < n1 && j < n2;){
            if (i <= j && nums1[i] <= nums2[j]){
                max = Math.max(max, j - i);
                j++;
            } 
            else if (i <= j) i++;
            else j++;
        }
        return max;
    }
}


/*  O(n^2) Soultion

class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        
        int n1 = nums1.length, n2 = nums2.length;
        int max = 0;

        for (int i = 0; i < n1; i++){
            for (int j = n2-1; j >= i; j--){
                if (nums1[i] <= nums2[j]){
                    max = Math.max(max, j-i);
                    break;
                }
            }
        }
        return max;
    }
}
*/
