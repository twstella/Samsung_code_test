//7662
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Collections;
public class DualPriorityQ {
    static PriorityQueue<Integer> max;
    static PriorityQueue<Integer> min;
    static HashMap<Integer,Integer> map;
    static int N;
    static void prntRslt(){
        int h=0,l=0;
        boolean flag = true;
        while(!max.isEmpty()){
            int e = max.poll();
            if(map.get(e)!=0){
                h=e;
                flag = false;
                break;
            }
        }
        while(!min.isEmpty()){
            int e = min.poll();
            if(map.get(e)!=0){
                l = e;
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println("EMPTY");
        }
        else{
            System.out.println(h+" "+l);
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int i=0;i<T;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                max = new PriorityQueue<>(Collections.reverseOrder());
                min = new PriorityQueue<>();
                map = new HashMap<>();
                for(int j=0;j<N;j++){
                    st = new StringTokenizer(br.readLine());
                    String cmd = st.nextToken();
                    int x = Integer.parseInt(st.nextToken());
                    if(cmd.equals("I")){
                        max.add(x);
                        min.add(x);
                        map.put(x,map.getOrDefault(x, 0)+1);
                    }
                    else if(cmd.equals("D")){
                        if(x==1){
                            while(!max.isEmpty()){
                                int e = max.poll();
                                int k = map.get(e);
                                if(k!=0){
                                    map.put(e,k-1);
                                    break;
                                }
                            }
                           
                        }
                        else if(x==-1){
                            while(!min.isEmpty()){
                                int e = min.poll();
                                int k = map.get(e);
                                if(k!=0){
                                    map.put(e,k-1);
                                    break;
                                }
                            }
                        }
                    }
                }
                prntRslt();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
