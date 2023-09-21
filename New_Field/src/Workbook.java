//1766
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Workbook {
	static int N,M;
	static int[] incnt;
	static ArrayList<ArrayList<Integer>> grph;
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			grph = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<N;i++) {
				grph.add(new ArrayList<Integer>());
			}
			incnt = new int[N];
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int n1 = Integer.parseInt(st.nextToken())-1;
				int n2 = Integer.parseInt(st.nextToken())-1;
				incnt[n2]++;
				grph.get(n1).add(n2);
			}
			pq = new PriorityQueue<Integer>();
			for(int i=0;i<N;i++) {
				if(incnt[i]==0)
					pq.add(i);
			}
			StringBuilder sb = new StringBuilder();
			while(!pq.isEmpty()) {
				int e = pq.poll();
				sb.append((e+1)+" ");
				for(int u:grph.get(e)) {
					incnt[u]--;
					if(incnt[u]==0)
						pq.add(u);
				}
			}
			System.out.println(sb.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
