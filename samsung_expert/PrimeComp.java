package samsung_expert;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class PrimeComp {
    static int N;
    static int M;
    static int[] nprime = {0,1,4,6,8,9,10,12,14,15,16,18};
    static int[] comb;
    static double getProb(double d,int n){
        if(d==0) return 0.0;
        else if(d==1) return 1.0;
        double res = Math.pow(d,n)*Math.pow((1-d),18-n);
        return res;
    }
    static int compo(int n,int r){
        if(n==r||r==0) return 1;
        return compo(n-1,r-1)+compo(n-1,r);
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            comb = new int[nprime.length];
            for(int i=0;i<nprime.length;i++){
                    comb[i]= compo(18,nprime[i]);
            }
            for(int test =1;test<=T;test++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                double a = N/100.0;
                double b = M/100.0;
                double u=0.0;
                double v = 0.0;
                for(int i=0;i<nprime.length;i++){
                    u+=Math.pow(a,nprime[i])*Math.pow((1-a),(18-nprime[i]))*comb[i];
                    v+=Math.pow(b,nprime[i])*Math.pow((1-b),18-nprime[i])*comb[i];
                }
                double r = 1-u*v;
                double res = Math.round(r*1000000)/1000000.0;
                String s = String.format("%.6f",res);
                System.out.println("#"+test+" "+s);
            }
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
