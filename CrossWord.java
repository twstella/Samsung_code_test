import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.TreeSet;
public class CrossWord {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N,M;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            String[] S1 = new String[N];
            String[] S2 = new String[M];
            for(int i=0;i<M;i++)
                S2[i] = "";
            for(int i=0;i<N;i++){
                S1[i] = br.readLine();
                for(int j=0;j<M;j++){
                    S2[j]+=S1[i].charAt(j);
                }
            }
            TreeSet<String> ts = new TreeSet<>();
            for(int i=0;i<N;i++){
                String[] tmp = S1[i].split("#");
                for(int j=0;j<tmp.length;j++){
                    if(tmp[j].length()>1){
                        ts.add(tmp[j]);
                    }
                }
            }
            for(int i=0;i<M;i++){
                String[] tmp = S2[i].split("#");
                for(int j=0;j<tmp.length;j++){
                    if(tmp[j].length()>1)
                        ts.add(tmp[j]);
                }
            }
            System.out.println(ts.first());
        }
        catch(IOException e){
            e.printStackTrace();
        }
       
    }
}