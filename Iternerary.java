//1976

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Iternerary {
    static int N;
    static int M;
    static int[] prt;
    static int[] rnk;
    static int[][] map;
    static int[] it;
    static int find(int x){
        if(x==prt[x]) return x;
        int t = find(prt[x]);
        prt[x] = t;
        return t;
    }
    static void print(){
        for(int i=0;i<M-1;i++){
            int x = find(it[i]);
            int y = find(it[i+1]);
            if(x!=y){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        if(rnk[x]<rnk[y]) prt[x] = y;
        else prt[y]=x;
        if(rnk[x]==rnk[y]) rnk[x]++;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            prt=new int[N+1];
            rnk=new int[N+1];
            map =new int[N][N];
            for(int i=1;i<=N;i++){
                prt[i]=i;
            }
            for(int i=0;i<N;i++){
                StringTokenizer st =new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]==1){
                        int a = find(i+1);
                        int b = find(j+1);
                        union(a,b);
                    }
                }
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            it = new int[M];
            for(int i=0;i<M;i++){
                it[i] = Integer.parseInt(st.nextToken());
            }
            print();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
