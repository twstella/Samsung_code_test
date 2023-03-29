//11286
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
public class LambdaPQ {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->{
                int res = Math.abs(x)-Math.abs(y);
                if(res == 0) return x-y;
                else return res;
            });
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++){
                int x = Integer.parseInt(br.readLine());
                if(x==0){
                    if(pq.isEmpty()){
                        sb.append("0\n");
                        continue;
                    }
                    int t = pq.poll();
                    sb.append(t+"\n");
                }
                else{
                    pq.add(x);
                }
            }
            System.out.print(sb);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
