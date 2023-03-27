//1043
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Liar {
    static int N,M;
    static int[] avoid;
    static int[] parent;
    static int[] rank;
    static int find(int x){
        if(parent[x]==x) return x;
        int t=find(parent[x]);
        parent[x]=t;
        return t;
    }
    static void union(int x,int y){
        x = find(x);
        y = find(y);
        if(x==y) return;
        
        if(rank[x]<rank[y]) parent[x]=y;
        else parent[y]=x;

        if(rank[x]==rank[y]) rank[x]++;
    }
    public static void main (String[] args){
        try{
            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            parent=new int[N];
            rank = new int[N];
            int a = Integer.parseInt(st.nextToken());
            if(a!=0){
                avoid = new int[a];
                for(int i=0;i<a;i++){
                    avoid[i] = Integer.parseInt(st.nextToken())-1;
                }
                //ArrayList<ArrayList<Integer> > map = new ArrayList<ArrayList<Integer> >();
                ArrayList<ArrayList<Integer> > tmp = new ArrayList<ArrayList<Integer> >();
                for(int i=0;i<N;i++){
                   //ArrayList<Integer> t = new ArrayList<Integer>();
                    //map.add(t);
                    parent[i]=i;
                }
                for(int i=0;i<M;i++){
                    ArrayList<Integer> t = new ArrayList<Integer>();
                    st = new StringTokenizer(br.readLine());
                    int n = Integer.parseInt(st.nextToken());
                    for(int j=0;j<n;j++){
                        t.add(Integer.parseInt(st.nextToken())-1);
                    }
                    for(int j=0;j<n-1;j++){
                        union(t.get(j),t.get(j+1));
                    }
                    tmp.add(t);
                }
                int cnt =0;
                HashSet<Integer> avd = new HashSet<Integer>();
                for(int i=0;i<avoid.length;i++){
                    avd.add(find(avoid[i]));
                }
                for(int i=0;i<tmp.size();i++){
                    ArrayList<Integer> t = tmp.get(i);
                    boolean flag = true;
                    for(int j:t){
                        if(avd.contains(find(j))){
                            flag=false;
                            break;
                        }
                    }
                    if(flag==true) cnt++;
                }
                System.out.println(cnt);
            }
            else{
                for(int i=0;i<M;i++){
                    st=new StringTokenizer(br.readLine());
                }
                System.out.println(M);
            }

        }catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
