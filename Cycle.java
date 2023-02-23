//20040
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cycle {
    static int N,M;
    static int[] prt;
    static int[] rnk;
    static int find(int x){
        if(x==prt[x]) return x;
        int t = find(prt[x]);
        prt[x]=t;
        return t;
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        if(rnk[x]<rnk[y]) prt[x]=y;
        else prt[y]=x;
        if(rnk[x]==rnk[y]) rnk[x]++;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            prt = new int[N];
            rnk = new int[N];
            for(int i=0;i<N;i++){
                prt[i]=i;
            }
            int idx=0;
            for(;idx<M;idx++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int u = find(a);
                int v = find(b);
                if(u==v) break;
                union(u,v);
            }
            if(idx==M)
                System.out.println(0);
            else 
                System.out.println(idx+1);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
