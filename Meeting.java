//20009
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

class Boy{
    int[] pref;
    int pos;

    Boy(int[] p){
        pref = p;
        pos = 0;
    }
}
class Girl{
    int[] pref;
    int match;
    Girl(int[] p){
        pref = p;
        match = -1;
        
    }
    int couple(int a){
        if(match==-1){
            match = a;
            return -1;
        }
        else{
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
}
public class Meeting {
    static int N;
    static HashMap<String,Integer> nm;
    static Boy[] boy;
    static Girl[] girl;
    static String[] boyname;
    static String[] girlname;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N= Integer.parseInt(st.nextToken());
            boy = new Boy[N];
            girl = new Girl[N];
            boyname = new String[N];
            girlname = new String[N];
            st = new StringTokenizer(br.readLine());
            nm = new HashMap<>();
            for(int i=0;i<N;i++){
                String name = st.nextToken();
                nm.put(name,i);
                boyname[i] = name;
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
                String name = st.nextToken();
                nm.put(name, i);
                girlname[i] = name;
            }
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String bb = st.nextToken();
                int[] tmp = new int[N];
                for(int j=0;j<N;j++){
                    tmp[j] = nm.get(st.nextToken());
                }
                boy[nm.get(bb)] = new Boy(tmp);
            }
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                String gg = st.nextToken();
                int[] tmp = new int[N];
                for(int j=0;j<N;j++){
                    tmp[j] = nm.get(st.nextToken());
                }
                girl[nm.get(gg)] = new Girl(tmp);
            }
            int chal,tar;
            for(int i=0;i<N;i++){
                chal = i;
                while(true){
                    Boy t = boy[chal];
                    tar = t.pref[t.pos];
                    t.pos++;
                    chal = girl[tar].couple(chal);
                    if(chal==-1) break;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<N;i++){
                sb.append(boyname[girl[i].match]+" "+girlname[i]+"\n");
            }
            System.out.print(sb.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
