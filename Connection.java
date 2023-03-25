//11724
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Connection {
    static int N,M;
    static int[] visited;
    static ArrayList<ArrayList<Integer> > grph;
    static int[] que;
    static void bfs(int s){
        int frnt = 0,rr =0;
        que[rr++]=s;
        visited[s] =1;
        while(frnt!=rr){
            int n = que[frnt++];
            for(int e:grph.get(n)){
                if(visited[e]==0){
                    visited[e]=1;
                    que[rr++] =e;
                }
            }
        }
    }
    static int check(){
        int cnt=0;
        for(int i=0;i<N;i++){
            if(visited[i]==0){
                bfs(i);
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            grph = new ArrayList<ArrayList<Integer> >();
            for(int i=0;i<N;i++){
                grph.add(new ArrayList<Integer>());
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a= Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                grph.get(a).add(b);
                grph.get(b).add(a);
            }
            visited= new int[N];
            que = new int[100000];
            System.out.println(check());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
