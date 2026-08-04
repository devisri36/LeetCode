class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int mn = Integer.MAX_VALUE;
        int mx = Integer.MIN_VALUE;
        for(int num : nums){
            set.add(num);
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = mn;i <= mx;i++){
            if(!set.contains(i))
                res.add(i);
        }
        return res;
    }
}