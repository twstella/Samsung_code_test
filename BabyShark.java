//16236
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
class Pos{
    int x;
    int y;
    Pos(int r,int c){
        x = r;
        y = c;
    }
}

public class BabyShark {
    static int N;
    static int[][] map;
    static int[][] vi;
    static int shark = 2;
    static int l = 2;
    static int sr,sc;
    static int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
    static boolean valid(int r,int c){
        if(r<0||r>=N||c<0||c>=N) return false;
        return true;
    }
    static int getDist(){
        Pos pt;
        int r =0;
        int c = 0;
        int cnt =0;
        ArrayList<Pos> q = new ArrayList<Pos>();
        vi = new int[N][N];
        q.add(new Pos(sr, sc));
        vi[sr][sc] = 1;
        while(q.isEmpty()==false){
            int len = q.size();
            Collections.sort(q,new Comparator<Pos>() {
                public int compare(Pos p1,Pos p2){
                    int rst = p1.x-p2.x;
                    if(rst == 0) rst = p1.y - p2.y;
                    return rst;
                }
            });
            for(int i =0;i<len;i++){
                pt = q.remove(0);
                r = pt.x;
                c = pt.y;
                if(map[r][c] >0 && map[r][c]<shark){
                    map[r][c] = 0;
                    map[sr][sc] = 0;
                    sr = r;
                    sc = c;
                    l --;
                    if(l==0){
                        shark++;
                        l = shark;
                    }
                    return cnt;
                }
                for(int j=0;j<4;j++){
                    int nr = r+dir[j][0] ;
                    int nc = c+dir[j][1];
                    if(valid(nr, nc)&&vi[nr][nc]==0&&map[nr][nc]<=shark){
                        q.add(new Pos(nr,nc));
                        vi[nr][nc] = 1;
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 9 ){
                        sr = i;
                        sc= j;
                    }
                }
            }
            int sum =0 ;
            int t =0;
            do{
                t = getDist();
                //System.out.println(t);
                sum+= t;
            }while(t!=0);
            System.out.println(sum);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
