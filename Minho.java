//1507
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Minho {
    static int N;
    static int[][] map;
    static int[][] A;
    public static int checkRoad(){
        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==k||k==j||i==j) continue;
                    if(map[i][j]>map[i][k]+map[k][j]) return -1;
                    else if(map[i][j]==map[i][k]+map[k][j]) A[i][j]=0;
                }
            }
        }
        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sum+=A[i][j];
            }
        }
        return sum/2;
    }
     
    public static void main(String[] args){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            map=new int[N][N];
            A = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    int k = Integer.parseInt(st.nextToken());
                    map[i][j] = k;
                    A[i][j] = k;
                }
            }
            System.out.println(checkRoad());

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
