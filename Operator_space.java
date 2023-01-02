
//14888
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Operator_space {
    static int N;
    static int[] numeral;
    static int[] operator;
    static ArrayList<String> ops = new ArrayList<String>();

    static void get_op(int a, int s, int m, int d, String t) {
        if ((a <= 0 && s <= 0 && m <= 0 && d <= 0)) {
            ops.add(t);
            return;
        } else {
            if (a > 0) {
                get_op(a - 1, s, m, d, t + "+");
            }
            if (s > 0) {
                get_op(a, s - 1, m, d, t + "-");
            }
            if (m > 0) {
                get_op(a, s, m - 1, d, t + "*");
            }
            if (d > 0) {
                get_op(a, s, m, d - 1, t + "/");
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            numeral = new int[N];
            operator = new int[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numeral[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                operator[i] = Integer.parseInt(st.nextToken());
            }
            get_op(operator[0], operator[1], operator[2], operator[3], "");
            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < ops.size(); i++) {
                String ooo = ops.get(i);
                // System.out.println(ooo);
                long cnt = numeral[0];
                boolean flag = true;
                for (int k = 0; k < N - 1; k++) {
                    if (ooo.charAt(k) == '+')
                        cnt += numeral[k + 1];
                    else if (ooo.charAt(k) == '-')
                        cnt -= numeral[k + 1];
                    else if (ooo.charAt(k) == '*')
                        cnt *= numeral[k + 1];
                    else if (ooo.charAt(k) == '/') {
                        if (numeral[k + 1] == 0) {
                            flag = false;
                            break;
                        }
                        if (cnt < 0 && numeral[k + 1] > 0) {
                            long tmp = -1 * cnt;
                            tmp = tmp / numeral[k + 1];
                            cnt = -1 * tmp;
                        } else
                            cnt /= numeral[k + 1];
                    }
                }
                if (flag) {
                    if (cnt < min)
                        min = cnt;
                    if (max < cnt)
                        max = cnt;
                }
                // System.out.println(max);
                // System.out.println(min);
            }
            System.out.println(max);
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
