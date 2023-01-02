import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Quit {
    static int[][] cal;
    static int[] dp;
    static int N;

    static int find_max(int t) {
        // System.out.println(">" + t);
        if (t >= N + 1)
            return 0;
        if (dp[t] != -1)
            return dp[t];
        else {
            if (t + cal[t][0] > N + 1) {
                dp[t] = 0;
            } else {
                int max = -1;
                for (int j = t + cal[t][0]; j <= N + 1; j++) {
                    int tmp = cal[t][1] + find_max(j);
                    if (max < tmp)
                        max = tmp;
                }
                dp[t] = max;
            }
        }
        /*
         * for (int i = 1; i <= N; i++) {
         * System.out.print(dp[i] + " ");
         * }
         * System.out.println();
         */

        return dp[t];
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            cal = new int[N + 1][2];
            dp = new int[N + 1];
            for (int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                cal[i][0] = Integer.parseInt(st.nextToken());
                cal[i][1] = Integer.parseInt(st.nextToken());
                dp[i] = -1;
            }
            int max = -1;
            for (int i = 1; i <= N; i++) {
                int tmp = find_max(i);
                if (max < tmp)
                    max = tmp;
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
