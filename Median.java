//1655
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
public class Median {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> max = new PriorityQueue<>((x,y)->{
                return y-x;
            });
            PriorityQueue<Integer> min = new PriorityQueue<>();
            boolean flag = false;
            max.add(Integer.parseInt(br.readLine()));
            StringBuilder sb = new StringBuilder();
            sb.append(max.peek()+"\n");
            for(int i=0;i<N-1;i++){
                int x = Integer.parseInt(br.readLine());
                if(flag==false){
                    int l = max.peek();
                    if(x>=l) min.add(x);
                    else{
                        int t = max.poll();
                        min.add(t);
                        max.add(x);
                    }
                }
                else{
                    int r = min.peek();
                    if(x<=r) max.add(x);
                    else{
                        int t = min.poll();
                        max.add(t);
                        min.add(x);
                    }
                }
                flag = flag ^ true;
                sb.append(max.peek()+"\n");
            }
            System.out.print(sb.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
