package samsung_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class tmp {
// SW Expert Academy 1260. 화학물질2
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for (int t=1; t<=T; t++) {
            sb.append("#").append(t).append(" ");
            int N=Integer.parseInt(br.readLine());
            int[][] arr=new int[N][N];
            for (int i=0; i<N; i++) {
                StringTokenizer st=new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    arr[i][j]=Integer.parseInt(st.nextToken());
                }
            }
             
            boolean[][] visited=new boolean[N][N];
            int[][] matrix=new int[20][2];
            int K=0;
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (!visited[i][j]&&arr[i][j]!=0) {
                        int h=0,w=0;
                        while(i+h<N&&arr[i+h][j]!=0) h++;
                        while(j+w<N&&arr[i][j+w]!=0) w++;
                         
                        for (int a=i; a<i+h; a++) {
                            for (int b=j; b<j+w; b++) {
                                visited[a][b]=true;
                            }
                        }
                        matrix[K][0]=h;
                        matrix[K++][1]=w;
                    }
                }
            }
             
            int[][] sortedM=new int[K][2];
            loop:
            for (int i=0; i<K; i++) {
                for (int j=0; j<K; j++) {
                    if (matrix[i][0]==matrix[j][1]&&i!=j)   continue loop;
                }
                sortedM[0][0]=matrix[i][0];
                sortedM[0][1]=matrix[i][1];
                break;
            }
             
            for (int i=0; i<K-1; i++) {
                for (int j=0; j<K; j++) {    // 순서대로 정렬
                    if (sortedM[i][1]==matrix[j][0]) {
                        sortedM[i+1][0]=matrix[j][0];
                        sortedM[i+1][1]=matrix[j][1];
                    }
                }
            }
             
            int[][] dp=new int[K][K];
            for (int i=0; i<K; i++) {
                for (int j=0; j<K-i; j++) {
                    int a=j;
                    int b=i+j;
                    if (a==b)   dp[a][b]=0;
                    else {
                        dp[a][b]=Integer.MAX_VALUE;
                        for (int k=a; k<b; k++) {
                            dp[a][b]=Math.min(dp[a][b], dp[a][k]+dp[k+1][b]
                                    +sortedM[a][0]*sortedM[k][1]*sortedM[b][1]);
                        }
                    }
                }
            }

        sb.append(dp[0][K-1]).append("\n");
        }
        System.out.println(sb);

        br.close();
    }

}