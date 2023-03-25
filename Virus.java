//2606
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
public class Virus{
    static int N,M;
    static int[] visited;
    static ArrayList<ArrayList<Integer> > grph;
    static int bfs(int n){
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(n);
        int cnt=0;
        while(!tmp.isEmpty()){
            int e = tmp.remove(0);
            if(visited[e]==1) continue;
            visited[e]=1;
            cnt++;
            ArrayList<Integer> arr = grph.get(e);
            for(int k:arr){
                if(visited[k]==0) tmp.add(0,k);
            }
        }
        return cnt-1;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N= Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            visited =new int[N];
            grph = new ArrayList<ArrayList<Integer> >();
            for(int i=0;i<N;i++){
                grph.add(new ArrayList<Integer>());
            }
            for(int i=0;i<M;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                grph.get(a).add(b);
                grph.get(b).add(a);
            }
            System.out.println(bfs(0));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}