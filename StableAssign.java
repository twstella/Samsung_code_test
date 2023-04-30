//2188

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class StableAssign {
    static ArrayList<ArrayList<Integer> > map ;
    static int V,S,D,M,N;
    static int[] from,q;
    static int[][] capa,allo;
    static boolean[] visited;
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
           StringTokenizer st = new StringTokenizer(br.readLine());
           N = Integer.parseInt(st.nextToken());
           M = Integer.parseInt(st.nextToken());
           V = N+M+2;
           S = N+M;
           D = S+1;
           capa = new int[V][V];
           allo = new int[V][V];
           visited = new boolean[V];
           q = new int[V];
           map = new ArrayList<ArrayList<Integer> >();
           for(int i=0;i<V;i++)
                map.add(new ArrayList<Integer>());
            for(int i=0;i<N;i++) AddEdge(S, i, 1);
            for(int i=0;i<M;i++) AddEdge(i+N, D, 1);
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int J = Integer.parseInt(st.nextToken());
                for(int j=0;j<J;j++){
                    int t = Integer.parseInt(st.nextToken())-1;
                    AddEdge(i, N+t, 1);
                }
            }
            System.out.println(GetFlow());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
