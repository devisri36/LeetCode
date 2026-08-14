class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> count = new HashMap<>();
        int j = 0;
        int res = 0;
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
            while(count.get(c) > 2){
                char left = s.charAt(j);
                count.put(left, count.get(left) - 1);
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}