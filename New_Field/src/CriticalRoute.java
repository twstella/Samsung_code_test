//1948
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Link{
	int n1,n2,cost;
	Link(int n,int m,int c){
		n1=n;
		n2 = m;
		cost = c;
	}
}
public class CriticalRoute {
	static Link[] L;
	static ArrayList<HashMap<Integer,Integer>> g1,g2;
	static int[] E1,E2;
	static int N,M,S,D;
	static int[] incnt1,incnt2;
	static void topo(ArrayList<HashMap<Integer,Integer>> g,int[] incnt,int st,int[] E) {
		int[] que = new int[N+1];int front=0, rear = 0;
		   que[rear++]=st; E[st] = 0;

		   while (front != rear) {
		   	int e = que[front++];
		   	for (int t : g.get(e).keySet()) {
			   int w = E[e] + g.get(e).get((Integer) t);
			   E[t] = Math.max(E[t], w);
			   incnt[t] = incnt[t]-1;
			   if (incnt[t] == 0)
			   	que[rear++]=t;
		  	}
		   }

	}
	static void CPath() {
		topo(g1,incnt1,S,E1);
		topo(g2,incnt2,D,E2);
		int dist = E1[N-1];
		int cnt = 0,ll=0;
		for(int i=0;i<M;i++) {
			int n1 = L[i].n1;
			int n2 = L[i].n2;
			ll = E1[n1]+L[i].cost + E2[n2];
			if(ll==dist) {
				cnt++;
			}
		}
		System.out.println(dist+"\n"+cnt);
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		   N = Integer.parseInt(br.readLine());  M = Integer.parseInt(br.readLine());
		   g1 = new ArrayList<HashMap<Integer, Integer>> ();
		   g2 = new ArrayList<HashMap<Integer, Integer>> ();
		   for (int i=0; i<N; i++) {
			g1.add(new HashMap<Integer, Integer> ());  g2.add(new HashMap<Integer, Integer> ());
		   }
		   incnt1 = new int[N]; incnt2 = new int[N]; E1 = new int[N]; E2 = new int[N]; L = new Link[M];
		   for (int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken()) -1, n2 = Integer.parseInt(st.nextToken()) -1;
			int cc = Integer.parseInt(st.nextToken());
			g1.get(n1).put(n2, cc); g2.get(n2).put(n1, cc); incnt1[n2]++; incnt2[n1]++;
			L[i] = new Link(n1, n2, cc);
		   }
		   StringTokenizer st = new StringTokenizer(br.readLine());
		   S = Integer.parseInt(st.nextToken()) -1; D = Integer.parseInt(st.nextToken()) -1;
		   CPath();

	}

}
