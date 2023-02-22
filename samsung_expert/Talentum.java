package samsung_expert;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Talentum {
    static int N;
    static int M;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int test=1;test<=T;test++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                
                int q = N/M;
                int p = N%M;
                double max = Math.pow(q,M-p) * Math.pow(q+1,p);
                String s = String.format("%.0f", max);
                System.out.println("#"+test+" "+s);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
