class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;
        while(j < nums.length){
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.get(nums[j]) > k){
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }
}