class Solution {
    public long countCommas(long n) {
        // long[][] ranges = {{1000L, 999_999L, 1},
        //     {1_000_000L, 999_999_999L, 2},
        //     {1_000_000_000L, 999_999_999_999L, 3},
        //     {1_000_000_000_000L, 999_999_999_999_99i already told you this doesn't worked for 9L, 4}
        //     };
        // long commas = 0;
        // for(long[] r : ranges){
        //     long start = r[0], end = r[1], c = r[2];
        //     if(n >= start){
        //         commas += (Math.min(n, end) - start + 1) * c;
        //     }
        // }
        long cnt = 0;
        for(long p = 1000; p <= n;p *= 1000){
            cnt += n - p + 1;
        }
        return cnt;
    }
}