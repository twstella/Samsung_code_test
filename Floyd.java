//11404
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd {
    static int N;
    static long[][] map;
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
    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==INF) System.out.print("0 ");
                else System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N= Integer.parseInt(br.readLine());
            map =new long[N][N];
            int M = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    map[i][j] = INF;
                    if(i==j) map[i][j] =0;
                }
            }
            for(int i=0;i<M;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken())-1;
                int b = Integer.parseInt(st.nextToken())-1;
                int c = Integer.parseInt(st.nextToken());
                if(c<map[a][b]) map[a][b] = c;
            }
            allPath();
            print();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
