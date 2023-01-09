
//16234
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

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
    static int[][] visited;
    static ArrayList<Pos> q;
    static boolean valid(int x,int y){
        if(x<0||x>=N||y<0||y>=N) return false;
        return true;
    }
    static boolean check(int ax,int ay,int bx,int by){
        int delta = Math.abs(A[ax][ay]-A[bx][by]);
        if(L<=delta&&delta<=R) return true;
        return false;
    }
    static boolean step(int x,int y){
        ArrayList<Pos> grp = new ArrayList<Pos>();
        q = new ArrayList<Pos>();
        q.add(new Pos(x,y));
        while(!q.isEmpty()){
            Pos e = q.remove(0);
            grp.add(e);
            if(valid(e.x+1, e.y)&&visited[e.x+1][e.y]==0&&check(e.x, e.y, e.x+1, e.y)){
                visited[e.x+1][e.y]=1;
                q.add(new Pos(e.x+1,e.y));
            } 
            if(valid(e.x-1,e.y)&&visited[e.x-1][e.y]==0 && check(e.x,e.y,e.x-1,e.y)){
                visited[e.x-1][e.y]=1;
                q.add(new Pos(e.x-1,e.y));
            }
            if(valid(e.x,e.y+1)&&visited[e.x][e.y+1]==0 && check(e.x, e.y, e.x, e.y+1)){
                visited[e.x][e.y+1]=1;
                q.add(new Pos(e.x,e.y+1));
            }
            if(valid(e.x,e.y-1)&&visited[e.x][e.y-1]==0&&check(e.x,e.y,e.x,e.y-1)){
                visited[e.x][e.y-1]=1;
                q.add(new Pos(e.x,e.y-1));
            }
        }
        if (grp.size()==1) return false;
        int sum = 0;
        for(int i=0;i<grp.size();i++){
            Pos p = grp.get(i);
            sum+=A[p.x][p.y];
        }
        for(Pos p:grp){
            A[p.x][p.y] = sum/grp.size();
        }
        return true;
    }
    static boolean migrate(){
        boolean flag=false;
        visited = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(visited[i][j] == 1) continue;
                visited[i][j] = 1;
                flag = step(i,j) || flag;
            }
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
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int day=0;
            boolean flag = true;
            while(flag){
                flag = migrate();
                if(flag) day++;
            }
            System.out.println(day);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
