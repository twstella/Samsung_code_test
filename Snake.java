
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
            e.printStackTrace();
        }
    }
}
