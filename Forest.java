//4803

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

class Line{
    int x,y;
    Line(int a,int b){
        x=a;
        y =b;
    }
}
public class Forest {
    static int N,M;
    static Line[] li;
    static int[] prt;
    static int[] rnk;
    static int find(int x){
        if(x==prt[x]) return x;
        int t = find(prt[x]);
        prt[x] = t;
        return t;
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        if(rnk[x]<rnk[y]) prt[x]=y;
        else prt[y] = x;
        if(rnk[x]==rnk[y]) rnk[x]++;
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int cas = 1;
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                if(N==0&&M==0) break;
                prt = new int[N+1];
                rnk = new int[N+1];
                li = new Line[M];
                for(int i=0;i<N;i++){
                    prt[i] = i;
                }
                ArrayList<Integer> cyc = new ArrayList<Integer>();
                for(int i=0;i<M;i++){
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int x = find(a);
                    int y = find(b);
                    if(x==y) cyc.add(a);
                    union(x,y);
                }
                HashSet<Integer> set = new HashSet<Integer>();
                for(int i=1;i<=N;i++){
                    set.add(find(i));
                }
                for(int e:cyc){
                    set.remove(find(e));
                }
                int siz = set.size();
                if(siz==0)
                    System.out.println("Case "+cas+": No trees.");
                else if(siz==1)
                    System.out.println("Case "+cas+": There is one tree.");
                else 
                    System.out.println("Case "+cas+": A forest of "+siz+" trees.");
                cas++;
            }


        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
