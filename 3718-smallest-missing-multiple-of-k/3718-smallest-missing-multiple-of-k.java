class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> seen = new HashSet<>();
        for(int num: nums){
            seen.add(num);
        }
        int val = k;
        while(seen.contains(val)){
            val += k;
        }
        return val;
    }
}