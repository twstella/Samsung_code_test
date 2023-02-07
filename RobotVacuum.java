//14503
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pos{
    int x;
    int y;
    Pos(int r,int c){
        x= r;
        y = c;
    }
}
public class RobotVacuum {
    static int N,M;
    static int[][] visited;
    static int[][] map;
    static int[][] move = {{-1,0},{0,1},{1,0},{0,-1}};
    static int R,C;
    static boolean check(Pos p){
        if(p.x<0||p.x>=N||p.y<0||p.y>=M) return false;
        return true;
    }
    static void turn_left(int d){
        d = (d+3)%4;
    }
    static int calc_sp(){
        int cnt=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(visited[i][j]==1&&map[i][j]!=1) cnt++;
            }
        }
        return cnt;
    }
    static void dfs(Pos m,int d){
        if(check(m)==false||map[m.x][m.y]==1) return;
        System.out.println("("+m.x+","+m.y+")");
       boolean chk = false;
       for(int i=3;i>=0;i--){
           Pos p = new Pos(m.x+move[(d+i)%4][0],m.y+move[(d+i)%4][1]);
           if (check(p)&& map[p.x][p.y]!=1&&visited[p.x][p.y]!=1){
               visited[p.x][p.y] =1;
               dfs(p,(d+i)%4);
               chk = true;
           }
       }
       if(chk == false){
           Pos p = new Pos(m.x+move[(d+2)%4][0],m.y+move[(d+2)%4][1]);
           Pos n = new Pos(p.x-move[d][0],p.y-move[d][1]);
           if(check(p)&&map[p.x][p.y]!=1&&check(n)&&map[n.x][n.y]!=1 &&visited[n.x][n.y]!=1){
               visited[n.x][n.y]=1;
               System.out.println("backward");
               dfs(n,d);
           }
           else return;
       }
        
        
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            visited = new int[N][M];
            map = new int[N][M];
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            Pos p = new Pos(R,C);
            visited[R][C] =1;
            dfs(p,d);
            System.out.println(calc_sp());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
