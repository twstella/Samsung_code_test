import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
public class CityRoute {
    static int N,M,S,D,V;
    static ArrayList<ArrayList<Integer> > map;
    static boolean[] visited;
    static int[] q,from;
    static int[][] capa,allo;
    static void AddEdge(int f,int t,int w){
        map.get(f).add(t);
        map.get(t).add(f);
        capa[f][t]+=w;
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
                if(visited[e]||capa[n][e]==allo[n][e]) continue;
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
        int sum =0 ;
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
            V = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            S = 0;
            D = 1;
            capa = new int[V][V];
            allo = new int[V][V];
            q = new int[V];
            visited = new boolean[V];
            map = new ArrayList<ArrayList<Integer> >();
            for(int i=0;i<V;i++)
                map.add(new ArrayList<Integer>());
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken())-1;
                int n2 = Integer.parseInt(st.nextToken())-1;
                AddEdge(n1, n2, 1);
            }
            System.out.println(GetFlow());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
