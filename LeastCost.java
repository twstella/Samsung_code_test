//1916

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.PriorityQueue;
class Point implements Comparable<Point>{
    int n1;
    int w;
    Point(int x,int y){
        n1 =x;
        w = y;
    }
    public  int compareTo(Point o){
        return this.w-o.w;
    }
}
public class LeastCost {
    static int N,M;
    static ArrayList<HashMap<Integer,Integer> > grph;
    static int a,b;

    static int dijk(int st,int to){
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
            if(x==to) return dist[x];
            for(Integer u:grph.get(x).keySet()){
                int t = grph.get(x).get(u);
                if(visited[u]==1) continue;
                if(dist[u]>dist[x]+t){
                    dist[u] = dist[x]+t;
                    q.add(new Point(u,dist[u]));
                }
            }
        }
        return dist[b];
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            grph = new ArrayList<HashMap<Integer,Integer> >();
            for(int i=0;i<N;i++)
                grph.add(new HashMap<Integer,Integer>());
            for(int i=0;i<M;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int z = Integer.parseInt(st.nextToken());
                if(grph.get(x).containsKey(y)){
                    int cur = grph.get(x).get(y);
                    if(cur<=z) continue;
                    else grph.get(x).put(y,z);
                   }
                   else grph.get(x).put(y,z);
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            a =Integer.parseInt(st.nextToken())-1;
            b = Integer.parseInt(st.nextToken())-1;
            System.out.println(dijk(a,b));

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
