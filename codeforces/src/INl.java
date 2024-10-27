
import java.util.*;
class Node{
    int data;Node left=null;Node right=null;
    public Node(int data){
        this.data=data;
    }
}
class Treenode{
    int data;Treenode left=null;Treenode right=null;
    public Treenode(int data){
        data=this.data;
    }
    public Treenode(int data,Treenode left,Treenode right){
        data=this.data;left=this.left;right=this.right;
    }
}


public class INl {
    public static void recur(Node root,int left,int right){
        if(root==null)return ;
        int l= root.data;
        if(!map.containsKey(left+right)) {
            map.put(left + right, l);}
        recur(root.left,left-1,right);
        recur(root.right,left,right+1);
    }
    public static ArrayList<Integer> pre_order(Treenode root){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Treenode> pq=new Stack<>();
        if(root==null)return list;
        pq.add(root);
        while (!pq.isEmpty()){
                list.add(pq.peek().data);
                Treenode pe=pq.pop();
                if(pe.left!=null)pq.add(pe.left);
                if(pe.right!=null)pq.add(pe.right);
        }
        return list;
    }
    static TreeMap<Integer,Integer> map;
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Node root=new Node(1);root.right=new Node(3);root.left=new Node(2);root.left.right=new Node(10);
        root.right.left=new Node(9);root.right.right=new Node(10);root.left.left=new Node(4);
        root.left.left.right=new Node(5);root.left.left.right.right=new Node(6);
        map=new TreeMap<>();
        recur(root,0,0);
        System.out.println(map);
    }
}
//static class TrieNode {
//    TrieNode[] children = new TrieNode[26];
//    int count ;
//
//    TrieNode(){
//        for (int i = 0; i <26; i++)
//            children[i] = null;
//    }
//};
//public static void insert(String str){
//        TrieNode current = root;
//        int val;
//        for (char c : str.toCharArray()) {
//        val = c - 'a';
//
//        if (current.children[val] == null) {
//        current.children[val] = new TrieNode();
//        }
//        current = current.children[val];
//        current.count++;
//        }
//        }
//public static long getvalue(String str){
//        long result=0;int val;TrieNode current = root;
//        for (char c : str.toCharArray()) {
//        val = c - 'a';
//        if (current.children[val] == null) {
//        break;
//        }
//        current = current.children[val];
//        result+=current.count;
//        }
//
//        return result;
//        }
//
//static TrieNode root;

