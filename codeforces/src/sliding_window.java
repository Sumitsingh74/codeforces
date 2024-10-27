import java.util.*;
class Solution {
    static int []prime = new int[10000001];
    static int []k = new int[10000001];
    public static void Sieve() {
        for (int i = 1; i < 10000001; i++)
            k[i] = i;
        for (int i = 2; i < 10000001; i++) {
            if (prime[i] == 0)
                for (int j = i; j < 10000001; j += i) {
                    prime[j] = 1;
                    while (k[j] % (i * i) == 0)
                        k[j] /= (i * i);
                }
        }
    }

    // sieve for square;

    public static String minWindow(String s, String t)
    {
        if(s == null || s.length() < t.length() || s.length() == 0)
        {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray())
        {
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        int mapCounter = map.size();
        int n = s.length();
        int l = 0, r = 0;
        int start = 0, maxLen = 0;
        for(r = 0; r < n; r++)
        {
            char curR = s.charAt(r);
            if(map.containsKey(curR))
            {
                map.put(curR, map.get(curR)-1);
                if(map.get(curR) == 0)
                    mapCounter--;

                // got soltion
                if(mapCounter == 0)
                {
                    while(l < n && mapCounter == 0)
                    {
                        char curL = s.charAt(l);
                        if(map.containsKey(curL))
                        {
                            map.put(curL, map.get(curL)+1);
                            if(map.get(curL) > 0)
                                mapCounter++;
                        }
                        l++;
                    }
                    if(maxLen > r-l+2 || maxLen == 0)
                    {
                        maxLen = (r-l) + 2;
                        start = l-1;
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }
    public static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size()-1;//lower bonud for list
         while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int t=1;
        while (t-->0){
            int n=s.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)arr[i]=s.nextInt();
            List<Integer> temp = new ArrayList<>();
            temp.add(arr[0]);
            int len = 1;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > temp.get(temp.size() - 1)) {
                    temp.add(arr[i]);
                    len++;
                } else {
                    int ind = lowerBound(temp, arr[i]);
                    temp.set(ind, arr[i]);
                }
            }
            System.out.println(len);
        }
    }
}

class SparseTableMin {
    int table[][], logTable[], powers[];
    int a[];

    public SparseTableMin(int a[]) {
        this.a = a;
        logTable = new int[a.length + 1];
        for (int i = 2; i <= a.length; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }
        int maxLog = logTable[a.length] + 1;
        table = new int[a.length][maxLog];
        powers = new int[maxLog];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }
        for (int i = 0; i < a.length; i++) {
            table[i][0] = a[i];
        }
        for (int i = 1; i < maxLog; i++) {
            for (int j = 0; j + powers[i] - 1 < a.length; j++) {
                table[j][i] = Math.min(table[j][i - 1], table[j + powers[i - 1]][i - 1]);
            }
        }
    }

    int query(int l, int r) {
        int log = logTable[r - l + 1];
        return Math.min(table[l][log], table[r - powers[log] + 1][log]);
    }
}

class SparseTable {
    int table[][], logTable[], powers[];
    int a[];

    public SparseTable(int a[]) {
        this.a = a;
        logTable = new int[a.length + 1];
        for (int i = 2; i <= a.length; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }
        int maxLog = logTable[a.length] + 1;
        table = new int[a.length][maxLog];
        powers = new int[maxLog];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }
        for (int i = 0; i < a.length; i++) {
            table[i][0] = a[i];
        }
        for (int i = 1; i < maxLog; i++) {
            for (int j = 0; j + powers[i] - 1 < a.length; j++) {
                table[j][i] = Math.max(table[j][i - 1], table[j + powers[i - 1]][i - 1]);
            }
        }
    }

    int query(int l, int r) {
        int log = logTable[r - l + 1];
        return Math.max(table[l][log], table[r - powers[log] + 1][log]);
    }
}


class SparseTableGCD {
        long[][]table;int[] logTable, powers;int[] a;
        public SparseTableGCD(int a[]) {
            this.a = a;
            logTable = new int[a.length + 1];
            for (int i = 2; i <= a.length; i++) {
                logTable[i] = logTable[i / 2] + 1;
            }
            int maxLog = logTable[a.length] + 1;
            table = new long[a.length][maxLog];
            powers = new int[maxLog];
            powers[0] = 1;
            for (int i = 1; i < powers.length; i++) {
                powers[i] = powers[i - 1] * 2;
            }
            for (int i = 0; i < a.length; i++) {
                table[i][0] = a[i];
            }
            for (int i = 1; i < maxLog; i++) {
                for (int j = 0; j + powers[i] - 1 < a.length; j++) {
                    table[j][i] = gcd(table[j][i - 1], table[j + powers[i - 1]][i - 1]);
                }
            }
        }
        long query(int l, int r) {
            int log = logTable[r - l + 1];
            return gcd(table[l][log], table[r - powers[log] + 1][log]);
        }

        public static long gcd(long a, long b) {
            if(b == 0) return a;
            return gcd(b , a % b);
        }
    }