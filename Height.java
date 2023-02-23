//2458
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Height {
    static int N,M;
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
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) map[i][j] =0;
                    else
                    map[i][j] = INF;
                }
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                map[a][b] = 1;
            }
            allPath();
            int rst=0;
            for(int i=0;i<N;i++){
                int cnt =0;
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(map[i][j]==INF&&map[j][i]!=INF) cnt++;
                    else if(map[i][j]!=INF&&map[j][i]==INF) cnt++;
                }
                if(cnt==N-1) rst++;
            }
            System.out.println(rst);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
