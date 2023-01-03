
//14889
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class StartLink {
    static int N;
    static int[][] score;
    static ArrayList<String> Comp = new ArrayList<String>();

    static void composition(int a, int n, String s) {
        if (a <= 0) {
            if (n <= 0)
                Comp.add(s);
            return;
        } else {
            if (n == 0) {
                composition(a - 1, n, s + "0");
            } else {
                composition(a - 1, n - 1, s + "1");
                composition(a - 1, n, s + "0");
            }

        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            score = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    score[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            composition(N, (N / 2), "");
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < Comp.size(); i++) {
                int A = 0;
                int B = 0;
                String tmp = Comp.get(i);
                for (int j = 0; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        if (tmp.charAt(j) == '0' && tmp.charAt(k) == '0')
                            A += score[j][k] + score[k][j];
                        else if (tmp.charAt(j) == '1' && tmp.charAt(k) == '1')
                            B += score[j][k] + score[k][j];
                    }
                }
                int abs = Math.abs(A - B);
                if (min > abs)
                    min = abs;
            }
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
