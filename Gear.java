
//14891
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gear {
    static int[][] Gears;

    static void rotate_clock(int n) {
        int tmp = Gears[n][7];
        for (int i = 1; i < 8; i++) {
            Gears[n][i] = Gears[n][i - 1];
        }
        Gears[n][0] = tmp;
    }

    static void rotate_anti_clock(int n) {
        int tmp = Gears[n][0];
        for (int i = 0; i < 7; i++) {
            Gears[n][i] = Gears[n][i + 1];
        }
        Gears[n][7] = tmp;
    }

    static void turn_gear(int n, int d) {
        int[] tmp = new int[4];
        tmp[n] = d;
        int t = d * (-1);
        for (int i = n + 1; i < 4; i++) {
            if (Gears[i - 1][2] != Gears[i][6]) {
                tmp[i] = t;
                t = t * (-1);
            } else {
                break;
            }
        }
        t = d * (-1);
        for (int i = n - 1; i > 0; i--) {
            if (Gears[i + 1][6] != Gears[i][2]) {
                tmp[i] = t;
                t = t * (-1);
            } else {
                break;
            }
        }
        for (int i = 0; i < 4; i++) {
            if (tmp[i] == 1) {
                rotate_clock(i);
            } else if (tmp[i] == (-1)) {
                rotate_anti_clock(i);
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Gears = new int[4][8];
            StringTokenizer st;
            for (int i = 0; i < 4; i++) {
                st = new StringTokenizer(br.readLine());
                String ln = st.nextToken();
                for (int j = 0; j < 8; j++) {
                    Gears[i][j] = Integer.parseInt("" + ln.charAt(j));
                }
            }
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                turn_gear(n, d);
                for (int j = 0; j < 4; j++) {
                    for (int k = 0; k < 8; k++) {
                        System.out.print(Gears[j][k] + " ");
                    }
                    System.out.println();
                }
            }
            int cnt = 0;
            if (Gears[0][0] == 1)
                cnt += 1;
            if (Gears[1][0] == 1)
                cnt += 2;
            if (Gears[2][0] == 1)
                cnt += 4;
            if (Gears[3][0] == 1)
                cnt += 8;
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
