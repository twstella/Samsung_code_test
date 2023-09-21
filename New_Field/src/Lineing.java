//2252
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
public class Lineing {
	static int N,M;
	static ArrayList<ArrayList<Integer>> grph;
	static int[] incnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			incnt = new int[N];
			grph = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<N;i++)
				grph.add(new ArrayList<Integer>());
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken())-1;
				int n2 = Integer.parseInt(st.nextToken())-1;
				incnt[n2]++;
				grph.get(n1).add(n2);
			}
			int[] q = new int[N];
			int frnt=0,rr=0;
			for(int i=0;i<N;i++) {
				if(incnt[i]==0) q[rr++] = i;
			}
			StringBuilder sb = new StringBuilder();
			while(frnt!=rr) {
				int e = q[frnt++];
				sb.append((e+1)+" ");
				for(int u:grph.get(e)) {
					incnt[u]--;
					if(incnt[u]==0)
						q[rr++] = u;
				}
			}
			System.out.println(sb.toString());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
