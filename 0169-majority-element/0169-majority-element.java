class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;
        for(int val : nums){
            if(cnt == 0)candidate = val;
            if(val == candidate)cnt++;
            if(val != candidate)cnt--;
        }
        return candidate;
    }
}