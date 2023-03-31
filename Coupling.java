//12022
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
class Male{
    int[] pref;
    int pos;
    Male(int[] p){
        pref = p;
        pos = 0;
    }
}
class Female{
    int[] pref;
    int match;
    Female(int[] p){
        pref = p;
        match = -1;
    }
    int connect(int a){
        if(match==-1){
            match = a;
            return -1;
        }
        int c = match;
        for(int i=0;i<pref.length;i++){
            if(pref[i]==a){
                match = a;
                return c;
            }
            else if(pref[i]==c){
                match = c;
                return a;
            }
        }
        return -1;
    }
}
public class Coupling {
    static int N;
    static Male[] male;
    static Female[] female;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int chal=0,tar=0;
            male = new Male[N];
            female = new Female[N];
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int[] tmp = new int[N];
                for(int j=0;j<N;j++){
                    tmp[j]=Integer.parseInt(st.nextToken())-1;
                }
                male[i] = new Male(tmp);
            }
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                int[] tmp = new int[N];
                for(int j=0;j<N;j++){
                    tmp[j] = Integer.parseInt(st.nextToken())-1;
                }
                female[i] = new Female(tmp);
            }
            for(int i=0;i<N;i++){
                chal = i;
                while(true){
                    Male t = male[chal];
                    tar = t.pref[t.pos];
                    t.pos++;
                    chal = female[tar].connect(chal);
                    if(chal==-1) break;
                }
            }
            int[] res = new int[N];
            for(int i=0;i<N;i++){
                res[female[i].match]=i+1;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++) sb.append(res[i]+"\n");
            System.out.print(sb.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
