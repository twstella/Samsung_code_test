//21940
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Greetings {
    static int N,M;
    static int[][] map;
    static int INF=10000000;
    static void allPath(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = Math.min(map[i][j],map[i][k]+map[k][j]);
                }
            }
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) map[i][j]=0;
                    else map[i][j] = INF;
                }
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                map[a][b] =c;
            }
            allPath();
            int L = Integer.parseInt(br.readLine());
            int[] frnd = new int[L];
            st = new StringTokenizer(br.readLine());
            for(int i=0;i<L;i++){
                frnd[i] = Integer.parseInt(st.nextToken())-1;
            }
            int min =INF;
            ArrayList<Integer> l = new ArrayList<Integer>();
            for(int i=0;i<N;i++){
                int max = -1;
                for(int j=0;j<L;j++){
                    max = Math.max(max,map[i][frnd[j]]+map[frnd[j]][i]);
                }
                if(max<min){
                    l = new ArrayList<Integer>();
                    l.add(i+1);
                    min = max;
                }
                else if(min==max){
                    l.add(i+1);
                }
            }
            Collections.sort(l);
            String s ="";
            for(int n:l){
                s+=n+" ";
            }
            System.out.println(s);

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
