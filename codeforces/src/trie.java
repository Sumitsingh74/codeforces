import java.io.*;
import java.util.*;

public class trie {

    static class BinaryTrie<T extends Number> {
        ArrayList<int[]> trie;
        final int B;

        int createNode() {
            int id = trie.size();
            trie.add(new int[2]);
            return id;
        }

        BinaryTrie(int B) {
            this.B = B;
            trie = new ArrayList<>();
            createNode();
        }

        int add(int x) {
            int curr = 0;
            for (int i = B; i >= 0; i--) {
                int v = (x >> i) & 1;
                if (trie.get(curr)[v] == 0) {
                    trie.get(curr)[v] = createNode();
                }
                curr = trie.get(curr)[v];
            }
            return curr;
        }

        int getXorMax(int x) {
            int res = 0;
            int curr = 0;
            for (int i = B; i >= 0; i--) {
                int v = (x >> i) & 1;
                if (trie.get(curr)[v ^ 1] != 0) {
                    res |= (1 << i);
                    v ^= 1;
                }
                curr = trie.get(curr)[v];
            }
            return res;
        }
    }

    static void solve(InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        ArrayList<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }

        BinaryTrie<Integer>[] dp = new BinaryTrie[n];
        ArrayList<Integer>[] val = new ArrayList[n];
        for (int i = 0; i < n; i++) val[i] = new ArrayList<>();
        int[] ans = a.clone();

        dfs(0, -1, 0, a, g, dp, val, ans);

        for (int i = 0; i < n; i++) out.println(ans[i]);
    }

    static void dfs(int u, int p, int cum, int[] a, ArrayList<Integer>[] g, BinaryTrie<Integer>[] dp, ArrayList<Integer>[] val, int[] ans) {
        cum ^= a[u];
        val[u].add(cum);
        dp[u] = new BinaryTrie<>(29);
        dp[u].add(cum);
        for (int v : g[u]) {
            if (v != p) {
                dfs(v, u, cum, a, g, dp, val, ans);
                ans[u] = Math.max(ans[u], ans[v]);
                if (val[u].size() < val[v].size()) {
                    ArrayList<Integer> tempVal = val[u];
                    val[u] = val[v];
                    val[v] = tempVal;

                    BinaryTrie<Integer> tempDp = dp[u];
                    dp[u] = dp[v];
                    dp[v] = tempDp;
                }
                for (int x : val[v]) {
                    ans[u] = Math.max(ans[u], dp[u].getXorMax(x ^ a[u]));
                }
                for (int x : val[v]) {
                    dp[u].add(x);
                    val[u].add(x);
                }
                val[v].clear();
            }
        }
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) solve(in, out);
        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

 class FenwickTree {
    private int[] bit;
    private int n;

    // Constructor to initialize the BIT with a given size
    public FenwickTree(int size) {
        this.n = size;
        this.bit = new int[size + 1]; // BIT is 1-indexed, so we need an array of size n+1
    }

    // Method to update the BIT at index 'index' by adding 'value'
    public void update(int index, int value) {
        int currentValue = query(index) - query(index - 1); // Find the current value at index
        int delta = value - currentValue; // Calculate the difference needed to update the value

        // Update BIT with the difference
        for (; index <= n; index += index & -index) {
            bit[index] += delta;
        }
    }

    // Method to get the prefix sum up to index 'index'
    public int query(int index) {
        int sum = 0;
        for (; index > 0; index -= index & -index) {
            sum += bit[index];
        }
        return sum;
    }

    // Method to get the sum between two indices (inclusive)
    public int rangeQuery(int left, int right) {
        return query(right) - query(left - 1);
    }

    // Method to initialize BIT with an array (1-indexed)
    public void buildFromArray(int[] arr) {
        for (int i = 1; i <= n; i++) {
            update(i, arr[i]);
        }
    }
}