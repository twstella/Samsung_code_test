package samsung_expert;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
class MyLeaf{
    int l,r;
    String d;
    MyLeaf(String c,int le,int ri){
        l = le;
        r = ri;
        d = c;
    }
}
public class Calc {
    static ArrayList<Integer> stack;
    static int calc(MyLeaf[] tmp,int n){
        if(tmp[n].l!=-1) calc(tmp,tmp[n].l);
        if(tmp[n].r!=-1) calc(tmp,tmp[n].r);
        try{
            int k = Integer.parseInt(tmp[n].d);
            stack.add(0,k);
        }catch(Exception e){
            try{
                int a = stack.remove(0);
                int b =stack.remove(0);
                if(tmp[n].d.equals("+")) stack.add(0,b+a);
                else if(tmp[n].d.equals("-")) stack.add(0,b-a);
                else if(tmp[n].d.equals("*")) stack.add(0,b*a);
                else if(tmp[n].d.equals("/")) stack.add(0,b/a);
                else return 0;
            }
            catch(IndexOutOfBoundsException ib){
                return 0;
            }
            catch(ArithmeticException ar){
                stack.add(0,1);
            }
        }

        return 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
            stack = new ArrayList<Integer>();
		    int N = Integer.parseInt(sc.nextLine());
			MyLeaf[] tree = new MyLeaf[N+1];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
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
                else if(st.countTokens()==2){
                    int n = Integer.parseInt(st.nextToken());
                    String s = st.nextToken();
                    tree[n] = new MyLeaf(s,-1,-1);
                }
            }
            int ans = calc(tree,1);
            if(stack.size()>1) ans = 0;
            System.out.println("#"+test_case+" "+ans);
		}
    }
}
