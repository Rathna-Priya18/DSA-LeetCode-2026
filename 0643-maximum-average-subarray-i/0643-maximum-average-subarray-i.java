class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int right=0;right<n;right++){
            sum += nums[right];
            if(right - left+1 == k){
                max = Math.max(max,sum);
                sum -= nums[left];
                left++;
            }
        }
        double avg = (double) max / k;
        return (double) avg ;
    }
}