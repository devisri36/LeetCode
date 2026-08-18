class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr = new int[nums.length];
        int size = 0;
        for(int x : nums){
            int l = 0, h = size;
            while(l != h){
                int m = (l + h) / 2;
                if(arr[m] < x){
                    l = m + 1;
                }
                else h = m;
            }
            arr[l] = x;
            if(l == size)size++;
        }
        return size;
    } 
}