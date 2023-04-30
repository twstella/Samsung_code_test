import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
public class MaxFlow {
    static ArrayList<ArrayList< Integer> > map;
    static int N,M,S,D,V;
    static int[][] capa, allo;
    static boolean[] visited;
    static int[] q,from;
    static void AddEdge(int f,int t,int w){
        map.get(t).add(f);
        map.get(f).add(t);
        capa[f][t]+=w;
        capa[t][f]+=w;
    }
    static int getNode(String s){
        if(s.charAt(0)<'a')
            return ((int)(s.charAt(0)-'A'));
        else return ((int)(s.charAt(0)-'a'))+26;
    }
    static boolean bfs(){
        Arrays.fill(visited,false);
        int frnt=0,rr=0;
        q[rr++] = S;
        visited[S] = true;
        from[S] = -1;
        while(frnt!=rr){
            int n = q[frnt++];
            ArrayList<Integer> see = map.get(n);
            for(Integer e:see){
                if(visited[e]||allo[n][e]==capa[n][e]) continue;
                visited[e] = true;
                q[rr++] = e;
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
            int n =D;
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
                allo[f][n]+=flow;
                allo[n][f] -= flow;
                n = f;
                f = from[n];
            }
            sum+=flow;
        }
        return sum;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt( br.readLine() );
        V = 52; S =0; D = 25; 
        capa = new int[V][V]; allo = new int[V][V];
        q = new int[V]; visited = new boolean[V];

        map = new ArrayList<ArrayList<Integer>> ();
        for (int i=0; i<V; i++)
        map.add(new ArrayList<Integer>());

        int d1, d2, d3; 
        for (int i=0; i< N; i++) {
        StringTokenizer st = 
            new StringTokenizer( br.readLine() );
        d1 = getNode(st.nextToken());
        d2 = getNode(st.nextToken());
        d3 = Integer.parseInt(st.nextToken());
        AddEdge(d1, d2, d3);
        }
        System.out.println(GetFlow());
    }
    
}
