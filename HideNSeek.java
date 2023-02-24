//13549

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.HashMap;

class Pnt implements Comparable<Pnt>{
    int x;
    int cost;
    Pnt(int n,int w){
        x = n;
        cost = w;
    }
    public int compareTo(Pnt o){
        return this.cost - o.cost;
    }
}
public class HideNSeek {
    static int N,K;
    static int dijk(int from,int to){
        int L = (K>N)?K:N;
        int[] visited=new int[L+2];
        int[] cost = new int[L+2];
        PriorityQueue<Pnt> pq =new PriorityQueue<Pnt>();
        for(int i=0;i<2+L;i++){
            cost[i] = Integer.MAX_VALUE;
        }
        cost[from]=0;
        pq.add(new Pnt(from,0));
        while(!pq.isEmpty()){
            Pnt e = pq.poll();
            int n = e.x;
            if(visited[n]==1) continue;
            if(n==to) return cost[n];
            int t = n+1;
            if(t>=0&&t<2+L&&visited[t]==0&&cost[t]>cost[n]+1){
                cost[t] = cost[n]+1;
                pq.add(new Pnt(t,cost[t]));
            }
            t = n-1;
            if(2+L>t&&t>=0&&visited[t]==0&&cost[t]>cost[n]+1){
                cost[t] = cost[n]+1;
                pq.add(new Pnt(t,cost[t]));
            }
            t = n*2;
            if(0<=t&&t<2+L&&visited[t]==0&&cost[t]>cost[n]){
                cost[t]=cost[n];
                pq.add(new Pnt(t,cost[t]));
            }
        }
        
        return -1;
    }
    public static void main(String[] args){
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer (br.readLine());
            N = Integer.parseInt(st.nextToken());
            K= Integer.parseInt(st.nextToken());

            System.out.println(dijk(N,K));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
