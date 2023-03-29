//2075
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Num implements Comparable<Num>{
    int n;
    int col;
    Num(int x,int c){
        n=x;
        col=c;
    }
    public int compareTo(Num o){
        return o.n-n;
    }
}
public class NthNum {
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            int[] tmp = new int[N];
            StringTokenizer st = new StringTokenizer("");
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            PriorityQueue<Num> pq = new PriorityQueue<>();
            for(int i=0;i<N;i++){
                tmp[i]=N-2;
                pq.add(new Num(arr[N-1][i],i));
            }
            for(int i=0;i<N-1;i++){
                Num m = pq.poll();
                int c = m.col;
                pq.add(new Num(arr[tmp[c]][c],c));
                tmp[c]--;
            }
            System.out.println(pq.poll().n);
        }
        catch(IOException e){

        }
    }
}
