package samsung_expert;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;


class MyTree{
    int l,r;
    MyTree(int le,int ri){
        l = le;
        r = ri;
    }
    void add(int k){
        if(l==-1) l = k;
        else r = k;
    }
}
public class CommonAnsc {
    static int[] parent;
    static int V,E;
    static int getRoot(int n1,int n2){
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int p = n1;
        while(p!=-1){
            tmp.add(parent[p]);
            p = parent[p];
        }
        p = n2;
        while(p!=-1){
            if(tmp.contains(parent[p])) return parent[p];
            p = parent[p];
        }
        return -1;
    }
    static int count(MyTree[] tree,int idx){
        int sum = 0;
        if(tree[idx].l!=-1){sum+=count(tree,tree[idx].l);}
        if(tree[idx].r!=-1){sum+=count(tree,tree[idx].r);}
        return sum+1;

    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            for(int test_case=1;test_case<=T;test_case++){
                st = new StringTokenizer(br.readLine());
                V = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                st = new StringTokenizer(br.readLine());
                parent = new int[V+1];
                MyTree[] tree = new MyTree[V+1];
                for(int i=0;i<tree.length;i++){
                    tree[i] = null;
                    parent[i] =-1;
                }
                for(int i=0;i<E;i++){
                    int t = Integer.parseInt(st.nextToken());
                    int m = Integer.parseInt(st.nextToken());
                    parent[m] = t;
                    if(tree[t]==null){
                        tree[t] = new MyTree(-1, -1);
                        tree[t].add(m);
                        if(tree[m]==null) tree[m] = new MyTree(-1,-1);
                    }
                    else{
                        tree[t].add(m);
                        if(tree[m]==null) tree[m] = new MyTree(-1,-1);
                    }
                }
                int com = getRoot(n1,n2);
                System.out.println("#"+test_case+" "+com+" "+count(tree, com));
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
