class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum = 0;
        int prefix = 0;
        for(int i = 0;i < n;i++){
            prefix += nums[i];
            int req = prefix - k;
            if(hm.containsKey(req)){
                sum += hm.get(req);
            }
            hm.put(prefix, hm.getOrDefault(prefix, 0) + 1);
        }
        return sum;
    }
}