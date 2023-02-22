package samsung_expert;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class SupplyRoad {
    static int N;
    static int[][] map;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] dp ;
  
    static boolean isValid(int r, int c){
        if(r<0||r>=N||c<0||c>=N) return false;
        return true;
    }
    static void dfs(int r,int c){
        for(int i=0;i<4;i++){
            int nr = r+dir[i][0];
            int nc = c+dir[i][1];
            if(isValid(nr, nc)){
                if(dp[nr][nc]>dp[r][c]+map[r][c]){
                    dp[nr][nc] = dp[r][c]+map[r][c];
                    dfs(nr,nc);
                }
            }
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int test_case =1;test_case<=T;test_case++){
                N=Integer.parseInt(br.readLine());
                map = new int[N][N];
                dp = new int[N][N];
                for(int i=0;i<N;i++){
                    String t = br.readLine();
                    for(int j=0;j<N;j++){
                        map[i][j] = t.charAt(j)-'0';
                        dp[i][j] = Integer.MAX_VALUE;
                    }
                }
                dp[0][0] = 0;
                dfs(0,0);
                System.out.println("#"+test_case+" "+dp[N-1][N-1]);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
