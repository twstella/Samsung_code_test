//2617

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FindMarble {
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
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st =new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
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
            int piv = (N+1)/2;
            int ans=0;
            for(int i=0;i<N;i++){
                int lcnt=0,rcnt=0;
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(map[i][j]==INF&&map[j][i]!=INF) lcnt++;
                    else if(map[i][j]!=INF&&map[j][i]==INF) rcnt++;
                }
                if(lcnt>=piv||rcnt>=piv) ans++;
            }
            System.out.println(ans);


        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
