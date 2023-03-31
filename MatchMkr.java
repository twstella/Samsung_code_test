//9002
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

class Man{
    int[] pref;
    int pos;
    Man(int[] p){
        pref = p;
        pos = 0;
    }
}
class Woman{
    int[] pref;
    int match;
    Woman(int[] p){
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
                match =c;
                return a;
            }
        }
        return -1;
    }
}
public class MatchMkr {
    static int N;
    static Man[] man;
    static Woman[] woman;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            for(int i=0;i<T;i++){
                st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                man = new Man[N];
                woman = new Woman[N];
                for(int j=0;j<N;j++){
                    st = new StringTokenizer(br.readLine());
                    int[] tmp = new int[N];
                    for(int k=0;k<N;k++){
                        tmp[k]=Integer.parseInt(st.nextToken())-1;
                    }
                    man[j] = new Man(tmp);
                }
                for(int j=0;j<N;j++){
                    st = new StringTokenizer(br.readLine());
                    int[] tmp = new int[N];
                    for(int k=0;k<N;k++){
                        tmp[k]= Integer.parseInt(st.nextToken())-1;
                    }
                    woman[j] = new Woman(tmp);
                }
                int chal=0,tar =0;
                for(int j=0;j<N;j++){
                    chal = j;
                    while(true){
                        Man t = man[chal];
                        tar = t.pref[t.pos];
                        t.pos++;
                        chal = woman[tar].connect(chal);
                        if(chal == -1) break;
                    }
                }
                int[] res = new int[N];
                for(int j=0;j<N;j++){
                    res[woman[j].match] = j+1;
                }
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<N;j++) sb.append(res[j]+" ");
                System.out.println(sb.toString());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
