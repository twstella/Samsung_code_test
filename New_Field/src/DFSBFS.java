//1260
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class DFSBFS {
	static ArrayList<ArrayList<Integer>> G;
	static int M,N,S;
	static boolean[] V;
	static StringBuilder sb;
	static void dfs(int n) {
		sb.append((n+1)+" ");
		V[n] = true;
		for(int e:G.get(n))
			if(!V[e]) dfs(e);
	}
	static void bfs(int n) {
		int[] q = new int[1000];
		int frnt =0, rr=0;
		V[n] = true;
		q[rr++] = n;
		while(frnt!=rr) {
			n = q[frnt++];
			sb.append((n+1)+" ");
			for(int e:G.get(n)) {
				if(!V[e]) {
					V[e] = true;
					q[rr++] = e;
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken())-1;
			G = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<N;i++)
				G.add(new ArrayList<Integer>());
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken())-1;
				int n2 = Integer.parseInt(st.nextToken())-1;
				G.get(n1).add(n2);
				G.get(n2).add(n1);
			}
			for(int i=0;i<N;i++)
				Collections.sort(G.get(i));
			sb = new StringBuilder();
			V = new boolean[N];
			dfs(S);
			System.out.println(sb.toString());
			sb = new StringBuilder();
			V = new boolean[N];
			bfs(S);
			System.out.println(sb.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
