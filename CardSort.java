//1715
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;


public class CardSort {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int sum =0;
            for(int i=0;i<N;i++){
                int x = Integer.parseInt(br.readLine());
                pq.add(x);
            }
            while(!pq.isEmpty()){
                int e1 = pq.poll();
                if(pq.isEmpty()){
                    break;
                }
                int e2 = pq.poll();
                sum+=e1+e2;
                pq.add(e1+e2);
            }
            System.out.println(sum);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
