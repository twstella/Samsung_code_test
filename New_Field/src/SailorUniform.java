//18138
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
/*
class BiMatch{
	int N,M;
	int[] A,B;
	boolean[] V;
	ArrayList<ArrayList<Integer>> G;
	BiMatch(int n,int m,ArrayList<ArrayList<Integer>> g){
		N = n;
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
		int cnt = 0;
		for(int i=0;i<N;i++) {
			if(A[i]==-1) {
				V = new boolean[N];
				if(dfs(i))
					cnt++;
			}
		}
		return cnt;
	}
}
*/
public class SailorUniform {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] S = new int[n];
			int[] C = new int[m];
			for(int i=0;i<n;i++)
				S[i] = Integer.parseInt(br.readLine());
			for(int i=0;i<m;i++)
				C[i] = Integer.parseInt(br.readLine());
			ArrayList<ArrayList<Integer>> G = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<n;i++)
				G.add(new ArrayList<Integer>());
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(S[i]<=C[j]*2&&4*C[j]<=3*S[i])
						G.get(i).add(j);
					else if(S[i]<=C[j]&&4*C[j]<=5*S[i])
						G.get(i).add(j);
				}
			}
			BiMatch bm = new BiMatch(n,m,G);
			System.out.println(bm.match());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
