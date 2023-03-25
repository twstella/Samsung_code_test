//1707
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
public class Bipartite {
    static int K,V,E;
    static ArrayList<ArrayList<Integer> > grph;
    static int[] que;
    static int[] visited;
    static boolean bfs(int s){
        int frnt=0,rr=0;
        int col=1;
        que[rr++] = s;
        visited[s]=col;
        while(frnt!=rr){
            int ll = rr-frnt;
            col= -col;
            for(int i=0;i<ll;i++){
                int n = que[frnt++];
                for(int e:grph.get(n)){
                    if(visited[e]==0){
                        visited[e]=col;
                        que[rr++]=e;
                    }
                    else{
                        if(visited[e]!=col) return false;
                    }
                }

            }
        }
        return true;
    }
    static int check(){
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(bfs(i)==false) return -1;
            }
        }
        return 1;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            K = Integer.parseInt(br.readLine());
            for(int i=0;i<K;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                V = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                grph = new ArrayList<ArrayList<Integer> >();
                for(int j=0;j<V;j++){
                    grph.add(new ArrayList<Integer>());
                }
                for(int j=0;j<E;j++){
                    st =new StringTokenizer(br.readLine());
                    int a= Integer.parseInt(st.nextToken())-1;
                    int b = Integer.parseInt(st.nextToken())-1;
                    grph.get(a).add(b);
                    grph.get(b).add(a);
                }
                visited=new int[V];
                que=new int[20000];
                int res = check();
                if(res==-1) System.out.println("NO");
                else System.out.println("YES");
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
