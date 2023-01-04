
//14502
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class Research_center {
    static int N;
    static int M;
    static ArrayList<Pos> map = new ArrayList<Pos>();
    static int[][] resrch;
    static int[][] tmp;
    static ArrayList<Pos> virus = new ArrayList<Pos>();
    static ArrayList<String> store = new ArrayList<String>();
    static int[][] visited;
    static ArrayList<Pos> q;

    static void comp(int n, int c, String s) {
        if (n <= 0) {
            if (c == 0) {
                store.add(s);
            }
            return;
        } else {
            if (c == 0) {
                comp(n - 1, 0, s + "0");
            } else {
                comp(n - 1, c - 1, s + "1");
                comp(n - 1, c, s + "0");
            }

        }
    }

    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = resrch[i][j];
                visited[i][j] = 0;
            }
        }
        q = new ArrayList<Pos>();
        for (int i = 0; i < virus.size(); i++) {
            q.add(virus.get(i));
        }
    }

    static int spread(int cnt) {
        while (!q.isEmpty()) {
            Pos t = q.remove(0);
            cnt -= 1;
            visited[t.x][t.y] = 1;
            tmp[t.x][t.y] = 2;
            if (t.x + 1 < N && visited[t.x + 1][t.y] == 0 && tmp[t.x + 1][t.y] == 0) {
                visited[t.x + 1][t.y] = 1;
                q.add(new Pos(t.x + 1, t.y));
            }
            if (t.x - 1 >= 0 && visited[t.x - 1][t.y] == 0 && tmp[t.x - 1][t.y] == 0) {
                visited[t.x - 1][t.y] = 1;
                q.add(new Pos(t.x - 1, t.y));
            }
            if (t.y + 1 < M && visited[t.x][t.y + 1] == 0 && tmp[t.x][t.y + 1] == 0) {
                visited[t.x][t.y + 1] = 1;
                q.add(new Pos(t.x, t.y + 1));
            }
            if (t.y - 1 >= 0 && visited[t.x][t.y - 1] == 0 && tmp[t.x][t.y - 1] == 0) {
                visited[t.x][t.y - 1] = 1;
                q.add(new Pos(t.x, t.y - 1));
            }
        }
        int k = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tmp[i][j] == 0)
                    k += 1;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            resrch = new int[N][M];
            visited = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    resrch[i][j] = Integer.parseInt(st.nextToken());
                    if (resrch[i][j] == 0)
                        map.add((new Pos(i, j)));
                    else if (resrch[i][j] == 2)
                        virus.add(new Pos(i, j));
                }
            }
            tmp = new int[N][M];
            int max = Integer.MIN_VALUE;
            comp(map.size(), 3, "");
            for (int i = 0; i < store.size(); i++) {
                init();
                String lin = store.get(i);
                for (int j = 0; j < lin.length(); j++) {
                    if (lin.charAt(j) == '1') {
                        Pos p = map.get(j);
                        tmp[p.x][p.y] = 1;
                    }
                }
                int r = spread(map.size());
                if (max < r)
                    max = r;
            }
            System.out.println(max);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
