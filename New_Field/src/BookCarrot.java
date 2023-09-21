//9576
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
class BiMatch{
	int N,M;
	int[] A,B;
	boolean[] V;
	ArrayList<ArrayList<Integer>> G;
	BiMatch(int n,int m,ArrayList<ArrayList<Integer>> g){
		N =n;
		M = m;
		G = g;
		A = new int[N];
		B = new int[M];
	}
	boolean dfs(int a) {
		if(V[a]) return false;
		V[a] = true;
		for(int b:G.get(a)) {
			if(B[b]==-1||!V[B[b]]&&dfs(B[b])) {
				A[a] = b;
				B[b] = a;
				return true;
			}
		}
		return false;
	}
	int match() {
		Arrays.fill(A, -1);
		Arrays.fill(B, -1);
		int cnt=0;
		for(int i=0;i<N;i++) {
			if(A[i]==-1) {
				V =new boolean[N];
				if(dfs(i)) cnt++;
			}
		}
		return cnt;
	}
}
public class BookCarrot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int T = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int t=0;t<T;t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
				for(int i=0;i<n;i++)
					g.add(new ArrayList<Integer>());
				for(int i=0;i<n;i++) {
					st = new StringTokenizer(br.readLine());
					int a = Integer.parseInt(st.nextToken())-1;
					int b = Integer.parseInt(st.nextToken())-1;
					for(int j=a;j<=b;j++)
						g.get(i).add(j);
				}
				BiMatch bm = new BiMatch(n,m,g);
				sb.append(bm.match()+"\n");
			}
			System.out.println(sb.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
