//1967
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class TreeDiameter {
	static ArrayList<HashMap<Integer,Integer>> grph;
	static int N;
	static int[] D,q;
	static void bfs(int s) {
		boolean[] V = new boolean[N];
		V[s] = true;
		D[s] = 0;
		int frnt =0,rr =0;
		q[rr++] = s;
		while(frnt!=rr) {
			int n = q[frnt++];
			for(int e:grph.get(n).keySet()) {
				if(V[e]) continue;
				D[e] = D[n]+ grph.get(n).get(e);
				V[e] = true;
				q[rr++] = e;
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			grph = new ArrayList<HashMap<Integer,Integer>>();
			for(int i=0;i<N;i++) {
				grph.add(new HashMap<Integer,Integer>());
			}
			for(int i=0;i<N-1;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken())-1;
				int n2 = Integer.parseInt(st.nextToken())-1;
				int w = Integer.parseInt(st.nextToken());
				grph.get(n1).put(n2,w);
				grph.get(n2).put(n1, w);
			}
			q = new int[N+3];
			D = new int[N];
			bfs(0);
			long mm = D[0];
			int mi = 0;
			for(int i=1;i<N;i++) {
				if(mm<D[i]) {
					mi = i;
					mm = D[i];
				}
			}
			D = new int[N];
			bfs(mi);
			for(int i=1;i<N;i++) {
				mm = Math.max(mm, D[i]);
			}
			System.out.println(mm);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
