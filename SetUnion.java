//1717
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SetUnion {
    static int N,M;
    static int[] parent;
    static int[] cnt;
    static int find(int x){
        if(parent[x]==x) return x;
        else {
            int t = find(parent[x]);
            parent[x] = t;
            return t;
        }
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        if(cnt[x]<cnt[y]) parent[x]=y;
        else parent[y]=x;
        if(cnt[x]==cnt[y]) cnt[x]++;
    }
    public static void main (String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            parent = new int[N+1];
            cnt = new int[N+1];
            for(int i=0;i<N+1;i++){
                parent[i] = i;
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int u = find(a);
                int v = find(b);
                if(c==0){
                    union(u,v);
                }
                else if(c==1){
                    if(u==v) System.out.println("YES");
                    else System.out.println("NO");
                }

            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
