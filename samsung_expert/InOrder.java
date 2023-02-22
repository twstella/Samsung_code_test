package samsung_expert;
import java.util.StringTokenizer;
import java.util.Scanner;
class MyLeaf{
    int l,r;
    String d;
    MyLeaf(String c,int le, int ri){
        l= le;
        r = ri;
        d = c;
    }
}
public class InOrder {
    static void inOrder(MyLeaf[] tree,int n){
        if(n==-1) return;
        if(tree[n].l!=-1){
            inOrder(tree, tree[n].l);
        }
        System.out.print(tree[n].d);
        if(tree[n].r!=-1){
            inOrder(tree,tree[n].r);
        }
    }
    public static void main(String args[]) throws Exception
	{
        Scanner sc = new Scanner(System.in);
		int T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
		 int N = Integer.parseInt(sc.nextLine());
         MyLeaf[] tree = new MyLeaf[N+1];
         for(int i=0;i<N;i++){
            String sk = sc.nextLine();
            StringTokenizer st = new StringTokenizer(sk);
            if(st.countTokens()==4){
                int n = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                tree[n] = new MyLeaf(s,l,r);
            }
            else if(st.countTokens()==3){
                int n = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                int l = Integer.parseInt(st.nextToken());
                tree[n] = new MyLeaf(s,l,-1);
            }
            else{
                int n = Integer.parseInt(st.nextToken());
                String s = st.nextToken();
                tree[n] = new MyLeaf(s,-1,-1);
            }
         }
         System.out.print("#"+test_case+" ");
         inOrder(tree,1);
		System.out.println();
		}
	}
}
