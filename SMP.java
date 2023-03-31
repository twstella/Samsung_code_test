//3761 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

class Boyb{
    int[] pref;
    int pos;
    char id;
    Boyb(int[] p,char i){
        pref = p;
        pos = 0;
        id = i;
    }
}
class Girlg{
    int[] pref;
    int match;
    char id;
    Girlg(int[] p, char ch){
        pref = p;
        match =-1;
        id = ch;
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
public class SMP {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<t;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken());
                Boyb[] boy = new Boyb[N];
                Girlg[] girl = new Girlg[N];
                int[] mapl =  new int[26];
                int[] mapu = new int[26];
                Arrays.fill(mapl,-1);
                Arrays.fill(mapu,-1);
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    String l = st.nextToken();
                    int e = (int)(l.charAt(0)-'a');
                    mapl[e] = j;
                }
                for(int j=0;j<N;j++){
                    String u = st.nextToken();
                    int e = (int)(u.charAt(0)-'A');
                    mapu[e] = j;
                }
                for(int j=0;j<N;j++){
                    st = new StringTokenizer(br.readLine());
                    String[] tmp = st.nextToken().split(":");
                    int m = tmp[0].charAt(0)-'a';
                    m = mapl[m];
                    int[] p = new int[N];
                    for(int k=0;k<N;k++){
                        int f = (int)(tmp[1].charAt(k)-'A');
                        p[k] = mapu[f];
                    }
                    boy[m] = new Boyb(p,tmp[0].charAt(0));
                }
                for(int j=0;j<N;j++){
                    st = new StringTokenizer(br.readLine());
                    String[] tmp = st.nextToken().split(":");
                    int m = tmp[0].charAt(0)-'A';
                    m = mapu[m];
                    int[] p = new int[N];
                    for(int k=0;k<N;k++){
                        int f = (int)(tmp[1].charAt(k)-'a');
                        p[k] = mapl[f];
                    }
                    girl[m] = new Girlg(p, tmp[0].charAt(0));
                }
                int chal=0,tar=0;
                for(int j=0;j<N;j++){
                    chal = j;
                    while(true){
                        Boyb b = boy[chal];
                        tar = b.pref[b.pos];
                        b.pos++;
                        chal = girl[tar].connect(chal);
                        if(chal==-1) break;
                    }
                }
                char[][] res = new char[N][2];
                for(int j=0;j<N;j++){
                    res[j][0] = boy[girl[j].match].id;
                    res[j][1] = girl[j].id;
                }
                Arrays.sort(res,new Comparator<char[]>(){
                    public int compare(char[] o1,char[] o2){
                        return ((int)o1[0]-(int)o2[0]);
                    }
                });
                for(int j=0;j<N;j++)
                    sb.append(res[j][0]+" "+res[j][1]+"\n");
                sb.append("\n");
            }
            System.out.print(sb.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
