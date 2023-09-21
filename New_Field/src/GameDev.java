//1516
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
public class GameDev {
	static int N;
	static int[] incnt,time,E;
	static ArrayList<ArrayList<Integer>> grph;
	static void togo() {
		   int[] que = new int[N+1];  int front=0, rear = 0;

		   for (int i=0; i<N; i++)
			if (incnt[i] == 0) {
			   que[rear++] =i;
			   E[i] = time[i];
			}

		   while (front != rear) {
			int e = que[front++];
			for (int t : grph.get(e)) {
			   incnt[t]--;
			   E[t] = Math.max(E[t], E[e]+time[t]);
			   if (incnt[t] == 0)  que[rear++]=t;
		 	}
		   }
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(br.readLine());
			grph =  new ArrayList<ArrayList<Integer>>();
			incnt = new int[N];
			E = new int[N];
			time = new int[N];
			for(int i=0;i<N;i++)
				grph.add(new ArrayList<Integer>());
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				time[i] = Integer.parseInt(st.nextToken());
				while(true) {
					int t = Integer.parseInt(st.nextToken());
					if(t==-1) break;
					t--;
					incnt[i]++;
					grph.get(t).add(i);
				}
			}
			togo();
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<N;i++) {
				sb.append(E[i]+"\n");
			}
			System.out.println(sb.toString());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
