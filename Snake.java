
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

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

class Turn {
    int n;
    char dir;

    public Turn(int t, char d) {
        n = t;
        dir = d;
    }
}

public class Snake {
    static int N;
    static int K;
    static int[][] map;
    static int L;
    static ArrayList<Pos> snake = new ArrayList<Pos>();
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
    static int d = 1;

    static boolean isValid(int r, int c) {
        if (r >= N || r < 0 || c >= N || c < 0)
            return false;
        return true;
    }

    static int go(int r, int c, int t) {
        int sec = 0;
        for (int i = 1; i <= t; i++) {
            int x = dir[d][0] * i + r;
            int y = dir[d][1] * i + c;
            System.out.println(i + ":");
            if (isValid(x, y)) {
                snake.add(new Pos(x, y));
                // String s = "1:";
                // for (Pos p : snake) {
                // s += p.toString() + "-";
                // }
                // System.out.println(s);
                if (snake.size() >= 4) {
                    for (int j = 1; j < snake.size() - 3; j++) {
                        Pos m = snake.get(j - 1);
                        Pos p = snake.get(j);
                        if ((m.x == p.x && Math.min(m.y, p.y) <= y && y <= Math.max(m.y, p.y))
                                || (m.y == p.y && Math.min(m.x, p.x) <= x && x <= Math.max(m.x, p.x))) {
                            snake.remove(snake.size() - 1);
                            sec++;
                            // System.out.println("khjkjkj");
                            return sec;
                        }
                    }
                }
                sec++;
                if (map[x][y] != 2)
                    snake.remove(0);
                String s = "";
                for (Pos p : snake) {
                    s += p.toString() + "-";
                }
                System.out.println(s);
            } else {
                sec++;
                return sec;
            }
        }
        return sec;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
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
            Turn[] tmp = new Turn[L];
            for (int i = 0; i < L; i++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                char k = st.nextToken().charAt(0);
                tmp[i] = new Turn(n, k);
            }
            int cnt = 0;

            snake.add(new Pos(0, 0));
            for (int i = 0; i < L; i++) {
                int n = tmp[i].n;
                char k = tmp[i].dir;
                int sec = go(snake.get(snake.size() - 1).x, snake.get(snake.size() - 1).y, n - cnt);
                cnt += sec;
                if (cnt < n)
                    break;
                System.out.println(d);
                if (k == 'D') {
                    d = d - 1;
                    if (d < 0)
                        d = 3;
                } else if (k == 'L') {
                    d = (d + 1) % 4;
                }
                System.out.println(d);
            }
            System.out.println(cnt);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
