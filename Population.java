
//16234
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

class Pos {
    int x, y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class Population {
    static int N;
    static int L;
    static int R;
    static int[][] A;
    static ArrayList<Pos> q = new ArrayList<Pos>();
    static Pos[][] parent;
    static int[][] visited;

    static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                parent[i][j] = new Pos(i, j);
                visited[i][j] = 0;
            }
        }
    }

    static boolean step() {
        boolean flag = false;
        HashMap<Pos, Integer> pop = new HashMap<Pos, Integer>();
        HashMap<Pos, Integer> size = new HashMap<Pos, Integer>();
        while (!q.isEmpty()) {
            Pos t = q.remove(0);
            if (t.x + 1 < N) {
                if (visited[t.x + 1][t.y] == 0) {
                    visited[t.x + 1][t.y] = 1;
                    q.add(new Pos(t.x + 1, t.y));
                }
                int sum = Math.abs(A[t.x][t.y] - A[t.x + 1][t.y]);
                if (sum >= L && sum <= R) {
                    parent[t.x + 1][t.y] = parent[t.x][t.y];
                    if (pop.containsKey(parent[t.x][t.y])) {
                        int cnt = pop.get(parent[t.x][t.y]);
                        pop.put(parent[t.x][t.y], cnt + A[t.x + 1][t.y]);
                        int p = size.get(parent[t.x][t.y]);
                        size.put(parent[t.x][t.y], p + 1);
                    } else {
                        pop.put(parent[t.x][t.y], A[t.x + 1][t.y]);
                        size.put(parent[t.x][t.y], 1);
                    }
                    flag = true;
                }
            }
            if (t.x - 1 >= 0) {
                if (visited[t.x - 1][t.y] == 0) {
                    visited[t.x - 1][t.y] = 1;
                    q.add(new Pos(t.x - 1, t.y));
                }
                int sum = Math.abs(A[t.x - 1][t.y] - A[t.x][t.y]);
                if (sum >= L && sum <= R) {
                    parent[t.x - 1][t.y] = parent[t.x][t.y];
                    if (pop.containsKey(parent[t.x][t.y])) {
                        int cnt = pop.get(parent[t.x][t.y]);
                        pop.put(parent[t.x][t.y], cnt + A[t.x - 1][t.y]);
                        int p = size.get(parent[t.x][t.y]);
                        size.put(parent[t.x][t.y], p + 1);
                    } else {
                        pop.put(parent[t.x][t.y], A[t.x - 1][t.y]);
                        size.put(parent[t.x][t.y], 1);
                    }
                    flag = true;
                }
            }
            if (t.y + 1 < N && visited[t.x][t.y + 1] == 0) {
                if (visited[t.x][t.y + 1] == 0) {
                    visited[t.x][t.y + 1] = 1;
                    q.add(new Pos(t.x, t.y + 1));
                }
                int sum = Math.abs(A[t.x][t.y + 1] - A[t.x][t.y]);
                if (sum >= L && sum <= R) {
                    parent[t.x][t.y + 1] = parent[t.x][t.y];
                    if (pop.containsKey(parent[t.x][t.y])) {
                        int cnt = pop.get(parent[t.x][t.y]);
                        pop.put(parent[t.x][t.y], cnt + A[t.x][t.y + 1]);
                        int p = size.get(parent[t.x][t.y]);
                        size.put(parent[t.x][t.y], p + 1);
                    } else {
                        pop.put(parent[t.x][t.y], A[t.x][t.y + 1]);
                        size.put(parent[t.x][t.y], 1);
                    }
                    flag = true;
                }
            }
            if (t.y - 1 >= 0 && visited[t.x][t.y - 1] == 0) {
                if (visited[t.x][t.y - 1] == 0) {
                    visited[t.x][t.y - 1] = 1;
                    q.add(new Pos(t.x, t.y - 1));
                }
                int sum = Math.abs(A[t.x][t.y - 1] - A[t.x][t.y]);
                if (sum >= L && sum <= R) {
                    parent[t.x][t.y - 1] = parent[t.x][t.y];
                    if (pop.containsKey(parent[t.x][t.y])) {
                        int cnt = pop.get(parent[t.x][t.y]);
                        pop.put(parent[t.x][t.y], cnt + A[t.x][t.y - 1]);
                        int p = size.get(parent[t.x][t.y]);
                        size.put(parent[t.x][t.y], p + 1);
                    } else {
                        pop.put(parent[t.x][t.y], A[t.x][t.y - 1]);
                        size.put(parent[t.x][t.y], 1);
                    }
                    flag = true;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(parent[i][j].toString() + " ");
            }
            System.out.println();
        }
        if (flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (size.containsKey(parent[i][j])) {
                        int cnt = size.get(parent[i][j]);
                        int p = pop.get(parent[i][j]);
                        System.out.println(p + " " + cnt);
                        A[i][j] = p / cnt;
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
        return flag;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            A = new int[N][N];
            parent = new Pos[N][N];
            visited = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolean flag = true;
            int day = 0;
            while (flag) {
                init();
                q.add(new Pos(0, 0));
                flag = step();
                if (flag) {
                    day++;
                }
            }
            System.out.println(day);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
