
//13458
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test_director {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] room = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                room[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            long cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += 1;
                int tmp = room[i] - B;
                if (tmp <= 0)
                    continue;
                if (tmp % C == 0)
                    cnt += tmp / C;
                else
                    cnt += ((tmp / C) + 1);

            }
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}