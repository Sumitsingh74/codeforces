import java.util.*;
import java.util.ArrayList;

// maximum length of the sub arraywith and =x;
public class graph {
//    static class pair {
//        int a , b;
//        public pair(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//    }
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
//        ArrayList<Integer>[] list=new ArrayList[n+1];
//        for(int i=0;i<=n;i++)list[i]=new ArrayList<>(n);

        ArrayList<pair>[]lists=new ArrayList[n+1];
        for(int i=0;i<=n;i++)lists[i]=new ArrayList<>(n);

        for(int i=0;i<10;i++){
            int x=s.nextInt();int y=s.nextInt();int w=s.nextInt();
            lists[x].add(new pair(y,w));
            lists[y].add(new pair(x,w));}



        System.out.flush();
    }
}
class pair {
    int x;int y;
    pair(int x,int y){
        this.x=x;this.y=y;
    }

    public pair(long l, long l1, long x) {
    }

    int getX(){
        return this.x;
    }
    int getY(){
        return this.y;
    }
}
 class Seg {
    int l, r;
    public Seg(int l, int r) {
        this.l=l;
        this.r=r;
    }
}

 class Event implements Comparable<Event> {
    boolean start;
    Seg s;
    public Event(Seg s, boolean start) {
        this.s=s;
        this.start=start;
    }

    int x() {
        if (start) return s.l;
        return s.r;
    }

    public int compareTo(Event o) {
        if (x()!=o.x()) return Integer.compare(x(), o.x());
        if (start==o.start)return 0;
        if (start) return -1;
        return 1;
    }
}



 class MultiSet<T> {

    TreeMap<T, Integer> fre;
    TreeSet<T> set;
    int size;

    public MultiSet() {
        set = new TreeSet<>();
        fre = new TreeMap<>();
        size = 0;
    }

    public MultiSet(Comparator<T> cmp) {
        set = new TreeSet<>(cmp);
        fre = new TreeMap<>(cmp);
        size = 0;
    }

    public void add(T elem) {
        if (fre.get(elem) == null || fre.get(elem) == 0) {
            fre.put(elem, 0);
            set.add(elem);
        }
        fre.put(elem, fre.get(elem) + 1);
        size++;
    }

    public void remove(T elem) {
        if (!set.contains(elem)) return;
        fre.put(elem, fre.get(elem) - 1);
        if (fre.get(elem) == 0) {
            set.remove(elem);
        }
        size--;
    }


    public boolean contains(T elem) {
        return set.contains(elem);
    }
}

