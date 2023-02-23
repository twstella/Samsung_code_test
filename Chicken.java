//21278
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Chicken {
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
            StringTokenizer st  = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = INF;
                    if(i==j) map[i][j] =0;
                }
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                map[a][b]=1;
                map[b][a] =1;
            }
            allPath();
            int min = INF;
            int p1=-1;
            int p2 = -1;
            for(int i=0;i<N;i++){
                for(int j=i+1;j<N;j++){
                    int sum = 0;
                    for(int k=0;k<N;k++){
                        sum+=Math.min(map[i][k],map[j][k]);
                    }
                    if(min>sum){
                        p1 =i;
                        p2 =j;
                        min=sum;
                    }
                }
            }
            System.out.println((p1+1)+" "+(p2+1)+" "+2*min);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
