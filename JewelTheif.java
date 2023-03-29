//1202
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Comparator;

public class JewelTheif {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[][] jewel = new int[N][2];
            int[] bag = new int[K];
            for(int i=0;i<N;i++){
                st= new StringTokenizer(br.readLine());
                jewel[i][0] = Integer.parseInt(st.nextToken());
                jewel[i][1] = Integer.parseInt(st.nextToken());
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                bag[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(jewel,new Comparator<int[]>() {
                public int compare(int[] o1,int[] o2){
                    return o1[0]-o2[0];
                }
            });
            Arrays.sort(bag);//무게가 작은 순서
            long sum=0;
            int k=0;
            PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
            for(int i=0;i<K;i++){
                while(k<N&&bag[i]>=jewel[k][0]){
                    pq.add(jewel[k++][1]);
                }
                if(pq.isEmpty()) continue;
                sum+=pq.poll();
            }
            System.out.println(sum);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
