//21924

//~6497
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Road implements Comparable<Road>{
    int x,y;
    int w;
    Road(int n,int m,int l){
        x = n;
        y = m;
        w = l;
    }
    public int compareTo(Road o){
        return this.w-o.w;
    }

}
public class BuildRoad {
    static int N,M;
    static int[] prt;
    static int[] rnk;
    static PriorityQueue<Road> q;
    static int find(int x){
        if(x==prt[x]) return x;
        int t=find(prt[x]);
        prt[x] = t;
        return t;
    }
    static boolean union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return false;
        if(rnk[x]<rnk[y]) prt[x] = y;
        else prt[y] = x;
        if(rnk[x]==rnk[y]) rnk[x]++;
        return true;
    }
    static long kruskal(){
        long sum=0;
        int n = 0;
        while(!q.isEmpty()&&n<N){
            Road e = q.poll();
            int a = find(e.x);
            int b = find(e.y);
            if(a==b) continue;
            else{
                union(a,b);
                sum+=e.w;
                n++;
                if(n==N-1) return sum;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            //~while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            //~if(N==0&&M==0) break;
            q = new PriorityQueue<Road>();
            prt = new int[N+1];
            rnk = new int[N+1];
            long sum =0;
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a =Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                sum+=w;
                q.add(new Road(a,b,w));
            }
            for(int i=0;i<N+1;i++){
                prt[i]=i;
            }
            long res = kruskal();
            if(res!=-1)
                System.out.println(sum-res);
            else System.out.println(res);
        //~}

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
