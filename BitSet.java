//11723
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BitSet {
    
    public static void main(String[] args){
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int set = 0;
            int[] store = new int[20];
            store[0]=1;
            for(int i=1;i<20;i++){
                store[i]= 2*store[i-1];
            }
            StringBuilder sb =new StringBuilder();
            for(int i=0;i<N;i++){
                st=new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                
                switch(cmd){
                    case "add": int x = Integer.parseInt(st.nextToken());
                                int t = store[20-x];
                                set = set | t;
                                //System.out.println(Integer.toBinaryString(set));
                                break;
                    case "remove": int y = Integer.parseInt(st.nextToken());
                                   int m = store[20-y];
                                   int p = 0b11111111111111111111 ^ m;
                                   set = set & p;
                                   //System.out.println(Integer.toBinaryString(set));
                                   break;
                    case "check": int z = Integer.parseInt(st.nextToken());
                                  //System.out.println(""+(set/store[20-z])%2);
                                  sb.append((set/store[20-z])%2+"\n");
                                  break;
                    case "toggle": int w = Integer.parseInt(st.nextToken());
                                   int k = store[20-w];
                                   set = set ^ k;
                                   //System.out.println(Integer.toBinaryString(set));
                                   break;
                    case "all": set = 0b11111111111111111111;
                                break;
                    case "empty": set = 0b000000;
                                 break;
                }
                
            }
            System.out.print(sb.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
