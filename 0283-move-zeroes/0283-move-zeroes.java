class Solution {
    public void moveZeroes(int[] nums) {

        int index = 0;

        // Put all non-zero elements at the beginning
        for(int i = 0; i < nums.length; i++) {

            if(nums[i] != 0) {
                nums[index] = nums[i];
                index++;
            }
        }

        // Fill remaining positions with zero
        while(index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }
}