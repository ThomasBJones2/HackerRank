public class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length - 1; 
        int max = 0;
        while(lo < hi){
            int minHeight = Math.min(height[lo], height[hi]);
            max = Math.max(max, minHeight*(hi - lo));
            while(lo <= hi && height[lo] <= minHeight) lo ++;
            while(lo <= hi && height[hi] <= minHeight) hi --;
        }
        return max;
    }
}
