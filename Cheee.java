//2638
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
class Pos{
    int x,y;
    Pos(int a,int b){
        x=a;
        y=b;
    }
}
public class Cheee {
    static int N,M;
    static int[][] map;
    static int lft;
    static ArrayList<Pos> crust;
    static int[][] visited;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean isVaild(int x,int y){
        if(x>=0&&x<N&&y>=0&&y<M) return true;
        return false;
    }
    static void bfs(Pos p){
        int frnt=0,bck=0;
        Pos[] q = new Pos[N*M+1];
        q[bck++]=p;
        visited = new int[N][M];
        visited[p.x][p.y]=1;
        ArrayList<Pos> tmp = new ArrayList<Pos>();
        while(bck>frnt){
            Pos e = q[frnt++];
            //System.out.println("("+e.x+","+e.y+")");
            for(int i=0;i<4;i++){
                int nx=e.x+dir[i][0];
                int ny = e.y+dir[i][1];
                if(isVaild(nx, ny)&&visited[nx][ny]==0){
                    if(map[nx][ny]==0){
                        visited[nx][ny]=1;
                        q[bck++] = new Pos(nx,ny);
                    }
                    else{
                        visited[nx][ny]=2;
                        tmp.add(new Pos(nx,ny));
                    }
                }
            }
        }
        for(Pos o:tmp){
            visited[o.x][o.y]=0;
            int c =0;
            for(int i=0;i<4;i++){
                int nx=o.x+dir[i][0];
                int ny = o.y+dir[i][1];
                if(isVaild(nx, ny)&&map[nx][ny]==0&&visited[nx][ny]==1) c++;
            }
            if(c>=2){
                crust.add(new Pos(o.x,o.y));
                lft--;
                map[o.x][o.y]=0;
            }
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1) lft++;
                }
            }
            crust = new ArrayList<Pos>();
            Pos start=new Pos(0,0);
            int cnt=0;
            while(lft>0){
                bfs(start);
                // for(Pos p:crust){
                //     System.out.println(">("+p.x+","+p.y+")");
                // }
                cnt++;
                // for(int i=0;i<N;i++){
                //     for(int j=0;j<M;j++){
                //         System.out.print(map[i][j]+" ");
                //     }
                //     System.out.println();
                // }
                // System.out.println(lft);
                crust.clear();
            }
            System.out.println(cnt);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
