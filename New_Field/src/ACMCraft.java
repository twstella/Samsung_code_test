//1005
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
public class ACMCraft {
	static int T,N,M;
	static int[] incnt,time,E;
	static ArrayList<ArrayList<Integer>> grph;
	static int calc(int f) {
		int[] q=new int[N+1];
		int frnt=0,rr=0;
		for(int i=0;i<N;i++) {
			if(incnt[i]==0) {
				q[rr++] = i;
				E[i] = time[i];
			}
		}
		while(frnt!=rr) {
			int e = q[frnt++];
			if(e==f) return E[f];
			for(int t:grph.get(e)) {
				incnt[t]--;
				E[t] = Math.max(E[t], time[t]+E[e]);
				if(incnt[t]==0)
					q[rr++] = t;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			T = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for(int t=0;t<T;t++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				N = Integer.parseInt(st.nextToken());
				M = Integer.parseInt(st.nextToken());
				incnt=new int[N];
				time = new int[N];
				E = new int[N];
				grph = new ArrayList<ArrayList<Integer>>();
				for(int i=0;i<N;i++)
					grph.add(new ArrayList<Integer>());
				st = new StringTokenizer(br.readLine());
				for(int i=0;i<N;i++) {
					time[i] = Integer.parseInt(st.nextToken());
				}
				for(int i=0;i<M;i++) {
					st = new StringTokenizer(br.readLine());
					int n1 = Integer.parseInt(st.nextToken())-1;
					int n2 = Integer.parseInt(st.nextToken())-1;
					incnt[n2]++;
					grph.get(n1).add(n2);
				}
				int F = Integer.parseInt(br.readLine())-1;
				sb.append(calc(F)+"\n");
			}
			System.out.println(sb.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
