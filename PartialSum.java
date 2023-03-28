//1806
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PartialSum {

    static int N,M;
    static int[] arr;

    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new int[N+1];
            for(int i=0;i<N;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }
            int sum =0 ;
            int l = 0;
            int r = 0;
            int min = Integer.MAX_VALUE;
            int len = 0;
            while(r<=N){
                if(sum>=M){
                    sum-=arr[l++];
                    len = r - l +1;
                    if(min>len) min = len;
                }
                else{
                    sum+=arr[r++];
                }
            }
            if(min==Integer.MAX_VALUE) System.out.println(0);
            else System.out.println(min);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
