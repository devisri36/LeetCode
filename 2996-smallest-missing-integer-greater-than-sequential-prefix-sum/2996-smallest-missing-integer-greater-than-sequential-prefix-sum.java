class Solution {
    public int missingInteger(int[] nums) {
        int n = nums.length;
        boolean[] ht = new boolean[1276];
        int sum = nums[0];
        for(int i = 0;i < n;i++){
            ht[nums[i]] = true;
        }
        for(int i = 1;i < n && nums[i] == nums[i - 1] + 1;sum += nums[i++]);
        while(ht[sum])sum++;
        return sum;
    }
}