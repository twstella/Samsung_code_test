package samsung_expert;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Correctness {
    static int N;
    static char[] A;
    static char[] B;
    public static void main(String[] args){

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
    
            for(int test = 1;test<=T;test++){
                N= Integer.parseInt(br.readLine().trim());
                String a = "0"+br.readLine();
                String b = "0"+br.readLine();
                A=a.toCharArray();
                B =b.toCharArray();
                int[][] dp = new int[N+1][N+1];

                for(int i=1;i<=N;i++){
                    for(int j=1;j<=N;j++){
                        if(A[i]==B[j]){
                            dp[i][j] = dp[i-1][j-1]+1;
                        }
                        else
                            dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
                double rst = 1.0*dp[N][N]/N*100;
                String r = String.format("%.2f", rst);
                System.out.println("#"+test+" "+r);
            }
    
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
