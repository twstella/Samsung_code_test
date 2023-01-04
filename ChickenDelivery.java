
//15686
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pos {
    int x, y;

    Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

public class ChickenDelivery {
    static int N;
    static int M;
    static ArrayList<Pos> chicken = new ArrayList<Pos>();
    static ArrayList<Pos> home = new ArrayList<Pos>();
    static ArrayList<String> store = new ArrayList<String>();
    static int[][] map;

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

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        home.add(new Pos(i, j));
                    } 
                    else if (map[i][j] == 2) {
                        chicken.add(new Pos(i, j));
                    }
                }
            }
            comp(chicken.size(), M, "");
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < store.size(); i++) {
                int[][] tmp = new int[N][N];
                String s = store.get(i);
                for (int j = 0; j < chicken.size(); j++) {
                    if (s.charAt(j) == '1') {
                        Pos t = chicken.get(j);
                        tmp[t.x][t.y] = 1;
                    }
                }
                int cnt = 0;

                for (int j = 0; j < home.size(); j++) {
                    Pos h = home.get(j);
                    int Mn = Integer.MAX_VALUE;
                    for (int k = 0; k < chicken.size(); k++) {
                        Pos t = chicken.get(k);
                        if (tmp[t.x][t.y] == 1){
                            int m = Math.abs(t.x - h.x) + Math.abs(t.y - h.y);
                            if(Mn>m) Mn = m;
                        }
                    }
                    cnt+=Mn;
                }
                if (min > cnt)
                    min = cnt;
            }
            System.out.println(min);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