class Graph {
    Node[] nodes;
    class Node {
        HashSet<Node> neighbors = new HashSet<>();
        int connectedComponent = -1;
        int id = -1;
        public Node(int id) {
            this.id = id;
        }

    }
    public Graph(int size) {
        nodes = new Node[size];
        for(int i = 0;i<size;i++) {
            nodes[i] = new Node(i);
        }
    }
    public void addEdge(int a, int b) {
        nodes[a].neighbors.add(nodes[b]);
        nodes[b].neighbors.add(nodes[a]);
    }
    public void findConnectedComponents() {
        int cnt = 0;
        for(Node node : nodes) {
            if(node.connectedComponent != -1) continue;
            node.connectedComponent = cnt++;
            findConnectedComponentsDFS(node);
        }
    }
    public void findConnectedComponentsDFS(Node node) {
        for(Node neighbor : node.neighbors) {
            if(neighbor.connectedComponent == -1) {
                neighbor.connectedComponent = node.connectedComponent;
                findConnectedComponentsDFS(neighbor);
            }
        }
    }
    public ArrayList<Integer>[] getConnectedComponentsAsList() {
        int CCCount = -1;
        for(Node node : nodes) {
            CCCount = Math.max(CCCount, node.connectedComponent+1);
        }
        ArrayList<Integer>[] CCs = new ArrayList[CCCount];
        for(int i=0; i<CCCount; i++) {
            CCs[i] = new ArrayList<>();
        }
        for(Node node : nodes) {
            CCs[node.connectedComponent].add(node.id);
        }
        return CCs;
    }
}





 class DisjointSet {
    int[]rank;int[]parent;int[]size;
    public DisjointSet(int n) {
        rank=new int[n+1];parent=new int[n+1];size=new int[n+1];
        for(int i = 0; i <= n; ++i) {
            this.rank[i]=0;
            this.parent[i]=i;
            this.size[i]=1;
        }
    }
    public int findUPar(int node) {
        if (node == (Integer)this.parent[node]) {
            return node;
        } else {
            int ulp = this.findUPar((Integer)this.parent[node]);
            this.parent[node]=ulp;
            return (Integer)this.parent[node];
        }
    }
    public void unionByRank(int u, int v) {
        int ulp_u = this.findUPar(u);
        int ulp_v = this.findUPar(v);
        if (ulp_u != ulp_v) {
            if ((Integer)this.rank[ulp_u] < (Integer)this.rank[ulp_v]) {
                this.parent[ulp_u]= ulp_v;
            } else if ((Integer)this.rank[ulp_v] < (Integer)this.rank[ulp_u]) {
                this.parent[ulp_v]= ulp_u;
            } else {
                this.parent[ulp_v]= ulp_u;
                int rankU = (Integer)this.rank[ulp_u];
                this.rank[ulp_u]=( rankU + 1);
            }
        }
    }
    public void unionBySize(int u, int v) {
        int ulp_u = this.findUPar(u);
        int ulp_v = this.findUPar(v);
        if (ulp_u != ulp_v) {
            if ((Integer)this.size[ulp_u] < (Integer)this.size[ulp_v]) {
                this.parent[ulp_u]=ulp_v;
                this.size[ulp_v]=(Integer)this.size[ulp_v] + (Integer)this.size[ulp_u];
            } else {
                this.parent[ulp_v]= ulp_u;
                this.size[ulp_u]= (Integer)this.size[ulp_u] + (Integer)this.size[ulp_v];
            }
        }
    }
}



 class LowestCommonAncestor {

    private final int nodes[];
    private final int first[];
    private final int height[];
    static int cnt;
    private final SegmentTreeMin seg;

    public LowestCommonAncestor(ArrayList<Integer> g[]) {
        nodes = new int[g.length * 2 - 1];
        first = new int[g.length];
        height = new int[g.length];
        Arrays.fill(first, -1);
        cnt = 0;
        dfs(0, g, 1);
        seg = new SegmentTreeMin(nodes.length - 1, nodes);
    }

    private void dfs(int node, ArrayList<Integer> g[], int lev) {
        first[node] = cnt;
        nodes[cnt++] = node;
        height[node] = lev;
        for (Integer ch : g[node]) {
            if (first[ch] == -1) {
                dfs(ch, g, lev + 1);
                nodes[cnt++] = node;
            }
        }
    }

    public int findLCA(int node1, int node2) {
        int idx1 = first[node1];
        int idx2 = first[node2];
        if (idx1 > idx2) {
            int c = idx1;
            idx1 = idx2;
            idx2 = c;
        }
        return seg.query(1, 0, nodes.length - 1, idx1, idx2);
    }

    private class SegmentTreeMin {

        int size;
        int seg[];

        public SegmentTreeMin(int size, int euler[]) {
            this.size = size;
            seg = new int[size * 4];
            build(1, 0, size, euler);
        }

        private void build(int node, int b, int e, int euler[]) {
            if (b == e) {
                seg[node] = euler[b];
            } else {
                int mid = (b + e) / 2;
                build(node << 1, b, mid, euler);
                build(node << 1 | 1, mid + 1, e, euler);
                int l = seg[node << 1], r = seg[node << 1 | 1];
                seg[node] = (height[l] < height[r]) ? l : r;
            }
        }

        private int query(int node, int b, int e, int L, int R) {
            if (b > R || e < L) {
                return -1;
            }
            if (b >= L && e <= R) {
                return seg[node];
            }
            int mid = (b + e) >> 1;
            int left = query(node << 1, b, mid, L, R);
            int right = query(node << 1 | 1, mid + 1, e, L, R);
            if (left == -1) {
                return right;
            }
            if (right == -1) {
                return left;
            }
            return height[left] < height[right] ? left : right;
        }
    }
}

 class diameter{
    static int N = 100;
    static List<Integer>[] adj = new ArrayList[N];
    static int[] level = new int[N], dist1 = new int[N], dist2 = new int[N];
    static int end1, end2, maxDistance;

    public diameter(int n,ArrayList<Integer>[]lists){
        adj=new List[n+1];
        for(int i=0;i<=n;i++)adj[i]=new ArrayList<>();
        adj=lists.clone();
        level=new int[n+1];dist1=new int[n+1];dist2=new int[n+1];
        end1=0;end2=0;maxDistance=0;
        findFirstEnd(1, 0);
        reset(n);

        // Find the other end of the diameter
        findSecondEnd(end1, 0);

        // Find distances from both ends of the diameter
        findDistancesFromFirst(end1, 0);
        findDistancesFromSecond(end2, 0);
    }
    // Add an edge between nodes u and v

    // DFS to find the farthest node from the given node (to find the first end of the diameter)
    static void findFirstEnd(int node, int parent) {
        level[node] = 1 + level[parent];
        if (level[node] > maxDistance) {
            maxDistance = level[node];
            end1 = node;
        }
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                findFirstEnd(neighbor, node);
            }
        }
    }

    // Reset levels and distances
    static void reset(int n) {
        Arrays.fill(level, 0, n + 1, 0);
        maxDistance = 0;
        dist1[0] = dist2[0] = -1;
    }

    // DFS to find the other end of the diameter
    static void findSecondEnd(int node, int parent) {
        level[node] = 1 + level[parent];
        if (level[node] > maxDistance) {
            maxDistance = level[node];
            end2 = node;
        }
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                findSecondEnd(neighbor, node);
            }
        }
    }

    // DFS to find distances from the first end of the diameter
    static void findDistancesFromFirst(int node, int parent) {
        dist1[node] = 1 + dist1[parent];
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                findDistancesFromFirst(neighbor, node);
            }
        }
    }

    // DFS to find distances from the second end of the diameter
    static void findDistancesFromSecond(int node, int parent) {
        dist2[node] = 1 + dist2[parent];
        for (int neighbor : adj[node]) {
            if (neighbor != parent) {
                findDistancesFromSecond(neighbor, node);
            }
        }
    }
}


