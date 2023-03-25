//16397
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
public class Escape {
    static int N,T,G;
    static int bfs(int n){
        int[] V = new int[100000];
        int rr=0,frnt=0;
        int[] q = new int[200000];
        int cnt=0;
        V[n]=1;
        q[rr++]=n;
        while(frnt!=rr){
            int ll = rr-frnt;
            for(int i=0;i<ll;i++){
                int t = q[frnt++];
                if(t==G) return cnt;

                int nxt = next(t);
                if(nxt!=-1&&V[nxt]==0){
                    V[nxt]=1;
                    q[rr++]=nxt;
                }
                nxt = t+1;
                if(0<=nxt&&nxt<=99999&&V[nxt]==0){
                    V[nxt]=1;
                    q[rr++]=nxt;
                }
            }
            T--;
            if(T<0) return -1;
            cnt++;
        }
        return -1;
    }
    
    static int next(int n){
        if(n==0) return 0;
        n *=2;
        if(n>99999) return -1;
        int u =(int)Math.log10(n);
        u = (int)Math.pow(10, u);
        return n-u;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            T=Integer.parseInt(st.nextToken());
            G= Integer.parseInt(st.nextToken());
            if(N==G) System.out.println(0);
            else{
                int res = bfs(N);
                if (res!=-1)
                    System.out.println(res);
                else System.out.println("ANG");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
