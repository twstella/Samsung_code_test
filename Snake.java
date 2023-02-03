<<<<<<< HEAD
//3190
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
class Pos{
    int x,y;
    public Pos(int r,int c){
        x=r;
        y=c;
    }
}
public class Snake {
    static ArrayList<Pos> snake = new ArrayList<Pos>();
    static ArrayList<Pos> apple = new ArrayList<Pos>();
    static int N,A,M;
    static int dir=0;
    static int[][] move ={{0,1},{1,0},{0,-1},{-1,0}};
    static boolean check(ArrayList<Pos> t,int r,int c){
        for(int i=0;i<t.size();i++){
            if (t.get(i).x==r && t.get(i).y==c){
                t.remove(i);
                return false;
            }
        }
        return true;
    }
    static boolean checkWall(int r,int c){
        if(r<0||r>=N||c<0||c>=N) return false;
        return true;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Pos> turn = new ArrayList<Pos>();
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            for(int i=0;i<A;i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken())-1;
                apple.add(new Pos(r,c));
            }
            snake.add(new Pos(0,0));
            st = new StringTokenizer(br.readLine());
            M =Integer.parseInt(st.nextToken());
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                char c = st.nextToken().charAt(0);
                if (c=='L') turn.add(new Pos(x,0));
                else if(c=='D') turn.add(new Pos(x,1));
            }
            br.close();
            int t = 0;
            int idx = 0;
            while(true){
                int tr = snake.get(0).x + move[dir][0];
                int tc = snake.get(0).y + move[dir][1];
                Pos nw = new Pos(tr,tc);
                t++;
                if (checkWall(tr, tc)==false) break;
                if (check(snake,tr,tc)==false) break;
                if (check(apple,tr,tc)==false){ 
                    snake.add(0,nw);
                }
                else{
                    snake.add(0,nw);
                    snake.remove(snake.size()-1);
                }
                if((idx<turn.size())&&(t==turn.get(idx).x)){
                    if(turn.get(idx).y == 0)  dir = (dir+3)%4;
                    else if (turn.get(idx).y == 1) dir = (dir+1)%4;
                    idx++;
                }
            }
            System.out.println(t);
        }catch(IOException e){
=======

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
>>>>>>> bff0718f6dbd10325771c9928344a7733b70355d
            e.printStackTrace();
        }
    }
}
