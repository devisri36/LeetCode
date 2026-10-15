class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size(), total = 0;
        for(int i = 0;i < n;i++){
            BitSet set = new BitSet(101);
            for(int j = i;j < n;j++){
                set.set(nums.get(j));
                int d = set.cardinality();
                total += d * d;
            }
        }
        return total;
    }
}