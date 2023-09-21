//10870
import java.util.Arrays;
import java.util.Scanner;

public class Fibo {
	static int[] dp;
	static int fibo(int n) {
		if(n==0) return 0;
		if(n==1) return 1;
		if(dp[n]!=-1) return dp[n];
		dp[n] = fibo(n-1)+fibo(n-2);
		return dp[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dp = new int[21];
		Arrays.fill(dp, -1);
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		System.out.println(fibo(n));
	}

}
