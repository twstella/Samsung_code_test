import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
class Shark{
    int size,speed,intel;
    Shark(int sz,int sp,int itel){
        size = sz;
        speed = sp;
        intel = itel;
    }
}
public class SharkDining {
    static ArrayList<ArrayList<Integer> > map;
    static int N,M,S,D,V;
    static Shark[] sharks;
    static boolean[] visited;
    static int[] from, q;
    static int[][] capa,allo;
    static void AddEdge(int f,int t,int w){
        map.get(f).add(t);
        map.get(t).add(f);
        capa[f][t] += w;
    }
    static boolean bfs(){
        Arrays.fill(visited,false);
        int frnt =0,rr=0;
        q[rr++] =  S;
        visited[S] = true;
        from[S] = -1;
        while(frnt!=rr){
            int n = q[frnt++];
            ArrayList<Integer> see = map.get(n);
            for(Integer e:see){
                if(visited[e]==true||capa[n][e]-allo[n][e]==0) continue;
                q[rr++] = e;
                visited[e] = true;
                from[e] = n;
                if(e==D) return true;
            }
        }
        return false;
    }
    static int GetFlow(){
        from = new int[V];
        int sum =0;
        while(bfs()){
            int n = D;
            int f = from[D];
            int flow = 100000000;
            while(n!=S){
                flow = Math.min(flow, capa[f][n]-allo[f][n]);
                n = f;
                f = from[n];
            }
            n = D;
            f = from[D];
            while(n!=S){
                allo[f][n] += flow;
                allo[n][f] -= flow;
                n = f;
                f = from[n];
            }
            sum+= flow;
        }
        return sum;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            M = N;
            V = N +M+2;
            S = N+M;
            D = S+1;
            map = new ArrayList<ArrayList<Integer> >();
            visited = new boolean[V];
            from = new int[V];
            capa = new int[V][V];
            allo = new int[V][V];
            sharks = new Shark[N];
            q = new int[V];
            for(int i=0;i<V;i++)
                map.add(new ArrayList<Integer>());
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int sp = Integer.parseInt(st.nextToken());
                int intel = Integer.parseInt(st.nextToken());
                sharks[i] = new Shark(s, sp, intel);
            }
            for(int i=0;i<N;i++) AddEdge(S, i, 2);
            for(int i=0;i<M;i++) AddEdge(i+N, D, 1);
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(sharks[i].size==sharks[j].size&&sharks[i].speed==sharks[j].speed&&sharks[i].intel==sharks[j].intel&&i<j) continue;
                    if(sharks[i].size>=sharks[j].size && sharks[i].speed>=sharks[j].speed&&sharks[i].intel>=sharks[j].intel) {
                        //AddEdge(i, j+N, 1);
                        if(sharks[i].size==sharks[j].size&&sharks[i].speed==sharks[j].speed&&sharks[i].intel==sharks[j].intel){
                            map.get(i).add(N+j);
                            capa[i][N+j] +=1;
                        }
                        else{
                            AddEdge(i, j+N, 1);
                        }
                    }
                }
            }
            System.out.println(N-GetFlow());
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
