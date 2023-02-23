//14938

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BattleGround {
    static int N,M,L;
    static int[] items;
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
            L = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j]=INF;
                    if(i==j) map[i][j]=0;
                }
            }
            st = new StringTokenizer(br.readLine());
            items = new int[N];
            for(int i=0;i<N;i++)
                items[i] = Integer.parseInt(st.nextToken());
            for(int i=0;i<L;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                map[a][b] = c;
                map[b][a] = c;
            }
            allPath();
            int max = Integer.MIN_VALUE;
            for(int i=0;i<N;i++){
                int sum = 0;
                for(int j=0;j<N;j++){
                    if(map[i][j]==INF) continue;
                    if(map[i][j]<=M) sum+=items[j];
                }
                max = Math.max(max,sum);
            }
            System.out.println(max);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
