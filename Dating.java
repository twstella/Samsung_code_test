//14621
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Road implements Comparable<Road>{
    int x,y;
    int w;
    Road(int a,int b,int l){
        x=a;
        y=b;
        w = l;
    }
    public int compareTo(Road o){
        return this.w-o.w;
    }
}

public class Dating {
    static int N,M;
    static int[] gen;
    static int[] prt;
    static int[] rnk;
    static PriorityQueue<Road> q;
    static int find(int x){
        if(prt[x]==x) return x;
        int t= find(prt[x]);
        prt[x] =t;
        return t;
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        if(rnk[x]<rnk[y]) prt[x]=y;
        else prt[y] = x;
        if(rnk[x]==rnk[y]) rnk[x]++;
    }
    static long kruskal(){
        long sum =0;
        int ln = 0;
        while(!q.isEmpty()){
            Road e= q.poll();
            int a = find(e.x);
            int b = find(e.y);
            if(a==b||gen[e.x]==gen[e.y]) continue;
            else{
                union(a,b);
                ln++;
                sum+=e.w;
            }
            if(ln==N-1) return sum;
        }
        return -1;
    }
    public static void main(String[] args){
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer (br.readLine());
            N= Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            prt=new int[N+1];
            rnk = new int[N+1];
            for(int i=0;i<=N;i++){
                prt[i] = i;
            }
            gen = new int[N+1];
            q = new PriorityQueue<Road>();
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                String s = st.nextToken();
                if(s.equals("M")) gen[i+1]=0;
                else gen[i+1] =1;
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                q.add(new Road(a,b,w));
            }
            long res = kruskal();
            System.out.println(res);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
