//1927
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.PriorityQueue;

public class MinHeap {
    
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            for(int i=0;i<n;i++){
                int x = Integer.parseInt(br.readLine());
                if(x==0){
                    if(pq.isEmpty()) sb.append(0+"\n");
                    else sb.append(pq.poll()+"\n");
                }
                else{
                    pq.add(x);
                }
            }
            System.out.print(sb.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
