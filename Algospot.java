//1261
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Posi{
    int r,c;
    Posi(int x,int y){
        r = x;
        c =y;
    }
}
class Point implements Comparable<Point>{
    Posi pt;
    int w;
    Point(Posi a,int b){
        pt = a;
        w = b;
    }
    public int compareTo(Point o){
        return this.w-o.w;
    }
}
public class Algospot {
    static int N,M;
    static int[][] A;
    static int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean valid(int r,int c){
        if(r<0||r>=N||c<0||c>=M) return false;
        return true;
    }
    static int dijk(){
        int[][] V = new int[N][M];
        int [][] dist =new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<Point> q = new PriorityQueue<Point>();
        q.add(new Point(new Posi(0,0),0));
        dist[0][0]= A[0][0];
        while(!q.isEmpty()){
            Point e = q.poll();
            Posi p = e.pt;
            if(V[p.r][p.c]==1) continue;
            V[p.r][p.c]=1;
            //System.out.println("("+p.r+","+p.c+")");
            if(p.r==N-1&&p.c==M-1) return dist[p.r][p.c];
            for(int i=0;i<4;i++){
                int nr=p.r+dir[i][0];
                int nc = p.c+dir[i][1];
                if(valid(nr, nc)){
                    if(V[nr][nc]==1) continue;
                    if(dist[nr][nc]>dist[p.r][p.c]+A[nr][nc]){
                        dist[nr][nc] = dist[p.r][p.c] + A[nr][nc];
                        q.add(new Point(new Posi(nr,nc),dist[nr][nc]));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            M =Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            A = new int[N][M];
            for(int i=0;i<N;i++){
                String s = br.readLine();
                for(int j=0;j<M;j++){
                    A[i][j] = Integer.parseInt(""+s.charAt(j));
                }
            }
            System.out.println(dijk());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
