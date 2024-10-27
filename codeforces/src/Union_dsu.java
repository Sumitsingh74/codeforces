//static class UnionFind{
//    int[] rank;
//    int[] root;
//    int[] diameters;
//    public UnionFind(int n){
//        this.root = new int[n];
//        this.rank = new int[n];
//        this.diameters = new int[n];
//        for(int i=0;i<n;i++){
//            root[i] = i;
//            rank[i] = 1;
//        }
//    }
//
//    public int find(int v){
//        if(v == root[v]) return v;
//        return root[v] = find(root[v]);
//    }
//
//    public boolean isConnected(int x, int y){
//        return find(x) == find(y);
//    }
//
//    public boolean union(int x, int y,boolean merge){
//        int rootX = find(x);
//        int rootY = find(y);
//        if(rootX == rootY) return false;
//        if(rank[rootX] > rank[rootY]) {
//            root[rootY] = rootX;
//            if(merge) diameters[rootX] = Math.max(diameters[rootX]/2 + diameters[rootY]/2 + diameters[rootX]%2 + diameters[rootY]%2 + 1,Math.max(diameters[rootX],diameters[rootY]));
//        }
//        else if(rank[rootY] > rank[rootX]){
//            root[rootX] = rootY;
//            if(merge) diameters[rootY] = Math.max(diameters[rootX]/2 + diameters[rootY]/2 + diameters[rootX]%2 + diameters[rootY]%2 + 1,Math.max(diameters[rootX],diameters[rootY]));
//        }
//        else{
//            rank[rootX]++;
//            root[rootY] = rootX;
//            if(merge) diameters[rootX] = Math.max(diameters[rootX]/2 + diameters[rootY]/2 + diameters[rootX]%2 + diameters[rootY]%2 + 1,Math.max(diameters[rootX],diameters[rootY]));
//        }
//        return true;
//    }
//    public boolean onlyOneRoot(){
//        int root1 = find(0);
//        for(int i=1;i<root.length;i++) if(root1!=find(i)) return false;
//        return true;
//    }
//}