//16064
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
public class SkiRoute {
	static ArrayList<HashMap<Integer,Integer>> grph;
	static int[] incnt,E;
	static int N,M,C;
	static int togo() {
		int frnt=0,rr=0;
		int[] q = new int[N+5];
		for(int i=0;i<N;i++) {
			if(incnt[i]==0)
				q[rr++] = i;
		}
		while(frnt!=rr) {
			int e = q[frnt++];
			for(int t:grph.get(e).keySet()) {
				int w = E[e]+grph.get(e).get((Integer)t);
				E[t] = Math.max(E[t], w);
				incnt[t] = incnt[t]-1;
				if(incnt[t]==0)
					q[rr++] = t;
			}
		}
		int mm = -1;
		for(int i=0;i<N;i++) {
			mm = Math.max(mm, E[i]);
		}
		return mm;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grph = new ArrayList<HashMap<Integer,Integer>>();
			for(int i=0;i<N;i++)
				grph.add(new HashMap<Integer,Integer>());
			incnt = new int[N];
			E = new int[N];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken())-1;
				int n2 = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken());
				if(!grph.get(n1).containsKey((Integer)n2)){
					grph.get(n1).put(n2,c);
					incnt[n2]++;
				}
				else {
					int mm = Math.max(c, grph.get(n1).get(n2));
					grph.get(n1).put(n2, mm);
				}
			}
			System.out.println(togo());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
