//1613
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class History {
    static int N,M,L;
    static int[][] map;
    static int INF = 10000000;
    static void allPath(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
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
            map =  new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                     map[i][j] = INF;
                }
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                map[a][b] =1;
            }
            allPath();
            L = Integer.parseInt(br.readLine());
            for(int i=0;i<L;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                if(map[a][b]!=INF) System.out.println("-1");
                else if(map[b][a]!= INF) System.out.println("1");
                else System.out.println("0");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
