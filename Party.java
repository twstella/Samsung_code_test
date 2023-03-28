//1238
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Party {
    static int N,M,X;
    static long[][] map;
    static int[] visited;
    static int INF = 2000000;
    static void forAll(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j]= Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
    }
    
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken())-1;
            map = new long[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j]= INF;
                }
            }
            for(int i=0;i<M;i++){
                st=new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                long c = Long.parseLong(st.nextToken());
                map[a][b]=c;
            }
            forAll();
            long max = Long.MIN_VALUE;
            for(int i=0;i<N;i++){
                if(i==X) continue;
                long t = map[i][X] +map[X][i];
                if(t>max) max=t;
            }
            System.out.println(max);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
