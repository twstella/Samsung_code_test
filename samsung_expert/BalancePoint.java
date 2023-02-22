package samsung_expert;
import java.util.Scanner;
public class BalancePoint {
    static int N;
    static double[] pos;
    static double[] mass;
    static double getForce(int i,double x){
        return mass[i]/Math.pow(pos[i]-x, 2);
    }
    static double biSearch(int piv, double l,double h){
        double x = 0;
        double sum =0;
        int it = 0;
        while(it<=100){
            sum =0;
            x = (l+h)/2;
            for(int i=0;i<=piv;i++){
                sum+=getForce(i, x);
            }
            for(int i=piv+1;i<N;i++){
                sum-=getForce(i, x);
            }
            if(sum>0){
                l = x;

            }
            else if(sum<0){
                h = x;
            }
            it++;
        }
        return x;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            pos = new double[N];
            mass = new double[N];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                pos[i] = sc.nextDouble();
            }
            for(int i=0;i<N;i++){
                mass[i] = sc.nextDouble();
            }
            String ans = "#"+test_case+" ";
            for(int i=0;i<N-1;i++){
                ans+=String.format("%.10f ",biSearch(i,pos[i], pos[i+1]));
            }
            System.out.println(ans);
		}
    }
}
