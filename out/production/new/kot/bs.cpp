#include <bits/stdc++.h>
using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef long long ll;
typedef pair<int, int> pii;
typedef vector<int> vi;
typedef pair<ll, ll> pll;
typedef vector<ll> vl;

const ll INF = 1e18 + 10;
const ll inf = 1e9 + 10;
const ll N = 1e5 + 10;
const ll mod1 = 1e9 + 7;
const ll mod2 = 998244353;

void transcendent(int tc) {
    int n, T;
    cin >> n >> T;
    vector<int> a(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    int lo = 1, hi = n;
    map<int, int> pos, nxt;
    for (int i = n; i >= 1; i--) {
        if (!pos[a[i]]) pos[a[i]] = inf;
        nxt[i] = pos[a[i]];
        pos[a[i]] = i;
    }
    auto check = [&](int k) {
        int t = 0;
        map<int, int> prev;
        set<pll> hv;
        set<int> st;
        for (int i = 1; i <= n; i++) {
            if (!st.count(a[i])) {
                t++;
                if ((int)st.size() == k) {
                    auto it = *hv.rbegin();
                    auto y = it.first, x = it.second;
                    hv.erase(--hv.end());
                    st.erase(x);
                    prev[x] = 0;
                }
                st.insert(a[i]);
                prev[a[i]] = i;
                hv.insert({nxt[i], a[i]});
            } else {
                hv.erase({nxt[prev[a[i]]], a[i]});
                prev[a[i]] = i;
                hv.insert({nxt[i], a[i]});
            }
        }
        return t <= T;
    };
    while (hi - lo > 1) {
        int mid = (hi + lo) >> 1;
        if (check(mid))
            hi = mid;
        else
            lo = mid + 1;
    }
    if (check(lo)) hi = lo;
    cout << hi << endl;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);

    int test = 1;
    cin >> test;
    for (int tc = 1; tc <= test; tc++) {
        transcendent(tc);
    }

    return 0;
}