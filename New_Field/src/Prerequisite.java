//14567
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Prerequisite {
	static int[] incnt,seq;
	static ArrayList<ArrayList<Integer>> grph;
	static int N,M;
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grph = new ArrayList<ArrayList<Integer>>();
			incnt = new int[N];
			seq = new int[N];
			for(int i=0;i<N;i++)
				grph.add(new ArrayList<Integer>());
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken())-1;
				int n2 = Integer.parseInt(st.nextToken())-1;
				incnt[n2]++;
				grph.get(n1).add(n2);
			}
			int[] q = new int[N+1];
			int frnt=0,rr=0;
			for(int i=0;i<N;i++) {
				if(incnt[i]==0) {
					seq[i]=1;
					q[rr++] = i;
				}
			}
			while(frnt!=rr) {
				int e = q[frnt++];
				for(int t:grph.get(e)) {
					incnt[t]--;
					seq[t] = Math.max(seq[t], seq[e]+1);
					if(incnt[t]==0)
						q[rr++] = t;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++)
				sb.append(seq[i]+" ");
			System.out.println(sb.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
