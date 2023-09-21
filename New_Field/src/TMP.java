import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TMP {
	static int N, M;
	static ArrayList<ArrayList<Integer>> G;    
	static int[] incnt;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		G = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<N; i++)  G.add(new ArrayList<Integer> ());
		incnt = new int[N];
		for (int i=0; i<M; i++) {
			   st = new StringTokenizer(br.readLine());
			   int t1 = Integer.parseInt(st.nextToken())-1;
			   int t2 = Integer.parseInt(st.nextToken())-1;
			   incnt[t2]++;	G.get(t1).add(t2);	// t1 -> t2 : t1에 링크추가, t2에 카운트 증가
			}

			int[] que = new int[N];	int rear=0, front =0;
			for (int i=0; i<N; i++)
			   if (incnt[i] ==0) que[rear++]=i;

			StringBuilder sb = new StringBuilder();
			while (front != rear) {
			   int e = que[front++];	sb.append((e+1) +" ");
			   for (int u: G.get(e)) {
				incnt[u]--;		// e -> u 에 대해 u의 카운 감소, 0이면 큐에 넣음
				if (incnt[u]==0) que[rear++]= u;
			   }
			}
			System.out.println(sb.toString());

	}

}
