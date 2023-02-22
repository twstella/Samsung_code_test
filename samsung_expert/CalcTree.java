package samsung_expert;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;

import MyLeaf;
class MyLeaf{
    int l,r;
    String d;
    MyLeaf(String s,int le,int ri){
        d = s;
        l = le;
        r = ri;
    }
}
public class CalcTree {
    static ArrayList<Integer> stack;
    static int calc(MyLeaf[] tree,int n){
        if(tree[n].l!=-1) calc(tree,tree[n].l);
        if(tree[n].r!=-1) calc(tree,tree[n].r);
        try{
            int t = Integer.parseInt(tree[n].d);
            stack.add(0, t);
        }
        catch(Exception e){
            try{
                int a = stack.remove(0);
                int b = stack.remove(0);
                if(tree[n].d.equals("+")) stack.add(0,a+b);
                else if(tree[n].d.equals("-")) stack.add(0,b-a);
                else if(tree[n].d.equals("*")) stack.add(0,b*a);
                else if(tree[n].d.equals("/")) stack.add(0,b/a);

            }catch(IndexOutOfBoundsException ie){
                return -1;
            }
            catch(ArithmeticException ae){
                return -1;
            }
        }
        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = Integer.parseInt(sc.nextLine());
            MyLeaf[] tree = new MyLeaf[N+1];
            stack = new ArrayList<Integer>();
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                if(st.countTokens()==4){
                    int n = Integer.parseInt(st.nextToken());
                    String s = st.nextToken();
                    int l = Integer.parseInt(st.nextToken());
                    int r = Integer.parseInt(st.nextToken());
                    tree[n] = new MyLeaf(s, l, r);
                }
                else if(st.countTokens()==3){
                    int n = Integer.parseInt(st.nextToken());
                    String s = st.nextToken();
                    int l = Integer.parseInt(st.nextToken());
                    tree[n] = new MyLeaf(s, l, -1);
                }
                else if(st.countTokens()==2){
                    int n = Integer.parseInt(st.nextToken());
                    String s = st.nextToken();
                    tree[n] = new MyLeaf(s, -1, -1);
                }
            }
            calc(tree,1);
            int res = stack.get(0);
            System.out.println("#"+test_case+" "+res);
		}
    }
}
