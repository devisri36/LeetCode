class Solution {
    public String solve(int n, int[] freqIn, String curr, char mid, String target){
        int[] freq = freqIn.clone();
        for(int i = 25;i >= 0;i--){
            while(freq[i] > 0){
                curr += (char)('a' + i);
                freq[i]--;
            }
        }
        if(mid != '#'){
            String temp = curr;
            curr += mid;
            temp = new StringBuilder(temp).reverse().toString();
            curr += temp;
        }
        else{
            String temp = curr;
            temp = new StringBuilder(temp).reverse().toString();
            curr += temp;
        }
        return curr.compareTo(target) > 0 ? curr : "";
    }
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq = new int[26];
        int n = s.length();
        if(n == 1){
            if(s.compareTo(target) > 0)return s;
            else return "";
        }
        for(char c: s.toCharArray())freq[c - 'a']++;
        char mid = '#';
        int oc = 0;
        for(int i = 0;i < 26;i++){
            if(freq[i] % 2 != 0){
                mid = (char) ('a' + i);
                freq[i]--;
                oc++;
            }
            freq[i] /= 2;
            if(oc >= 2)return "";
        }
        n /= 2;
        String ans = "", prefix = "";
        for(int i = 0;i < n;i++){
            String curr = prefix;
            boolean isAny = false;
            for(int j = 0;j < 26;j++){
                if(freq[j] > 0){
                    freq[j]--;
                    curr += (char)('a' + j);
                    String sol = solve(n, freq, curr, mid, target);
                    if(!sol.equals("")){
                        prefix = curr;
                        isAny = true;
                        if(ans.equals(""))ans = sol;
                        else ans = ans.compareTo(sol) < 0 ? ans : sol;
                        break;
                    }
                    freq[j]++;
                    curr = curr.substring(0, curr.length() - 1);
                }
            }
            if(!isAny)return "";
        }
        return ans;

    }
}