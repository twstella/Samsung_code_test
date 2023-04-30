//11377
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class RulerOfLand {
   static ArrayList<ArrayList<Integer> > G;
   static int V,S,D,M,N,K,A;
   static int[] from,que;
   static int[][] capa, allo;
   static boolean[] visited;
   static void AddEdge(int f,int t,int w){
        G.get(f).add(t);
        G.get(t).add(f);
        capa[f][t] += w;
   }
   static boolean bfs(){
        Arrays.fill(visited,false);
        int frnt=0,rr=0;
        que[rr++]=S;
        visited[S]=true;
        from[S]=-1;
        while(frnt!=rr){
            int n = que[frnt++];
            ArrayList<Integer> see = G.get(n);
            for(Integer e:see){
                if(visited[e]||(capa[n][e]-allo[n][e]==0)) continue;
                que[rr++] = e;
                visited[e] = true;
                from[e] = n;
                if(e==D) return true;
            }
        }
        return false;
    }
    static long GetFlow(){
        from = new int[V];
        long sum =0;
        while(bfs()){
            int n = D;
            int f = from[D];
            int flow = 100000000;
            while(n!=S){
                flow = Math.min(flow,capa[f][n]-allo[f][n]);
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
            G = new ArrayList<ArrayList<Integer> >();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            V = N+M+3;
            S = N+M;
            D = S+1;
            A = D+1;
            que = new int[V];
            visited = new boolean[V];
            capa = new int[V][V];
            allo = new int[V][V];
            for(int i=0;i<V;i++){
                G.add(new ArrayList<>());
            }
            for(int i=0;i<N;i++)
                AddEdge(S, i, 1);
            for(int i=0;i<N;i++){
                AddEdge(A, i, 1);
            }
            for(int i=0;i<M;i++)
                AddEdge(i+N, D, 1);
            AddEdge(S, A, K);
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int J = Integer.parseInt(st.nextToken());
                for(int k=0;k<J;k++){
                    int t = Integer.parseInt(st.nextToken())-1;
                    AddEdge(i, t+N, 1);
                }
            }
            System.out.println(GetFlow());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
