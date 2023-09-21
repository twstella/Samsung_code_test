import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;

public class Jobs {
	static int N;
	static ArrayList<ArrayList<Integer>> grph;
	static int[] incnt,time,E;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			incnt = new int[N];
			time = new int[N];
			E = new int[N];
			grph = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<N;i++)
				grph.add(new ArrayList<Integer>());
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				time[i] = Integer.parseInt(st.nextToken());
				incnt[i] = Integer.parseInt(st.nextToken());
				for(int j=0;j<incnt[i];j++) {
					int t = Integer.parseInt(st.nextToken())-1;
					grph.get(t).add(i);
				}
			}
			int[] q = new int[N+1];
			int frnt=0,rr=0;
			int mm = -1;
			for(int i=0;i<N;i++) {
				if(incnt[i]==0) {
					q[rr++] = i;
					E[i] = time[i];
				}
			}
			while(frnt!=rr) {
				int e = q[frnt++];
				for(int t:grph.get(e)) {
					incnt[t]--;
					E[t]=Math.max(E[t], E[e]+time[t]);
					if(incnt[t]==0)
						q[rr++] = t;
				}
			}
			for(int i=0;i<N;i++)
				mm = Math.max(mm, E[i]);
			System.out.println(mm);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
