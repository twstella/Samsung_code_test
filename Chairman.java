//2660
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Chairman {
    static int N;
    static int[][] map;
    static int INF = 10000000;
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
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j]=INF;
                    if(i==j) map[i][j] = 0;
                }
            }
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                if(a<=0&&b<0) break;
                map[a][b] = 1;
                map[b][a] =1;
            }
            allPath();
            int min = INF;
            ArrayList<Integer> res = new ArrayList<Integer>();
            for(int i=0;i<N;i++){
                int max = Integer.MIN_VALUE;
                for(int j=0;j<N;j++){
                    max = Math.max(max,map[i][j]);
                }
                if(min>max){
                    res = new ArrayList<Integer>();
                    min = max;
                    res.add(i+1);
                }
                else if(max==min){
                    res.add(i+1);
                }
            }
            Collections.sort(res);
            String s ="";
            for(int i:res){
                s+=i+" ";
            }
            System.out.println(min+" "+res.size());
            System.out.println(s);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

