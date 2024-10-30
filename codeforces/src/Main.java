//package com.example.demo2;

//import jdk.jshell.spi.SPIResolutionException;
// 2212069 sumit
// Har_Har_Mahadev

//import java.lang.classfile.attribute.InnerClassesAttribute;

//import javax.management.MBeanServerDelegateMBean;
//import javax.print.DocFlavor;
//import javax.print.attribute.standard.Finishings;
//import javax.swing.*;
//import javax.swing.plaf.RootPaneUI;
import java.util.*;
import java.lang.*;
import java.util.HashMap;
import java.lang.Long;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.List;
import java.util.StringTokenizer;
//import java.util.function.IntBinaryOperator;
//import java.util.function.Predicate;
import static java.lang.Math.*;

/*****************************************************************************************************************/
/*
										$,  $,     ,
										"ss.$ss. .s'
								,     .ss$$$$$$$$$$s,
								$. s$$$$$$$$$$$$$$`$$Ss
								"$$$$$$$$$$$$$$$$$$o$$$       ,
							   s$$$$$$$$$$$$$$$$$$$$$$$$s,  ,s
							  s$$$$$$$$$"$$$$$$""""$$$$$$"$$$$$,
							  s$$$$$$$$$$s""$$$$ssssss"$$$$$$$$"
							 s$$$$$$$$$$'         `"""ss"$"$s""
							 s$$$$$$$$$$,              `"""""$  .s$$s
							 s$$$$$$$$$$$$s,...               `s$$'  `
						 `ssss$$$$$$$$$$$$$$$$$$$$####s.     .$$"$.   , s-
						   `""""$$$$$$$$$$$$$$$$$$$$#####$$$$$$"     $.$'
								 "$$$$$$$$$$$$$$$$$$$$$####s""     .$$$|
								  "$$$$$$$$$$$$$$$$$$$$$$$$##s    .$$" $
								   $$""$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"   `
								  $$"  "$"$$$$$$$$$$$$$$$$$$$$S""""'
							 ,   ,"     '  $$$$$$$$$$$$$$$$####s
							 $.          .s$$$$$$$$$$$$$$$$$####"
				 ,           "$s.   ..ssS$$$$$$$$$$$$$$$$$$$####"
				 $           .$$$S$$$$$$$$$$$$$$$$$$$$$$$$#####"
				 Ss     ..sS$$$$$$$$$$$$$$$$$$$$$$$$$$$######""
				  "$$sS$$$$$$$$$$$$$$$$$$$$$$$$$$$########"
		   ,      s$$$$$$$$$$$$$$$$$$$$$$$$#########""'
		   $    s$$$$$$$$$$$$$$$$$$$$$#######""'      s'         ,
		   $$..$$$$$$$$$$$$$$$$$$######"'       ....,$$....    ,$
			"$$$$$$$$$$$$$$$######"' ,     .sS$$$$$$$$$$$$$$$$s$$
			  $$$$$$$$$$$$#####"     $, .s$$$$$$$$$$$$$$$$$$$$$$$$s.
   )          $$$$$$$$$$$#####'      `$$$$$$$$$###########$$$$$$$$$$$.
  ((          $$$$$$$$$$$#####       $$$$$$$$###"       "####$$$$$$$$$$
  ) \         $$$$$$$$$$$$####.     $$$$$$###"             "###$$$$$$$$$   s'
 (   )        $$$$$$$$$$$$$####.   $$$$$###"                ####$$$$$$$$s$$'
 )  ( (       $$"$$$$$$$$$$$#####.$$$$$###'                 .###$$$$$$$$$$"
 (  )  )   _,$"   $$$$$$$$$$$$######.$$##'                .###$$$$$$$$$$
 ) (  ( \.         "$$$$$$$$$$$$$#######,,,.          ..####$$$$$$$$$$$"
(   )$ )  )        ,$$$$$$$$$$$$$$$$$$####################$$$$$$$$$$$"
(   ($$  ( \     _sS"  `"$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$S$$,
 )  )$$$s ) )  .      .   `$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"'  `$$
  (   $$$Ss/  .$,    .$,,s$$$$$$##S$$$$$$$$$$$$$$$$$$$$$$$$S""        '
	\)_$$$$$$$$$$$$$$$$$$$$$$$##"  $$        `$$.        `$$.
		`"S$$$$$$$$$$$$$$$$$#"      $          `$          `$
			`"""""""""""""'         '           '           '
*/
/*****************************************************************************************************************/
public class Main{
	static int MoD = 1000000007;static int MoD1=998244353;
	static long MAXN= (long) (1e6+1000);
	static long sievediv[]=new long[(int) (MAXN+1)];
	/*****************************************************************************************************************/
	static class FastReader{BufferedReader br;StringTokenizer st;public FastReader(){br = new BufferedReader(new InputStreamReader(System.in));}String next(){while (st == null || !st.hasMoreElements()) {try {st = new StringTokenizer(br.readLine());}catch (IOException e){e.printStackTrace();}}return st.nextToken();}int nextInt(){ return Integer.parseInt(next());}long nextLong(){return Long.parseLong(next());}double nextDouble(){return Double.parseDouble(next());}String nextLine(){String str = "";try{if(st.hasMoreTokens()){str = st.nextToken("\n");}else{str = br.readLine();}}catch (IOException e) {e.printStackTrace();}return str;}

