//1963
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prime {
    static boolean isPrime(int n){
        int  t= (int)Math.sqrt(n);
        for(int i=2;i<=t;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    static int[] splt;
    static int makeNum(int[] d){
        int s= 0;
        for(int i=0;i<4;i++){
            s=s*10+d[i];
        }
        return s;
    }
    static int bfs(int st,int to){
        
        if(st==to) return 0;
        int [] V = new int[100000];
        int[] q = new int[100000];
        V[st]=1;
        int frnt=0,rr=0;
        q[rr++]=st;
        int cnt=0;
        while(frnt!=rr){
            int ll = rr-frnt;
            for(int i=0;i<ll;i++){
                int e = q[frnt++];
                //System.out.println(e);
                if(e==to) return cnt;
                splt=new int[4];
                int[] tmp=new int[4];
                String t = Integer.toString(e);
                for(int j=0;j<4;j++){
                    splt[j] = t.charAt(j)-'0';
                    tmp[j]=splt[j];
                }
                for(int j=0;j<4;j++){
                    for(int k=0;k<j;k++){
                        tmp[k]=splt[k];
                    }
                    for(int k=0;k<=9;k++){
                        if(k==0&&j==0) continue;
                        if(k==splt[j]) continue;
                        tmp[j]=k;
                        int mkn = makeNum(tmp);
                        if(isPrime(mkn)&&V[mkn]==0){
                            V[mkn]=1;
                            q[rr++]=mkn;
                        }
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
    public static void main(String[] args){
    
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            for(int i=0;i<t;i++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                System.out.println(bfs(n,m));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
