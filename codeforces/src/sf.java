import java.util.*;

public class sf {



    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);

        int cl=0;HashMap<Integer,String> name=new HashMap<>();
        HashMap<Integer,String> task=new HashMap<>();
        HashMap<Integer,Integer> votes=new HashMap<>();
        name.put(0,"sumit");
        task.put(0,"Improve mess");cl++;

        int win=-1;

        while (true) {
            System.out.println("1. user");
            System.out.println("2. canadidates name");
            System.out.println("3. add candidate");
            System.out.println("4. show result");
            System.out.println("5. to display tasks of Winner_candidate");

            int n = s.nextInt();
            if (n == 1) {
                System.out.println("login succ..");

                System.out.println();
                System.out.println("1. show candidates name");
                n=s.nextInt();
                if(n==1){
                    for(int i=0;i<cl;i++){
                        System.out.println((i+1)+"  "+name.get(i));
                    }
                    System.out.println();
                    System.out.println("1. To vote");
                    n=s.nextInt();
                    if(n==1){
                    System.out.println("cloose no from 1 to"+(cl));
                    n=s.nextInt();
                    n--;
                    votes.put(n,votes.getOrDefault(n,0)+1);

                    System.out.println("vote updated");
                    }else {
                        System.out.println("invalid input");
                    }

                }else {
                    System.out.println("invalid input");
                }


            } else if (n==2) {
                System.out.println("All candidates");
                for(int i=0;i<cl;i++){
                    System.out.println((i+1)+"  "+name.get(i));
                }
            } else if (n==3) {
                System.out.println("Give your name :");
                String str=s.next();
                System.out.println("Provide your opperations");
                String str1=s.next();
                task.put(cl,str1);
                name.put(cl,str);
                System.out.println(name);
                System.out.println(task);
                cl++;
                System.out.println("Candidate registerd");
            } else if (n==4) {
                System.out.println("All candidates");
                int c=0;
                for(int i=0;i<cl;i++){
                    System.out.println((i+1)+"  "+name.get(i)+"  "+votes.getOrDefault(i,0));
                    if(votes.getOrDefault(i,0)>c){
                        c=votes.getOrDefault(i,0);
                        win=i;
                    }
                }
                if(c!=0){
                    System.out.println("winner is :");
                    System.out.println(name.get(win));
                }else {
                    System.out.println("Need more votes");
                }
            } else if (n==5) {
                if(win==-1){
                    System.out.println("Results are not declared");
                }else {
                    String str=task.get(win);
                    System.out.println(str);
                }
            }else {
                System.out.println("invalid input");
            }
            System.out.println();
        }
    }
}
