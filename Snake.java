
//3190
import java.util.StringTokenizer;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Pos {
    int x, y;

    public Pos(int r, int c) {
        x = r;
        y = c;
    }

    public void print() {
        System.out.print("(" + x + "," + y + ")");
    }
}

public class Snake {
    static int N;
    static int K;
    static int[][] map;
    static int L;
    static int[][] visited;
    static ArrayList<Pos> snake = new ArrayList<Pos>();
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int d = 1;

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new int[N][N];
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                map[x][y] = 2;
            }
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int r = 0, c = 0;
            snake.add(new Pos(0, 0));
            int j = 0;
            for (int i = 0; i < L; i++) {
                int sec = 0;
                st = new StringTokenizer(br.readLine());
                int t = Integer.parseInt(st.nextToken());
                char m = st.nextToken().charAt(0);
                int[] l = { dir[d][0], dir[d][1] };
                boolean flag = true;
                System.out.println(j + ":(" + r + "," + c + ")");
            }
            System.out.println(cnt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
