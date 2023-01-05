
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
                parent[i][j] = new Pos(-1, -1);
                visited[i][j] = 0;
            }
        }
    }
    
    static boolean step() {
        boolean flag = false;
        while(!q.isEmpty()){
            Pos t = q.remove(0);
            System.out.println(t.toString());
            if(t.x+1<N){
                if(visited[t.x+1][t.y]==0){
                    q.add(new Pos(t.x+1,t.y));
                    visited[t.x+1][t.y] =1 ;
                }
               
                int sum = Math.abs(A[t.x][t.y]-A[t.x+1][t.y]);
                if(L<=sum&&sum<=R){
                    flag = true;
                    
                }
            }
            if(t.x-1>=0){
                if(visited[t.x-1][t.y]==0){
                    q.add(new Pos(t.x-1,t.y));
                    visited[t.x-1][t.y] =1;
                }
                
                int sum = Math.abs(A[t.x][t.y] - A[t.x-1][t.y]);
                if(L<=sum && sum<=R){
                    flag = true;
                    
                }
            }
            if(t.y+1<N){
                if(visited[t.x][t.y+1]==0){
                    q.add(new Pos(t.x,t.y+1));
                    visited[t.x][t.y+1] =1;
                }
                
                int sum = Math.abs(A[t.x][t.y+1]-A[t.x][t.y]);
                if(L<=sum && sum<=R){
                    flag = true;
                    
                }
            }
            if(t.y-1>=0){
                if(visited[t.x][t.y-1]==0){
                    q.add(new Pos(t.x,t.y-1));
                    visited[t.x][t.y-1] =1;
                }
                
                int sum = Math.abs(A[t.x][t.y-1] - A[t.x][t.y]);
                if(L<=sum&&sum<=R){
                    flag = true;
                   
                }
            }
        }
        HashMap<Pos,Integer> size = new HashMap<Pos,Integer>();
        HashMap<Pos,Integer> cnt = new HashMap<Pos,Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(parent[i][j].toString() + " ");
                Pos t = parent[i][j];
                if(size.containsKey(t)){
                    int s = size.get(t);
                    int c = cnt.get(t);
                    size.put(t,s+A[i][j]);
                    cnt.put(t,c+1);
                }
                else{
                    size.put(t,A[i][j]);
                    cnt.put(t,1);
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Pos p = parent[i][j];
                int s = size.get(p);
                int c = cnt.get(p);
                A[i][j] = s/c;
                System.out.print(A[i][j]+" ");
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
            init();
            visited[0][0]=1;
            q.add(new Pos(0, 0));
            step();
            // boolean flag = true;
            // int day = 0;
            // while(flag){
            //     init();
            //     visited[0][0] =1;
            //     q.add(new Pos(0, 0));
            //     flag = step();
            //     if(flag) day++;
            // }
            // System.out.println(day);

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