		public int[] readIntArray(int n,int s,int e) {
			int[] ar = new int[n];
			for(int i=s; i<e; ++i)
				ar[i]=se.nextInt();
			return ar;}
		public long[] readIntArrayLONG(int n,int s,int e) {
			long[] ar = new long[n];
			for(int i=s; i<e; ++i)
				ar[i]=se.nextLong();
			return ar;}

		int[][] next2DInt(int n, int m,int s,int e) {
			int[][] arr = new int[n][];
			for (int i = s; i < e; i++) {
				arr[i] = se.readIntArray(m,0,m);
			}
			return arr;}
		long[][] next2DLong(int n, int m,int s,int e) {
			long[][] arr = new long[n][];
			for (int i = s; i < e; i++) {
				arr[i] = se.readIntArrayLONG(m,0,m);
			}
			return arr;}
		List<Long> asLongList() throws IOException {
			List<Long> list = new ArrayList<>();
			String s = se.next();
			String[] str = s.split(" ");
			for (String string : str) {
				list.add(Long.parseLong(string));
			}
			return list;
		}
		List<Integer> asIntList() throws IOException {
			List<Integer> list = new ArrayList<>();
			String s = se.next();
			String[] str = s.split(" ");
			for (String string : str) {
				list.add(Integer.parseInt(string));
			}
			return list;
		}
	}
	static class Reader { final private int BUFFER_SIZE = 1 << 16;private DataInputStream din;private byte[] buffer;private int bufferPointer, bytesRead;public Reader() {din = new DataInputStream(System.in);buffer = new byte[BUFFER_SIZE];bufferPointer = bytesRead = 0;}public Reader(String file_name) throws IOException {din = new DataInputStream(new FileInputStream(file_name));buffer = new byte[BUFFER_SIZE];bufferPointer = bytesRead = 0;}public String readLine() throws IOException {byte[] buf = new byte[64];int cnt = 0, c;while ((c = read()) != -1) {if (c == '\n') break;buf[cnt++] = (byte) c;}return new String(buf, 0, cnt);}public int nextInt() throws IOException {int ret = 0;byte c = read();while (c <= ' ') c = read();boolean neg = (c == '-');if (neg) c = read();do {ret = ret * 10 + c - '0';} while ((c = read()) >= '0' && c <= '9');if (neg) return -ret;return ret;}public long nextLong() throws IOException {long ret = 0;byte c = read();while (c <= ' ') c = read();boolean neg = (c == '-');if (neg) c = read();do {ret = ret * 10L + c - '0';} while ((c = read()) >= '0' && c <= '9');if (neg) return -ret;return ret;}public double nextDouble() throws IOException {double ret = 0, div = 1;byte c = read();while (c <= ' ') c = read();boolean neg = (c == '-');if (neg) c = read();do {ret = ret * 10 + c - '0';} while ((c = read()) >= '0' && c <= '9');if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);if (neg) return -ret;return ret;}private void fillBuffer() throws IOException {bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);if (bytesRead == -1) buffer[0] = -1;}private byte read() throws IOException {if (bufferPointer == bytesRead) fillBuffer();return buffer[bufferPointer++];}public char[] next() throws IOException {StringBuilder sb = new StringBuilder();byte c;while ((c = read()) <= ' ') ;do {sb.append((char) c);} while ((c = read()) > ' ');return sb.toString().toCharArray();}public int nextInt2() throws IOException {int ret = 0;byte c = read();while (c <= ' ') c = read();boolean neg = (c == '-');if (neg) c = read();do {ret = ret * 10 + c - '0';} while ((c = read()) >= '0' && c <= '9');if (neg) return -ret;return ret;}public void close() throws IOException {if (din == null) return;din.close();}

		public int[] readIntArray(int n,int se,int e)throws IOException {
			int[] ar = new int[n];
			for(int i=se; i<e; ++i)
				ar[i]=s.nextInt();
			return ar;}
		public long[] readIntArrayLONG(int n, int se, int e)throws IOException {
			long[] ar = new long[n];
			for(int i=se; i<e; ++i)
				ar[i]=s.nextLong();
			return ar;}

		int[][] next2DInt(int n, int m,int se,int e)throws IOException {
			int[][] arr = new int[n][];
			for (int i = se; i < e; i++) {
				arr[i] = s.readIntArray(m,0,m);
			}
			return arr;}
		long[][] next2DLong(int n, int m, int se, int e)throws IOException {
			long[][] arr = new long[n][];
			for (int i = se; i < e; i++) {
				arr[i] = s.readIntArrayLONG(m,0,m);
			}
			return arr;}
		List<Long> asLongList(int n) throws IOException {
			List<Long> list = new ArrayList<>(n);
			for (int i=0;i<n;i++) {
				list.add(s.nextLong());
			}
			return list;
		}
		List<Integer> asIntList(int n) throws IOException {
			List<Integer> list = new ArrayList<>(n);
			for (int i=0;i<n;i++) {
				list.add(s.nextInt());
			}
			return list;}
	}
	public static long gcd(long a, long b) {if (b==0) return a;return gcd(b,a%b);}
	public static long LCM(long u, long v) {return (u / gcd(u, v)) * v;}
	public static void debugL(long[] a,long s){for(long i=s;i<a.length;i++){System.out.print(a[(int) i]+" ");}}
	public static void debugI(int[] a,long s){for(long i=s;i<a.length;i++){System.out.print(a[(int) i]+" ");}}
	public static long smallestDivisor(long n){if (n % 2 == 0) return 2;for (long i = 3; i * i <= n; i += 1) {if (n % i == 0) return i;}return n;}
	public static long max4(long a, long b, long c, long d) {if (a >= b && a >= c && a >= d) return a;else if (b >= a && b >= c && b >= d) return b;else if (c >= a && c >= b && c >= d) return c;else if (d >= b && d >= c && d >= a) return d;return a;}
	public static long min3(long a,long b,long c) {return min(a,min(b,c));}
	public static boolean checkString(String s1, String s2) {char[] tempArrays1=s1.toCharArray();Arrays.sort(tempArrays1);String sortedS1=new String(tempArrays1);char[] tempArrays2=s2.toCharArray();Arrays.sort(tempArrays2);String sortedS2=new String(tempArrays2);if(sortedS1.equals(sortedS2)){return true;}return false;}
	public static long[] minSUMofPROC(long n,int c){long[] arr =new long[c];long k=1;long x=0;for (int i = 0; i<10; i++){arr[i]=1;}while (k<n){long ok=arr[(int) (x%10)];k=k/ok;arr[(int) (x%10)]++;ok++;k=k*ok;x++;}return  arr;}
	public static String powwerSTR(String str,long n){String res="";if(n%2==0){res = str;n--;}while(n>0){if(n%2==1){res=res+str;n--;}else{res =res+res;n=n/2;}}return res;}
	public static boolean isPalindrome(String s) {StringBuilder sb=new StringBuilder(s);if(sb.reverse().toString().equals(s)){return true;}return false;}
	public static long nCr(int n,int k){long ans=1L;k=k>n-k?n-k:k;for( int j=1;j<=k;j++,n--){if(n%j==0){ans*=n/j;}else{if(ans%j==0){ans=ans/j*n;}else{ans=(ans*n)/j;}}}return ans;}
	public static long sumofarray(int[] arr){long n=arr.length;long sum=0;for(long i = 0; i<n; i++){sum+=arr[(int) i];}return sum;}
	public static long power(long x, long y, long p) {long res = 1;x = x % p;while (y > 0){if (y % 2 == 1) res = (res * x) % p;y = y >> 1;x = (x * x) % p;}return res;}
	public static long max3(long a,long b,long c){{if (a >= b && a >= c) return a;else if (b >= a && b >= c ) return b;else if (c >= b) return c;return a;}}
	public static long getAdd(long x) {long m1 = 10, m2 = 0;while(x > 0) {long y = x % 10;x /= 10;m1 = min(m1, y);m2 = max(m2, y);}return m1 * m2;}
	public static void sieve_of_erantothenes() {sievediv[1] = 1;for (long i = 2; i <= MAXN; i++) sievediv[(int) i] = i;for (long i = 4; i <= MAXN; i += 2) sievediv[(int) i] = 2;for (long i = 3; i * i <= MAXN; i++){if (sievediv[(int) i] == i){for (long j = i * i; j <= MAXN; j += i) if (sievediv[(int) j] == j) sievediv[(int) j] = i;}}}
	public static long factorial(long n) {if (n == 0)return 1;return n*factorial(n-1);}
	public static String SUMofDigits(String str){long n=0;for(int i=0;i<str.length();i++){n+= str.charAt(i)-'0';}String temp= String.valueOf(n);return temp;}
	public static long SumOfDigits (long num) {long sum = 0;while (num > 0) {long d = num % 10;sum += d;num /= 10;}return sum;}
	public static long numOF_2(long n){long ans=0;while (n%2==0){n=n/2;ans++;}return ans;}
	public static ArrayList<Long> trial_division2(long n) {ArrayList<Long> factorization = new ArrayList<Long>((int)1e7);while (n % 2 == 0) {factorization.add(2L);n /= 2;}for (long d = 3; d * d <= n; d += 2) {while (n % d == 0) {factorization.add(d);n /= d;}}if (n > 1) factorization.add(n);return factorization;}
	public static HashSet<Long> trial_division2SET(long n) {HashSet<Long> factorization = new HashSet<>((int)1e7);while (n % 2 == 0) {factorization.add(2L);n /= 2;}for (long d = 3; d * d <= n; d += 2) {while (n % d == 0) {factorization.add(d);n /= d;}}if (n > 1) factorization.add(n);return factorization;}
	public static  long binpow(long  a, long  b,  long m) {a %= m;long res = 1;while (b > 0) {if ((b & 1)==1) res = res * a % m;a = a * a % m;b >>= 1;}return res%m;}
	public static long binaryExponentiation(long a, long n) {if(n==0) {return 1;}if(n==1) {return a;}long val = binaryExponentiation(a,n/2);val = (val*val);val = (val*binaryExponentiation(a, n%2));return val;}

	public static String reverseString(String str) {StringBuilder sb = new StringBuilder(str);return sb.reverse().toString();}

