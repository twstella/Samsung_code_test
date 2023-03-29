//2631
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.HashMap;
import java.util.ArrayList;

public class Lineing {
    static int N;
    static int[] arr;
    static HashMap<String,Integer> map ;
    
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            int[] dp = new int[N];
            for(int i=0;i<N;i++){
                int x = Integer.parseInt(br.readLine());
                arr[i] =x;
            }
            dp[0]=1;
            int ans = 0;
            for(int i=0;i<N;i++){
                dp[i]=1;
                for(int j=0;j<i;j++){
                    if(arr[i]>arr[j]) dp[i]=Math.max(dp[i],dp[j]+1);
                }
                ans =Math.max(ans,dp[i]);
            }
            System.out.println(N-ans);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
