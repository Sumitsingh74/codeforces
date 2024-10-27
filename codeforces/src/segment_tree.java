import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;


public class segment_tree{


    private static class SegmentTree {

        int size;
        int seg[];
        int arr[];

        public SegmentTree(int size) {
            this.size = size;
            seg = new int[size * 4];
        }

        void updateIndex(int idx, int s, int e, int ind, int val) {
            if (ind < s || ind > e) {
                return;
            }
            if (s == ind && ind == e) {
                seg[idx] += val;
                return;
            }
            updateIndex(idx << 1, s, (s + e) / 2, ind, val);
            updateIndex(idx << 1 | 1, (s + e) / 2 + 1, e, ind, val);
            seg[idx] = seg[idx << 1] + seg[idx << 1 | 1];
        }

        int getKth(int idx, int s, int e, int val) {
            if (s == e) {
                return e;
            }
            if (seg[idx << 1] >= val) {
                return getKth(idx << 1, s, (s + e) / 2, val);
            }
            return getKth(idx << 1 | 1, (s + e) / 2 + 1, e, val - seg[idx << 1]);
        }

        int sumInRange(int idx, int s, int e, int l, int r) {
            if ((l > e) || s > r) {
                return 0;
            }
            if (s >= l && e <= r) {
                return seg[idx];
            }
            return sumInRange(idx << 1, s, (s + e) / 2, l, r) + sumInRange(idx << 1 | 1, (s + e) / 2 + 1, e, l, r);
        }
    }
}


    class seg{
        int[]seg;
         void update(int arr[],int ind, int low, int high , int index,int val){
            if(low == high){
                seg[ind] = val;
                return;
            }
            int mid = low + (high - low) / 2;
            if(index <= mid) update(arr,  2 * ind + 1, low, mid,index, val);
            else update(arr,2 * ind + 2, mid + 1, high , index, val);
            seg[ind] = Math.min(seg[2 * ind + 1] , seg[2 * ind + 2]);
        }
        int query(int arr[],int ind, int low, int high ,int l, int r){
            if(low >= l && high <= r){
                return seg[ind];
            }
            if(low > r || high < l){
                return Integer.MAX_VALUE;
            }
            int mid = low + (high - low) / 2;
            int left = query(arr,  2 * ind + 1, low, mid, l , r);
            int right = query(arr,2 * ind + 2, mid + 1, high , l ,r);
            return Math.min(left, right);
        }
        void build(int []arr){
            seg=new int[4*arr.length+1];
        }
        void build(int arr[],int ind, int low, int high){
            if(low == high){
                seg[ind] = arr[low];
                return;
            }
            int mid = low + (high - low) / 2;
            build(arr,  2 * ind + 1, low, mid);
            build(arr,2 * ind + 2, mid + 1, high);
            seg[ind] = Math.min(seg[2 * ind + 1] , seg[2 * ind + 2]);
        }
    }