//    public static int lower_bound(long val,int start,long []arr){int low = start;int high = arr.length-1;int ans = -1;while(low<=high){int mid = (low+high)/2;if(arr[mid]>=val){high = mid - 1;ans  = mid;}else{low = mid + 1;}}return ans;}
//    public static int upper_bound(long val,int start,long []arr){int low = start;int high = arr.length-1;int ans = -1;while(low<=high){int mid = (low+high)/2;if(arr[mid]<=val){low = mid + 1;ans  = mid;}else{high = mid - 1;}}return ans;}

	public static Long getMin(long[] arr, int n) {return (Long) Arrays.stream(arr).min().getAsLong();}
	public static Long getMax(long[] arr, int n) {return (Long) Arrays.stream(arr).max().getAsLong();}
	public static void fill(int[][]arr) {for(int i=0;i<arr.length;i++) {for(int j=0;j<arr[0].length;j++) arr[i][j]=-1;}}
	private static boolean Sqrt(long x){long a=(long) sqrt(x);return a*a==x;}

	public static HashMap<Long, Integer> map_prime_factors(long n) {HashMap<Long, Integer> map = new HashMap<>();while (n % 2 == 0) {map.put(2L, map.getOrDefault(2L, 0) + 1);n /= 2L;}for (long i = 3; i <= sqrt(n); i++) {while (n % i == 0) {map.put(i, map.getOrDefault(i, 0) + 1);n /= i;}}if (n > 2) {map.put(n, map.getOrDefault(n, 0) + 1);}return map;}
	public static String DecimalToBinary(long num) {String str = "";while (num > 0) {if ((num & 1) == 1){str += '1';} else{str += '0';}num >>= 1;}return str;}

	public static void println(long c) {out.println(c);}
	public static void print(long c)   {out.print(c);}
	public static void print(int c) 	{out.print(c);}
	public static void println(int x) 	{out.println(x);}
	public static void print(String s) {out.print(s);}
	public static void println(String s){out.println(s);}
	public static void println(boolean b){out.println(b);}
	public static void println(int[][]arr) {for(int i=0;i<arr.length;i++) {for(int j=0;j<=i;j++)print(arr[i][j]+" "); println("");}}
	public static void println(long[][]arr) {for(int i=0;i<arr.length;i++) {for(int j=0;j<arr[0].length;j++) print(arr[i][j]+" "); print("\n");}}
	public static void println(int[]arr){for(int i=0;i<arr.length;i++)print(arr[i]+" ");print("\n");}
	public static void println(ArrayList<Integer> list1){for(int i = 0; i< list1.size(); i++)print(list1.get(i)+" ");print("\n");}
	public static void println1(ArrayList<Integer> list){for(int i = 0; i< list.size(); i++)print(list.get(i)+" ");print("\n");}
	public static void println(long[]arr){ for(int i=0;i<arr.length;i++) print(arr[i]+" ");print("\n"); }
	public static void println(char x) {out.println(x);}
	public static long[]inputArray(int n) throws IOException { long[]arr=new long[n];for(int i = 0; i<n; i++)arr[i]=s.nextInt();return arr;}
	public static InputStream inputStream = System.in;
	public static OutputStream outputStream = System.out;
	//    public static InputReader in = new InputReader(inputStream);
	public static PrintWriter out = new PrintWriter(outputStream);

	public static class InputReader { private InputStream stream;private byte[] inbuf = new byte[1024];private int start= 0;private int end = 0;public InputReader(InputStream stream) {this.stream = stream;}private int readByte() {if (start == -1) throw new UnknownError();if (end >= start) {end= 0;try {start= stream.read(inbuf);} catch (IOException e) {throw new UnknownError();}if (start<= 0) return -1;}return inbuf[end++];}private boolean isSpaceChar(int c) {return !(c >= 33 && c <= 126);}private int skip() {int b;while ((b = readByte()) != -1 && isSpaceChar(b)) ;return b;}public String next() {int b = skip();StringBuilder sb = new StringBuilder();while (!(isSpaceChar(b))) { /* when nextLine, (isSpaceChar(b) && b != ' ')*/sb.appendCodePoint(b);b = readByte();}return sb.toString();}public int nextInt() {int num = 0, b;boolean minus = false;while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;if (b == '-') {minus = true;b = readByte();}while (true) {if (b >= '0' && b <= '9') {num = num * 10 + (b - '0');} else {return minus ? -num : num;}b = readByte();}}public long nextLong() {long num = 0;int b;boolean minus = false;while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')) ;if (b == '-') {minus = true;b = readByte();}while (true) {if (b >= '0' && b <= '9') {num = num * 10 + (b - '0');} else {return minus ? -num : num;}b = readByte();}}}

	/*****************************************************************************************************************/

	public long[] findRemoved(int[] nums1, int[] nums2, int[] nums3) {int Xor = findXor(nums2);return new long[]{Xor ^ findXor(nums1), Xor ^ findXor(nums3)};}
	public int findXor(int[] nums) {int xor = 0;for (long num : nums) xor ^= num;return xor;}

	/* --------- Apply k Permutations on a sequence ------------
	   TC : nLog(k)                                               */
	private static long[] permute(long[] sequence, long[] permutation, long k) {while (k > 0) {if ((k & 1) == 1) {sequence = applyPermute(sequence, permutation);}permutation = applyPermute(permutation, permutation);k >>= 1;}return sequence;}
	private static long[] applyPermute(long[] sequence, long[] permutation) {
		long[] newSequence = new long[sequence.length];
		for (int i = 1; i < sequence.length; i++) {
			newSequence[i] = sequence[(int) permutation[i]]; // newSequence[permutation[i]] = sequence[i]; Acc. to given Question
		}return newSequence;}

	/* --------- Apply k Permutations on a sequence ------------
		   TC : nLog(k)                                               */

	public static int upper__bound(long[] arr,int low, int high, long target){int n = arr.length;int mid = 0;while (low < high && low != n){mid = low + (high - low) / 2;if(target >= arr[mid]) {low = mid + 1;} else {high = mid;}}return low;}
	public static int lower__bound(long[] arr, int low, int high, long key) {int mid;while (low < high) {mid = low + (high - low) / 2;if (key <= arr[mid]) {high = mid;} else {low = mid + 1;}}if (low < arr.length && arr[low] < key) {low++;}return low;}
	public static int upper__boundL(int[] arr,int low, int high, long target){int n = arr.length;int mid = 0;while (low < high && low != n){mid = low + (high - low) / 2;if(target >= arr[mid]) {low = mid + 1;} else {high = mid;}}return low;}
	public static int lower__boundL(int[] arr, int low, int high, long key) {int mid;while (low < high) {mid = low + (high - low) / 2;if (key <= arr[mid]) {high = mid;} else {low = mid + 1;}}if (low < arr.length && arr[low] < key) {low++;}return low;}

	public static void sort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {int id = (int) (random() * n);int t = a[i];a[i] = a[id];a[id] = t;}
		Arrays.sort(a);}
	public static void sort(long[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {int id = (int) (random() * n);long t = a[i];a[i] = a[id];a[id] = t;}
		Arrays.sort(a);}
	public static void sort(int[] a, Comparator<Integer> cmp) {
		int n = a.length;
		Integer[] arr = new Integer[n];
		for(int i = 0; i < n; i++) arr[i] = a[i];
		Arrays.sort(arr, cmp);
		for(int i = 0; i < n; i++) a[i] = arr[i];}
	public static void sort(long[] a, Comparator<Long> cmp) {
		int n = a.length;
		Long[] arr = new Long[n];
		for(int i = 0; i < n; i++) arr[i] = a[i];
		Arrays.sort(arr, cmp);
		for(int i = 0; i < n; i++) a[i] = arr[i];}

	public static boolean check_pow_2(long n){long t= n&(n-1);if(t==0&&n!=0){return true;}return false;}
	public static long countUnsetBits(long n) {long x = n;n |= n >> 1;n |= n >> 2;n |= n >> 4;n |= n >> 8;n |= n >> 16;return Integer.bitCount((int) (x^ n));}
	public static long countSetBits(long n) {long count = 0;while (n > 0) {n &= (n - 1);count++;}return count;}

	public static boolean chekstringsubsq(String str,String ans){String tmp="";int l=0;for(int i=0;i<str.length()&&l<ans.length();i++){if(str.charAt(i)==ans.charAt(l)){tmp+= ans.charAt(l);l++;}}if(ans.equals(tmp))return false;return true;}
	public static long gcdec(long a, long b, long[] x, long[] y) {if (b == 0) {x[0] = 1;y[0] = 0;return a;}long[] x1 = new long[1];long[] y1 = new long[1];long d = gcdec(b, a % b, x1, y1);x[0] = y1[0];y[0] = x1[0] - y1[0] * (a / b);return d;}
	public static void coprime_1_to_n(long n) {long[] phi = new long[(int) (n+1)];for (long i = 0; i <= n; i++) phi[(int) i] = i;for (long i = 2; i <= n; i++) {if (phi[(int)i] == i) {for (long j = i; j <= n; j += i) phi[(int)j] -= phi[(int)j] / i;}}}
	public static long base_2log(long N) {long result = (int)(log(N) / log(2));return result;}
	public static void shuffleArray(int[] array) {int index;Random random = new Random();for (int i = array.length - 1; i > 0; i--) {index = random.nextInt(i + 1);if (index != i) {array[index] ^= array[i];array[i] ^= array[index];array[index] ^= array[i];}}}
	public static long subarrayXor(int[] arr, int n, long m) {HashMap<Long, Integer> HashTable = new HashMap<>();HashTable.put(0L, 1);int count = 0;long curSum = 0;for (int i = 0; i < n; i++) {curSum ^= arr[i];if (HashTable.containsKey(curSum ^ m)) count += HashTable.get(curSum ^ m);if (!HashTable.containsKey(curSum)) HashTable.put(curSum, 0);HashTable.put(curSum, HashTable.get(curSum) + 1);}return (count);}
	public static void reverseArray(int[] a) {int n = a.length;int arr[] = new int[n];for (int i = 0; i < n; i++) arr[i] = a[n - i - 1];for (int i = 0; i < n; i++) a[i] = arr[i];}
	public static void reverseArray(long[] a) {int n = a.length;long arr[] = new long[n];for (int i = 0; i < n; i++) arr[i] = a[n - i - 1];for (int i = 0; i < n; i++) a[i] = arr[i];}
	public static long sumOfMaximumOfSubsets(Long[] arr, int N,long mm) {Arrays.sort(arr, Collections.reverseOrder());long sum = arr[0]%=mm;for (int i = 1; i < N; i++) {sum = 2 * sum + arr[i];sum%=mm;}return sum%=mm;}
	public static long AndOperator_RANGE(long x, long y) {for (int i = 0; i < (log(y) / log(2)) + 1; i++) {if (y <= x) {return y;}if ((y & (1L << i)) != 0) {y &= ~(1L << i);}}return y;}
	private static ArrayList<Long> getAllFactors(long num){ArrayList<Long> list = new ArrayList<>(10000);for (long i = 1; (long) i * i <= num; ++i) {if (num % i != 0) continue;list.add(i);if ((long) i*i < num) list.add((int) num / i);};Collections.sort(list);return list;}
	static long[] facts, factInvs;
	static long add(long a, long b,long Mod) {return (a+b)%Mod;}
	static long mul(long a, long b,long Mod) {return a*b%Mod;}
	static long modInv(long x,long Mod) {return binpow(x, Mod-2,Mod);}
	static void precomp(long Mod) {facts=new long[1_000_001];factInvs=new long[1_000_001];factInvs[0]=facts[0]=1;for (int i=1; i<facts.length; i++) facts[i]=mul(facts[i-1], i,Mod);factInvs[facts.length-1]=modInv(facts[facts.length-1],Mod);for (int i=facts.length-2; i>=0; i--) factInvs[i]=mul(factInvs[i+1], i+1,Mod);}
	static long nCk(int n, int k,long Mod) {return mul(facts[n], mul(factInvs[k], factInvs[n-k],Mod),Mod);}
	static String gets(char[]str){String st="";for(char c:str)st+=c;return st;}

	// debug
	static class Debug { public static boolean LOCAL = getLocal();public static boolean getLocal() {try {return System.getProperty("LOCAL") == null;}catch(SecurityException e) {return false;}}public static <T> String ts(T t) {if(t==null) {return "null";}if(t instanceof Iterable) {return ts((Iterable<?>) t);}else if(t instanceof int[]) {String s = Arrays.toString((int[]) t);return "{"+s.substring(1, s.length()-1)+"}";}else if(t instanceof long[]) {String s = Arrays.toString((long[]) t);return "{"+s.substring(1, s.length()-1)+"}";}else if(t instanceof char[]) {String s = Arrays.toString((char[]) t);return "{"+s.substring(1, s.length()-1)+"}";}else if(t instanceof double[]) {String s = Arrays.toString((double[]) t);return "{"+s.substring(1, s.length()-1)+"}";}else if(t instanceof boolean[]) {String s = Arrays.toString((boolean[]) t);return "{"+s.substring(1, s.length()-1)+"}";}else if(t instanceof Object[]) {return ts((Object[]) t);}return t.toString();}private static <T> String ts(T[] arr) {StringBuilder ret = new StringBuilder();ret.append("{");boolean first = true;for(T t: arr) {if(!first) ret.append(", ");first = false;ret.append(ts(t));}ret.append("}");return ret.toString();}private static <T> String ts(Iterable<T> iter) {StringBuilder ret = new StringBuilder();ret.append("{");boolean first = true;for(T t: iter) {if(!first) ret.append(", ");first = false;ret.append(ts(t));}ret.append("}");return ret.toString();}public static void print(Object... o) {if(LOCAL) {System.err.print("Line #"+Thread.currentThread().getStackTrace()[2].getLineNumber()+": [");for(int i = 0; i<o.length; i++) {if(i!=0) System.err.print(", ");System.err.print(ts(o[i]));}System.err.println("]");}}}
	static Debug dbg=new Debug();

	/*****************************************************************************************************************/
//    static ArrayList<Integer>[] tree;
//    static int[] seq;
	static FastReader se = new FastReader();
	static Reader s=new Reader();
	static HashSet<Long> set=new HashSet<>();
	static boolean[][] vis2D;
	static long value;
	public  static long bfs(int n,int m,int row,int col,int arr[][]){
		if (row>=n || row<0 || col>=m || col<0 || arr[row][col]==0 || vis2D[row][col]) return 0;
		vis2D[row][col] =true;
		value++;
		int dir[][] = {{-1,0} , {0,-1} , {0,1}, {1, 0}};
		for(int dire[] : dir) {
			int nrow = row + dire[0];
			int ncol = col + dire[1];
			value += bfs(n,m,nrow,ncol, arr);}
		return value;
	}

	public static void swap(int i, int j, char[] nums){char t = nums[i];nums[i] = nums[j];nums[j] = t;}
	static long[][] dp;static long[][][] cp;

	static class Num implements Comparable<Num> {
		int p; int[] pr;
		public Num(int[] arr, int x){
			pr = arr;
			p = x;}
		public int compareTo(Num n){
			if (p == n.p) {
				for (int i = 0; i < pr.length; i++) {
					if (pr[i] != n.pr[i])
						return pr[i] - n.pr[i];
				}
			}
			return p - n.p;
		}}
	// static class Pair implements Comparable<Pair> { long first;long second;long third;Pair(long first, long second) {this.first = first;this.second = second;}public int compareTo(Pair other) {return Long.compare(this.first, other.first);}}
	static class pair { int a;int b;long w;pair(int x, int y){this.a=x;this.b=y;}pair(int x, int y, long w){this.a=x;this.b=y;this.w=w;}public int getFirst(){return (int) a;}public int getSecond() {return (int) b;}@Override public String toString(){String str="";str="{ "+a+" "+b+"  "+"  "+w +"}";return str;}}
//	public static class Tree<T> extends TreeSet<T> { public Tree() {super();}}

	static long[]vp;static ArrayList<Integer>[]lists;static char[] str,str1;static long[]pre;static int[]arr;static int[]brr;

	public static long stick(int ind,int n){
		return 0;
	}

	public static void main(String[] args) throws Exception{
//		sieve_of_erantothenes();
//      Reader s = new Reader();
//		precomp((long) (MoD));
		// Read question and Test cases thoroughly
		// Check for overflow , Avoid Integer ==
		// Handle invalid cases
		// Think before solving
		// Search for concepts
		// expected alg like seg tree, trie, binSearch, sqrt decom ...
		int Te = 1;
		Te=s.nextInt();
		superOuter:
		while(Te-- >0) {
			int n = s.nextInt();
			




		}
		out.flush();out.close();
	}
}

/*****************************************************************************************************************/

class Model<T,U> { T val;U ind;Model(T val,U ind) {this.val=val;this.ind=ind;}T getFirst() {return val;}U getSecond() {return ind;}}
//PriorityQueue<Model<Integer,Integer>> pq=new PriorityQueue<>((a,b)->b.val-a.val);
//TreeSet<long[]> set = new TreeSet<>((a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0]));
//class Pair<T, U> { T a;U b;Pair(T a,U b) {this.a=a;this.b=b;}T getFirst() {return a;}U getSecond() {return b;}}
class Triplet<T,U,V>{ T a;U b;V c;Triplet(T a,U b,V c){this.a = a;this.b = b;this.c = c;}T getFirst() {return a;}U getSecond() {return b;} V getThird(){return c;}}

class MultiTreeSet<E> { TreeMap<E, Integer> freqTreeMap = new TreeMap<E, Integer>();int size;public MultiTreeSet() {}public MultiTreeSet(Collection<? extends E> c) {for (E element : c) add(element);}public int size() {return size;}public void add(E element) {Integer freq = freqTreeMap.get(element);if(freq==null) freqTreeMap.put(element, 1);else freqTreeMap.put(element,freq+1);++size;}public void remove(E element) {Integer freq = freqTreeMap.get(element);if(freq!=null) {if(freq==1) freqTreeMap.remove(element);else freqTreeMap.put(element, freq-1);--size;}}public int get(E element) {Integer freq = freqTreeMap.get(element);if(freq==null) return 0;return freq;}public boolean contains(E element) {return get(element)>0;}@Override public String toString() {String current = "( ";for(E ele : freqTreeMap.keySet()){int freq = freqTreeMap.get(ele);for(int i = 0; i < freq; i++){current += ele + " ";}}current += ")";return current;}public boolean isEmpty() {return size==0;}public E first() {return freqTreeMap.firstKey();}public E last() {return freqTreeMap.lastKey();}public E ceiling(E element) {return freqTreeMap.ceilingKey(element);}public E floor(E element) {return freqTreeMap.floorKey(element);}public E higher(E element) {return freqTreeMap.higherKey(element);}public E lower(E element) {return freqTreeMap.lowerKey(element);}}

// class Nodes implements Comparable<Nodes> {
//    long needed;
//    long otherSize;
//
//    public Nodes(long needed, long otherSize) {
//        this.needed = needed;
//        this.otherSize = otherSize;
//    }
//    public int compareTo(Nodes o) {
//        return Long.compare(needed, o.needed);
//    }
//}
// check that kth bit is set is to n&(2^k) if(0)no:yes;
// check jth bit if(((x >>j) & 1) == 1);
// to togle kth bit n^(2<<k);
// n%(2<<k)== n&(2<<k-1);
// swap x and y -> x=x^y;y=x^y;x=x^y;
// x= a^b^x; if x==a,change it to b;
// a+b==(a^b)+2*(a&b);
// a+b==(a|b)+(a&b);
// fermi theorem (a^p)%p=a;and (a^(p-1))%p=1 ; where p is prime and gcd(a,p)==1;
/*
	private static class StringLengthComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			return a.length() - b.length();
		}
	 }
	Arrays.sort(arr, new StringLengthComparator());

	PriorityQueue<pair> q = new PriorityQueue<>(new Comparator<pair>() {
				@Override
				public int compare(pair o1, pair o2) {
					if (o1.x > o2.x) {
						return 1;
					} else if (o1.x < o2.x) {
						return -1;
					} else {
						if (o1.y > o2.y) {
							return -1;
						} else if (o1.y < o2.y) {
							return 1;
						} else {
							return 0;
						}
					}
				}
			})
 */

