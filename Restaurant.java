//21219
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

class Guest{
    int[] pref;
    int pos;
    Guest(int[] p){
        pref = p;
        pos = 0;
    }
}
class Info implements Comparable<Info>{
    int p,id;
    Info(int a,int b){
        p = a;
        id = b;
    }
    public int compareTo(Info o){
        return p-o.p;
    }
}
class Store{
    HashMap<Integer,Integer> pref;
    PriorityQueue<Info> pq;
    int capa;
    Store(int cp){
        pref = new HashMap<>();
        capa = cp;
        pq = new PriorityQueue<>();
    }
    int match(int chal){
        pq.add(new Info(pref.get((Integer)chal),chal));
        if(capa>=pq.size()) return -1;
        Info ff = pq.poll();
        return ff.id;
    }
}
public class Restaurant {
    static int N,M;
    static Guest[] guest;
    static Store[] rest;
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            guest = new Guest[N];
            rest = new Store[M];
            for(int i=0;i<M;i++){
                rest[i] = new Store(Integer.parseInt(br.readLine()));
            }
            for(int i=0;i<N;i++){
                String[] t = br.readLine().split(" ");
                int[] pp = new int[t.length];
                for(int j=0;j<pp.length;j++){
                    pp[j] = Integer.parseInt(t[j])-1;
                }
                guest[i] = new Guest(pp);
            }
            for(int i=0;i<M;i++){
                String[] t = br.readLine().split(" ");
                int[] pp = new int[t.length];
                for(int j=0;j<pp.length;j++){
                    pp[j] = Integer.parseInt(t[j])-1;
                }
                if(pp[0]==-1) continue;
                for(int j=0;j<pp.length;j++){
                    rest[i].pref.put(pp[j],-j);
                }
                
            }
            for(int i=0;i<N;i++){
                int chal = i;
                while(true){
                    if(guest[chal].pos>=guest[chal].pref.length) break;
                    int tar = guest[chal].pref[guest[chal].pos];
                    guest[chal].pos++;
                    int l = rest[tar].match(chal);
                    if(l==-1) break;
                    chal = l;
                }
            }
            ArrayList<Integer> al = new ArrayList<>();
            for(int i=0;i<M;i++){
                while(!rest[i].pq.isEmpty())
                    al.add(rest[i].pq.poll().id);
            }
            Collections.sort(al);
            StringBuilder sb = new StringBuilder();
            for(int e:al)
                sb.append((e+1)+"\n");
            System.out.print(sb.toString());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
