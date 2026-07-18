class Solution {
    public int maxProduct(int[] nums) {
        //long maxi = Long.MIN_VALUE;
        int n = nums.length;
        // for(int i = 0; i < n;i++){
        //     int prod = 1;
        //     for(int j = i;j < n;i++){
        //         prod *= nums[j];
        //         maxi = Math.max(prod, maxi);
        //     }
        // }
        // return maxi;
        long prefix = 1;
        long suffix = 1;
        long maxi = Long.MIN_VALUE;
        for(int i = 0;i < n;i++){
            if(prefix == 0)prefix = 1;
            if(suffix == 0)suffix = 1;
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            maxi = Math.max(maxi, Math.max(prefix, suffix));
        }
        return (int)maxi;
    }
}