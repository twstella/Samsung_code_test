package samsung_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Chemical {
    static int N;
    static int[][] map;
    static int[][] visited;
    
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T=Integer.parseInt(br.readLine());
            for(int test=1;test<=T;test++){
                N = Integer.parseInt(br.readLine());
                map = new int[N][N];
                for(int i=0;i<N;i++){
                    StringTokenizer st = new StringTokenizer(br.readLine());
                    for(int j=0;j<N;j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                visited = new int[N][N];
                int[][] mat = new int[N][2];
                int K = 0;
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(visited[i][j]==0&&map[i][j]!=0){
                            int h=0;
                            int w = 0;
                            while(i+h<N&&map[i+h][j]!=0) h++;
                            while(j+w<N&&map[i][j+w]!=0) w++;
                            for(int a=i;a<i+h;a++){
                                for(int b=j;b<j+w;b++){
                                    visited[a][b] = 1;
                                }
                            }
                            mat[K][0] =h;
                            mat[K++][1]=w;
                        }
                    }
                }  
                int[][] sort = new int[K][2];
                brk:
                for(int i=0;i<K;i++){
                    for(int j=0;j<K;j++){
                        if(mat[i][0]==mat[j][1]&&i!=j)
                            continue brk;
                    }
                    sort[0][0] = mat[i][0];
                    sort[0][1] = mat[i][1];
                    break;
                }   

                for(int i=0;i<K-1;i++){
                    for(int j=0;j<K;j++){
                        if(sort[i][1]==mat[j][0]){
                            sort[i+1][0] = mat[j][0];
                            sort[i+1][1] = mat[j][1];
                        }
                    }
                }
                int[][] dp = new int[K][K];
                for(int i=0;i<K;i++){
                    for(int j=0;j<K-i;j++){
                        int a = j;
                        int b = i+j;
                        if(a==b) dp[a][b] = 0;
                        else{
                            dp[a][b] = Integer.MAX_VALUE;
                            for(int k=a;k<b;k++){
                                dp[a][b] = Math.min(dp[a][b],dp[a][k]+dp[k+1][b]+
                                sort[a][0]*sort[k][1]*sort[b][1]);
                            }
                        }
                    }
                }
                System.out.println("#"+test+" "+dp[0][K-1]);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
