//22116
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
class QEntry implements Comparable<QEntry>{
    int node, cost;
    QEntry (int nn, int cc) {
    node = nn; cost = cc;
    }
    @Override
    public int compareTo(QEntry o) {
    return (this.cost - o.cost);
    }
}
public class ReturnHome {
    static int N;
    static int[][] map;
    static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    static boolean Valid(int r,int c){
        if(r<0||r>=N||c<0||c>=N) return false;
        return true;
    }
    static int dijk(){
        boolean[][] V = new boolean[N][N];
        PriorityQueue<QEntry> pq =
        new PriorityQueue<QEntry>();
        int[][] cost =new int[N][N];
        for (int i=0; i<N; i++)
        for (int j=0; j<N; j++)
        cost[i][j] = Integer.MAX_VALUE;
        cost[0][0] = 0;
        pq.add(new QEntry(0, cost[0][0]));
        while (pq.isEmpty() != true) {
            QEntry qe = pq.poll();
            int see = qe.node;
            int r = see / N, c = see %N;
            if ( V[r][c] == true) continue;
                V[r][c] = true;
                if (r==N-1 && c == N-1) return cost[r][c];
                for (int i=0; i<4; i++) {
                    int nr = r+dir[i][0], nc = c+dir[i][1];
                    if (Valid(nr, nc) == false) continue;
                    int delta = Math.max(cost[r][c], Math.abs(map[r][c] - map[nr][nc]));
                    cost[nr][nc] = Math.min(cost[nr][nc], delta);
                    pq.add(new QEntry(nr*N+nc, cost[nr][nc]));
                }   
            }
            return -1;
    } 
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            map=new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            System.out.println(dijk());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
