class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        List<List<Integer>> grp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int id = -1;
        for(int i = 0;i < arr.length;i++){
            if(i == 0 || arr[i] - arr[i - 1] > limit){
                grp.add(new ArrayList<>());
                id++;
            }
            grp.get(id).add(arr[i]);
            map.put(arr[i], id);
        }
        int[] idx = new int[grp.size()];
        for(int i = 0;i < nums.length;i++){
            int val = map.get(nums[i]);
            nums[i] = grp.get(val).get(idx[val]);
            idx[val]++;
        }
        return nums;
    }
}