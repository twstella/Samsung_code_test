package samsung_expert;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.ArrayList;
class Bolt{
    int hd,tl;
    Bolt(int m,int f){
        hd = m;
        tl = f;
    }
}
public class Nasa {
    static int N;
    static Bolt[] box;
    static int visited[];
    static ArrayList<Bolt> q;
    
    static String find(){
        q.add(box[0]);
        visited[0] = 1;
        while(q.size()<N){
            int frt = q.get(0).hd;
            int bck = q.get(q.size()-1).tl;
            for(int i=1;i<N;i++){
                if(visited[i]==0){
                    if(frt==box[i].tl){
                        q.add(0,box[i]);
                        visited[i] = 1;
                        break;
                    }
                    else if(bck==box[i].hd){
                        q.add(box[i]);
                        visited[i] = 1;
                        break;
                    }
                }
            }
        }
        String rst = "";
        for(Bolt b:q){
            rst+=" "+b.hd+" "+b.tl;
        }
        return rst;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine());
            for(int test=1;test<=T;test++){
                N = Integer.parseInt(br.readLine());
                box = new Bolt[N];
                visited=new int[N];
                q = new ArrayList<Bolt>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i=0;i<N;i++){
                    int m = Integer.parseInt(st.nextToken());
                    int f = Integer.parseInt(st.nextToken());
                    box[i] = new Bolt(m,f);
                }
               String r = find();
               System.out.println("#"+test+r);
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