class Lowest_lca {

    static int[][] ap;
    static ArrayList<Integer>[] list;
    static int[] depth;

    public static void build(int n, ArrayList<Integer>[] listw) {
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i <= n; i++) {
            for (Integer e : listw[i]) {
                list[i].add(e);
            }
        }
        ap = new int[n + 1][18];
        depth = new int[n + 1];
        dfs(1, 0);
    }

    public static void dfs(int u, int par) {
//        int n = parent.length;
//        int[][] preMat = new int[20][n];
//
//        preMat[0] = parent;
//
//        for(int i = 1; i < 20; i++) {
//            for(int j = 0; j < n; j++) {
//                if(preMat[i - 1][j] != n) {
//                    preMat[i][j] = preMat[i - 1][preMat[i - 1][j]];
//                }
//                else {
//                    preMat[i][j] = n;
//                }
//            }
//        }
//
//        return preMat;

        ap[u][0] = par;
        for (int i = 1; i <= 17; i++) {
            if (ap[u][i - 1] != 0) {
                ap[u][i] = ap[ap[u][i - 1]][i - 1];
            }
        }
        for (int v : list[u]) {
            if (v != par) {
                depth[v] = depth[u] + 1;
                dfs(v, u);
            }
        }
    }

    public static int find_kth_parent(int u, int k) {
        int count = 0;
        while (k != 0) {
            if (k % 2 == 1) {
                u = ap[u][count];
            }
            count++;
            k = k >> 1;
        }
        return u;
    }

    public static int lca(int node1, int node2) {
        if (depth[node1] > depth[node2]) {
            int temp = node1;
            node1 = node2;
            node2 = temp;
        }

        int diff = depth[node2] - depth[node1];
        node2 = find_kth_parent(node2, diff);

        if (node1 == node2) return node1;

        for (int i = 17; i >= 0; i--) {
            if (ap[node1][i] != ap[node2][i]) {
                node1 = ap[node1][i];
                node2 = ap[node2][i];
            }
        }
        return ap[node1][0];
    }
}


 class SegmentTreeMin {

    int size;
    int seg[];
    int lazy[];
    int arr[];

    public SegmentTreeMin(int size, int a[]) {
        this.size = size;
        arr = a;
        seg = new int[size * 4];
        lazy = new int[size * 4];
        build(1, 1, size, a);
    }

    private void build(int idx, int s, int e, int a[]) {
        if (s == e) {
            seg[idx] = a[s];
            return;
        }
        build(idx * 2, s, (s + e) / 2, a);
        build(idx * 2 + 1, (s + e) / 2 + 1, e, a);
        seg[idx] = Math.min(seg[idx * 2], seg[idx * 2 + 1]);
    }

    void process(int idx, int s, int e) {
        seg[idx] += lazy[idx];
        if (s < e) {
            lazy[idx * 2] += lazy[idx];
            lazy[idx * 2 + 1] += lazy[idx];
        }
        lazy[idx] = 0;
    }

    void updateRange(int idx, int s, int e, int l, int r, long val) {
        process(idx, s, e);
        if ((l > e) || s > r) {
            return;
        }
        if (s >= l && e <= r) {
            lazy[idx] += val;
            process(idx, s, e);
            return;
        }
        updateRange(idx * 2, s, (s + e) / 2, l, r, val);
        updateRange(idx * 2 + 1, (s + e) / 2 + 1, e, l, r, val);
        seg[idx] = Math.min(seg[idx * 2], seg[idx * 2 + 1]);
    }


    long minInRange(int idx, int s, int e, int l, int r) {
        process(idx, s, e);
        if ((l > e) || s > r) {
            return Long.MAX_VALUE;
        }
        if (s >= l && e <= r) {
            return seg[idx];
        }
        return Math.min(minInRange(idx * 2, s, (s + e) / 2, l, r), minInRange(idx * 2 + 1, (s + e) / 2 + 1, e, l, r));
    }
}