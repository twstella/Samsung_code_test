//1753

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.ArrayList;

class Point implements Comparable<Point>{
    int n1;
    int w;
    Point(int x,int z){
        n1=x;
        w=z;
    }
    public int compareTo(Point o){
        return this.w-o.w;
    }

}
public class Shortest {
    static int N,M;
    static int P;
    static ArrayList<HashMap<Integer,Integer> > grph;
    static void dijk(int st){
        int[] visited =new int[N];
        int[] dist = new int[N];
        PriorityQueue<Point> q = new PriorityQueue<Point>();
        for(int i=0;i<N;i++) dist[i] = Integer.MAX_VALUE;
        dist[st]=0;
        q.add(new Point(st,0));
        while(!q.isEmpty()){
            Point e = q.poll();
            int x = e.n1;
            if(visited[x]==1) continue;
            visited[x]=1;
            for(Integer u:grph.get(x).keySet()){
                int t = grph.get(x).get(u);
                if(visited[u]==1) continue;
                if(dist[u]>dist[x]+t){
                    dist[u] = dist[x]+t;
                    q.add(new Point(u,dist[u]));
                }
            }
        }
        for(int i=0;i<N;i++){
            if(dist[i]!=Integer.MAX_VALUE)
                System.out.println(dist[i]);
            else System.out.println("INF");
        }
    }
    
    public static void  main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(br.readLine())-1;
            grph = new ArrayList<HashMap<Integer,Integer> >();
            for(int i=0;i<N;i++){
                grph.add(new HashMap<Integer,Integer>());
            }
           
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
               if(grph.get(a).containsKey(b)){
                int cur = grph.get(a).get(b);
                if(cur<=c) continue;
                else grph.get(a).put(b,c);
               }
               else grph.get(a).put(b,c);
            }
            dijk(P);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
