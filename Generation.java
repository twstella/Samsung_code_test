//2644
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Generation {
    static int N,M;
    static ArrayList<ArrayList<Integer> > grph;
    static int[] visited;
    static int bfs(int frm,int to){
        visited =new int[N];
        int[] que = new int[N+4];
        visited[frm] =1;
        int frnt =0,rr=0;
        int cnt=0;
        que[rr++]=frm;
        while(frnt!=rr){
            int ll = rr-frnt;
            for(int i =0;i<ll;i++){
                int n = que[frnt++];
                if(n==to) return cnt;
                for(int e:grph.get(n)){
                    if(visited[e]==0){
                        visited[e]=1;
                        que[rr++]=e;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int frm = Integer.parseInt(st.nextToken())-1;
            int to = Integer.parseInt(st.nextToken())-1;
            M= Integer.parseInt(br.readLine());
            grph = new ArrayList<ArrayList<Integer> >();
            for(int i=0;i<N;i++){
                grph.add(new ArrayList<Integer>());
            }

            for(int i=0;i<M;i++){
                st =new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                grph.get(a).add(b);
                grph.get(b).add(a);
            }
            System.out.println(bfs(frm,to));

        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
