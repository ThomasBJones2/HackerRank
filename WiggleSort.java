//This sorts a list in O(1) extra memory and O(n) time into a list
//with num 1 < num 2 > num 3 < num 4 > num 5...
//for example [1,1,1,3,6,2] -> [1,2,1,3,1,6]

import java.util.Random;

public class Solution {
    int length;
    
    public void wiggleSort(int[] nums) {
        int median = getMedian(nums);   
        length = nums.length;
        int curr = 0;
        int left = 0;
        int right = nums.length - 1;
        while (curr <= right) {
            if (nums[mapping(curr)] > median) {
                switcher(nums, mapping(curr), mapping(left));
                curr++;
                left++;
            } else if (nums[mapping(curr)] < median) {
                switcher(nums, mapping(curr), mapping(right));
                right--;
            } else {
                curr++;
            }
        }
    }
    
        
    private int mapping(int i) {
        return (i * 2 + 1) % (length | 1);
    }
    

    int getMedian(int[] nums){
        Random rand = new Random();

        int pivot_count = 0;
        int floor = 0;
        int ceil = nums.length;
        while(pivot_count != nums.length/2){
            pivot_count = rand.nextInt(ceil - floor) + floor;
            switcher(nums, pivot_count, floor);
            pivot_count = floor;
            for(int i = floor + 1; i < ceil; i ++){
                if(nums[i] < nums[pivot_count]){
                    if(i == pivot_count + 1){
                        switcher(nums, i, pivot_count);
                    }
                    else{
                        switcher(nums, pivot_count + 1, i);
                        switcher(nums, pivot_count, pivot_count + 1);
                    }
                    pivot_count ++;
                }
            }
            if(nums.length/2 > pivot_count){
                floor = pivot_count + 1;
            } else {
                ceil = pivot_count;
            }
        }
        return nums[pivot_count];
    }
    
    void switcher(int[] nums, int first, int second){
        int temp = nums[second];
        nums[second] = nums[first];
        nums[first] = temp;
    }
}
