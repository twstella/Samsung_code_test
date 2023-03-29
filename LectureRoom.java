//11000
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;
public class LectureRoom {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] inpt = new int[N][2];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                inpt[i][0] = Integer.parseInt(st.nextToken());
                inpt[i][1] = Integer.parseInt(st.nextToken());
            }
            Comparator<int[]> cmp = new Comparator<int[]>() {
                public int compare(int[] o1,int[] o2){
                    return o1[0]-o2[0];
                }
            };
            Arrays.sort(inpt,cmp);
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int cnt = -1;
            for(int i=0;i<N;i++){
                if(pq.isEmpty()){
                    pq.add(inpt[i][1]);
                }
                else{
                    while(!pq.isEmpty()){
                        int t = pq.peek();
                        if(t<=inpt[i][0]){
                            pq.poll();
                        }
                        else break;
                    }
                    pq.add(inpt[i][1]);
                }
                cnt = Math.max(cnt, pq.size());
            }
            System.out.println(cnt);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
