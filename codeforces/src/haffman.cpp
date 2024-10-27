#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());
ll uid(ll l, ll r) { return uniform_int_distribution<ll>(l, r)(rng); }
int main()
{
    freopen("out.txt", "w+", stdout);
    ll n=uid(100000,100000);
    cout<<n<<endl;
    for(int i=0;i<n;i++){
        int a=uid(10000000,10000000+(2*n/3));
        cout<<a<<" ";
    }
    cout<<endl;
    // vector<vector<int>> tc;
    // int t = 100, remn = 1e5;
    // while(t--){
    //     if(remn == 0) break;
    //     ll n = uid(1, min(10000,remn));
    //     vector<int> a(n);
    //     for(int i = 0 ; i < n ; i ++){
    //         a[i] = uid(0 , 10);
    //     }
    //     tc.push_back(a);
    //     remn -= n;
    //     //break;
    // }
    // int sz = tc.size();
    // //assert(sz >= 1 && sz <= 100);
    // cout << sz << endl;
    // for(int i = 0 ; i < sz ; i ++){
    //     int tsz = tc[i].size();
    //     cout << tc[i].size() << endl;
    //     //assert(tsz >= 1 && tsz <= 100000);
    //     for(auto it: tc[i]){
    //         //assert(it >= 1 && it <= 100);
    //         cout << it << " ";
    //     }
    //     cout << endl;
    // }


    // ll t=uid(1,100000);
    // cout<<t<<endl;
    // ll d=uid(0,1);
    // ll a=uid(1000000000,1000000000);
    // ll b=a;
    // ll c=uid(1000000000,1000000000);
    // while(!(a!=b && (a>=c || b>=c))){
    //     a=uid(0,1000000000);
    //     b=uid(0,1000000000);
    //     c=uid(0,1000000000);
    // }
    //cout<<a<<" "<<b<<" "<<c<<" "<<d<<endl;
    //ll n=1000000000;
    // while(t--){
    //     cout<<n<<endl;
        //n--;
        // ll x=uid(1,1000000000);
        // ll y=uid(1,1000000000);
        //cout<<n<<" "<<x<<" "<<y<<" "<<endl;
        // cout<<n<<endl;
        // for(ll i=1;i<=n;i++){
        //     ll x=uid(1,1000000);
        //     cout<<x<<" ";
        // }
        // cout<<endl;
        // ll m=uid(100000,100000);
        // cout<<m<<endl;
        // for(int i=0;i<m;i++){
        //     cout<<"1 100000"<<endl;
        // }
        //ll n=uid((ll)1e18,(ll)1e18);
        //ll m=uid(1,min(n,(ll)1e9));
        //cout<<n<<" "<<m<<endl;
    //}
    // vector<vector<int>> tc;
    // int t = 100000, remn = 100000;
    // while (t--)
    // {
    //     if (remn == 0)
    //         break;
    //     ll n = uid(1, min(100000, remn));
    //     vector<int> a(2 * n);
    //     for (int i = 0; i < 2 * n; i++)
    //     {
    //         a[i] = uid(1, 100);
    //     }
    //     tc.push_back(a);
    //     remn -= n;
    // }
    // int sz = tc.size();
    // assert(sz >= 1 && sz <= 100000);
    // cout << sz << endl;
    // for (int i = 0; i < sz; i++)
    // {
    //     int tsz = tc[i].size();
    //     cout << tc[i].size() / 2 << endl;
    //     assert(tsz >= 1 && tsz <= 200000);
    //     for (auto it : tc[i])
    //     {
    //         assert(it >= 1 && it <= 100);
    //         cout << it << " ";
    //     }
    //     cout << endl;
    // }
    return 0;
}
