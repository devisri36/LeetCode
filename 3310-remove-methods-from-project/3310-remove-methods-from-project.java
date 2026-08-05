class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] edges = new ArrayList[n];
        for(int i = 0;i < n;i++){
            edges[i] = new ArrayList<>();
        }
        int[] indeg = new int[n];
        for(int[] inv : invocations){
            edges[inv[0]].add(inv[1]);
            indeg[inv[1]]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(k);
        boolean[] sus = new boolean[n];
        sus[k] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v : edges[u]){
                indeg[v]--;
                if(!sus[v]){
                    queue.offer(v);
                    sus[v] = true;
                }
            }
        }
        boolean remove = true;
        List<Integer> rem = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(sus[i] && indeg[i] > 0){
                remove = false;
                break;
            }else if(!sus[i]){
                rem.add(i);
            }
        }
        if(!remove){
            List<Integer> nodes = new ArrayList<>(n);
            for(int i = 0;i < n;i++){
                nodes.add(i);
            }
            return nodes;
        }
        return rem;
    }
}