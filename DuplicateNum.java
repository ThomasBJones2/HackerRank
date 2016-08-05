public class Solution {
    HashSet<Integer> evenKey;
    public int[] singleNumber(int[] nums) {
        evenKey = new HashSet<>();
        
        for(int i = 0; i < nums.length; i ++){
            if(!evenKey.contains(nums[i]))
                evenKey.add(nums[i]);
            else
                evenKey.remove(nums[i]);
        }
        int[] out = new int[2];
        int j = 0;
        for(Integer i : evenKey){
            if(j <= 1)
                out[j] = i;
            j ++;
        }
        return out;
    }
}
