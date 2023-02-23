//11403
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AllPath {
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
    static void print(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]==INF)
                    System.out.print("0 ");
                else System.out.print("1 ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer (br.readLine());
                for(int j=0;j<N;j++){
                    int k = Integer.parseInt(st.nextToken());
                    if(k==0) map[i][j] =INF;
                    else map[i][j] = k;
                }
            }
            allPath();
            print();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
