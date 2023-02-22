package samsung_expert;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;



class Node implements Comparable<Node>{
    int idx,cost;
    Node(int i,int c){
        idx= i;
        cost = c;
    }
    public int compareTo(Node o){
        return this.cost - o.cost;
    }
}
public class Network {
    static int N;
    static ArrayList<Node>[] grp;
    static PriorityQueue<Node> q ;
    static int[] visited;
    static int[] dist;
    static void dijk(int st){
        visited = new int[N];
        dist = new int[N];
        q = new PriorityQueue<Node>();
        for(int i=0;i<N;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        q.add(new Node(st,0));
        dist[st] =0;
        while(!q.isEmpty()){
            Node e = q.poll();
            int x = e.idx;
            if(visited[x]==0){
                visited[x] = 1;
                for(int i = 0;i<grp[x].size();i++){
                    int v = grp[x].get(i).idx;
                    int c = grp[x].get(i).cost;
                    if(dist[v]>dist[x]+c){
                        dist[v] = dist[x]+c;
                        q.add(new Node(v,dist[v]));
                    }
                }
            }
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int test=1;test<=T;test++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                grp = new ArrayList[N];
                for(int i=0;i<N;i++){
                    grp[i] = new ArrayList<Node>();
                }
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        int k = Integer.parseInt(st.nextToken());
                        if(k==1){
                            grp[i].add(new Node(j,1));
                            grp[j].add(new Node(i,1));
                        }
                    }
                }
                int min = Integer.MAX_VALUE;
                for(int i=0;i<N;i++){
                    int sum =0;
                    dijk(i);
                    for(int j=0;j<N;j++){
                        sum+=dist[j];
                    }
                    if(min>sum) min = sum;
                }
                System.out.println("#"+test+" "+min);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }   
}
