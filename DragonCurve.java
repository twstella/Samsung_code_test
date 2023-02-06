//15685
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pos{
    int x,y;
    Pos(int rx,int cy){
        x = rx;
        y = cy;
    }
}
public class DragonCurve {
    static int N;
    static int[][] field = new int[101][101];
    static ArrayList<Pos> store ;
    static void Rotate(Pos anc,Pos s,Pos t){
        int tx,ty;
        tx = s.x - anc.x;
        ty = s.y - anc.y;
        t.x = -ty + anc.x;
        t.y = tx + anc.y;
    }
    static void spread(int g){
        for(int i=0;i<g;i++){
            int l = store.size();
            Pos anc = store.get(l-1);
            for(int j=l-2;j>=0;j--){
                Pos t = new Pos(0,0);
                Rotate(anc, store.get(j), t);
                store.add(t);
            }
        }
    }
    static void map(){
        for(int i=0;i<store.size();i++){
            int x = store.get(i).x;
            int y = store.get(i).y;
            if(x>=0&&x<=100&&y>=0&&y<=100){
                field[x][y] = 1;
            }
        }
    }
    static int findRec(){
        int cnt=0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if((field[i][j]+field[i][j+1]+field[i+1][j]+field[i+1][j+1])==4) cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int x,y,dir,g;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                dir = Integer.parseInt(st.nextToken());
                g = Integer.parseInt(st.nextToken());
                store = new ArrayList<Pos>();
                store.add(new Pos(x,y));
                if(dir == 0) store.add(new Pos(x+1,y));
                else if(dir ==1) store.add(new Pos(x,y-1));
                else if(dir == 2) store.add(new Pos(x-1,y));
                else if(dir==3) store.add(new Pos(x,y+1));
                spread(g);
                map();
            }
            System.out.println(findRec());

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
