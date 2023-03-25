import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
class Coord{
	int r,c;
	Coord(int r,int c){
		this.r=r;this.c=c;
	}
}
public class Tomato {
	static int M,N;
	static int[][] box;
	static int[][] visited;
	static ArrayList<Coord> q=new ArrayList<Coord>();
	static int cnt,day,emp;
	static int front,rear;
	static void find() {
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(box[i][j]==1&&visited[i][j]==0) {
					q.add(new Coord(i,j));
					visited[i][j]=1;
					cnt++;
				}
				else if(box[i][j]==-1) emp++;
		rear=cnt;
	}
	static void time() {
		
		for(int i=front;i<rear;i++) {
			Coord t=q.get(i);
			if(t.r>0&&box[t.r-1][t.c]!=-1&&visited[t.r-1][t.c]==0) {
				q.add(new Coord(t.r-1,t.c));
				visited[t.r-1][t.c]=1;
				cnt++;			
			}
			if(t.c>0&&box[t.r][t.c-1]!=-1&&visited[t.r][t.c-1]==0) {
				q.add(new Coord(t.r,t.c-1));
				visited[t.r][t.c-1]=1;
				cnt++;			
			}
			if(t.r<N-1&&box[t.r+1][t.c]!=-1&&visited[t.r+1][t.c]==0) {
				q.add(new Coord(t.r+1,t.c));
				visited[t.r+1][t.c]=1;
				cnt++;				
			}
			if(t.c<M-1&&box[t.r][t.c+1]!=-1&&visited[t.r][t.c+1]==0) {
				q.add(new Coord(t.r,t.c+1));
				visited[t.r][t.c+1]=1;
				cnt++;			
			}
		}
		front=rear;
		rear=cnt;
		day++;
	}
	public static void main(String[] args) {
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer s=new StringTokenizer(br.readLine());
			M=Integer.parseInt(s.nextToken());
			N=Integer.parseInt(s.nextToken());
			box=new int[N][M];
			visited=new int[N][M];
			for(int i=0;i<N;i++) {
				s=new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++)
					box[i][j]=Integer.parseInt(s.nextToken());
			}
			cnt=0;day=0;
			front=0; rear=0;
			find();
			while(front<rear&&cnt<N*M-emp) {
				time();
			}
			if(cnt>=N*M-emp)
				System.out.println(day);
			else System.out.println(-1);
		}
		catch(IOException e) {}
	}

}
