//1258
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ProbDist {
	static ArrayList<ArrayList<Integer>> G;
	static int[][] capa, pay,allo;
	static int[] from,cost;
	static int N,M,V,S,D;
	static final int Inf = 1000000000;
	static void spfa(int fr) {
		int[] cycle = new int[V];
		boolean[] inQ = new boolean[V];
		ArrayList<Integer> que = new ArrayList<Integer>();
		Arrays.fill(cost, Inf);
		Arrays.fill(from,-1);
		int frnt = 0;
		que.add(fr);
		cost[fr] = 0;
		cycle[fr]++;
		inQ[fr] = true;
		while(que.size()-frnt>0) {
			int see = que.get(frnt++);
			inQ[see] =false;
			for(int nn:G.get(see)) {
				if(capa[see][nn]-allo[see][nn]<=0) {
					continue;
				}
				int cc = pay[see][nn];
				if(cost[nn]>cost[see]+cc) {
					cost[nn] = cost[see]+cc;
					from[nn] = see;
					if(inQ[nn]==false) {
						cycle[nn]++;
						if(cycle[nn]>=V)
							return;
						que.add(nn);
						inQ[nn] = true;
					}
				}
			}
		}
	}
	static void AddEdge(int fr,int to,int val) {
		G.get(fr).add(to);
		G.get(to).add(fr);
		capa[fr][to] = val;
	}
	static int GetFlow() {
		int res = 0;
		while(true) {
			spfa(S);
			if(from[D]==-1) break;
			int n = D;
			int f = from[D];
			int flow = 100000000;
			while(n!=S) {
				flow = Math.min(flow, capa[f][n]-allo[f][n]);
				n=f;
				f = from[n];
			}
			n = D;
			f = from[D];
			while(n!=S) {
				allo[f][n] += flow;
				allo[n][f] -= flow;
				res += flow * pay[f][n];
				n = f;
				f = from[n];
			}
		}
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			M = N;
			V = N+M+2;
			S = N+M;
			D = V-1;
			capa = new int[V][V];
			pay = new int[V][V];
			allo = new int[V][V];
			G = new ArrayList<ArrayList<Integer>>();
			from = new int[V];
			cost = new int[V];
			for(int i=0;i<V;i++) G.add(new ArrayList<Integer>());
			
			
			for(int i=0;i<N;i++) AddEdge(S,i,1);
			for(int i=0;i<M;i++) AddEdge(i+N,D,1);
			
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<M;j++) {
					int tt = Integer.parseInt(st.nextToken());
					AddEdge(i,N+j,1);
					pay[i][N+j] = tt;
					pay[N+j][i] = -tt;
				}
			}
			System.out.println(GetFlow());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
