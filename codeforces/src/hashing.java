import java.util.ArrayList;

class HashedString {
    public static final long M = 911382323L;
    public static final long B = 972663749L;
    private static ArrayList<Long> pow = new ArrayList();
    private long[] pHash;

    public HashedString(char[]s) {
        if (pow.isEmpty()) {
            pow.add(1L);
        }
        while(pow.size() <= s.length + 1) {
            pow.add((Long)pow.get(pow.size() - 1) * 972663749L % 911382323L);
        }
        this.pHash = new long[s.length + 1];
        this.pHash[0] = 0L;

        for(int i = 0; i < s.length; ++i) {
            this.pHash[i + 1] = (this.pHash[i] * 972663749L % 911382323L + (long)s[i]) % 911382323L;
        }

    }

    public long getHash(int start, int end) {
        long rawVal = this.pHash[end + 1] - this.pHash[start] * (Long)pow.get(end - start + 1);
        return (rawVal % 911382323L + 911382323L) % 911382323L;
    }
}